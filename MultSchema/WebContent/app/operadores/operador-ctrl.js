(function() {

	'use strict';

	angular
		.module("app.controllers",[])
		.controller("OperadorCtrl", OperadorCtrl);

	function OperadorCtrl(DataServiceRest){
		var self = this;
		
		DataServiceRest.get().success(
			function(resposta) {
				self.propriedades = resposta;
				console.log(" "+self.propriedades);
			}
		).error(function (error){
			self.status = 'Erro ao carregar informações: '+error.message;
			console.log(" "+self.status);
		});
		
	}

})();