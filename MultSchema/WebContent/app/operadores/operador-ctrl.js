(function() {

	'use strict';

	angular
		.module("app.controllers",[])
		.controller("OperadorCtrl", OperadorCtrl);
		
		function OperadorCtrl(DataServiceRest){
			var self = this;
			
			self.salvarItem = function(){
				console.log(angular.toJson(self.propriedades));	
				DataServiceRest.updateItem("propriedade", angular.toJson(self.propriedades));
			}
			
			
			//Chama a service genérica que retorna uma lista do objeto passado por parâmetro
			DataServiceRest.getList("propriedade").success(
				function(resposta) {
					self.propriedades = resposta;
				}
			).error(function (error){
				self.status = 'Erro ao carregar informações: '+error.message;
				console.log(" "+self.status);
			});
			
			
			
		}
	
})();