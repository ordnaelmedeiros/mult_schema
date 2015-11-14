(function() {

	'use strict';

	angular
		.module("app.controllers",[])
		.controller("OperadorCtrl", OperadorCtrl);

	function OperadorCtrl(DataServiceRest){
		var self = this;
		console.log('teste'+DataServiceRest.get());
		
	}

})();