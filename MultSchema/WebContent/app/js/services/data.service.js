(function () {
	'use strict';
	
	angular
		.module('app.services',[])
		.factory('DataServiceRest', DataService);

		function DataService($http, ambiente){
			return {
				get: function(){
					console.log(""+ambiente.url);
					return $http.get(ambiente.url+'/rest/propriedade');
				}
			}
		}
})();
