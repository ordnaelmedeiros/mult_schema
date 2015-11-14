(function () {
	'use strict';
	
	angular
		.module('app.services',[])
		.factory('DataServiceRest', DataService);

		function DataService($http){
			return {
				get: function(){
					return $http.get('http://localhost:8080/MultSchema/rest/propriedade');
				}
			}
		}
})();
