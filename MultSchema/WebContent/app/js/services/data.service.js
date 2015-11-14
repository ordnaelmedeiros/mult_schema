(function () {
	'use strict';
	
	angular
		.module('app.services',[])
		.factory('DataServiceRest', DataService);
		/*
		 * Função Genérica para consultas REST
		 * Dependências $http e ambiente(Constante já definida no app.module)
		 * 
		 * */
		function DataService($http, ambiente){
			return {
				//Retorna uma lista de um determinado objeto
				getList: function(obj){
					return $http.get(ambiente.url+'/rest/'+obj);
				},
				//Retorna um objeto específico
				getId: function(obj,id){
					return $http.get(ambiente.url+'/rest/'+obj+'/'+id);
				}
			}
		}
})();
