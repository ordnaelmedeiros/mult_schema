(function() {
	'use strict';

	angular
		.module('app', [
		/*Angular Modules*/                    
			'ngMaterial',
			'ngMessages',
			'ngRoute',
			'app.services',
			'app.controllers'
		])
		.constant("urlbase", {
			url: "http://localhost:8080"
		})
		.controller('AppCtrl', ['$scope', '$mdSidenav', 
		function($scope, $mdSidenav, $rootScope, $location){
			$scope.toggleSidenav = function(menuId) {
		    $mdSidenav(menuId).toggle();
		};
	  
		 $scope.isOpen = false;
		 $scope.demo = {
				 isOpen: false,
				 count: 50,
				 selectedAlignment: 'md-right'
		  };
	  
		 $scope.menu = [
	     {
	       title: 'Home',
	       rota:'home',
	       icon: 'dashboard',
	       tipo:'link'
	     },
	     {
	       title: 'Sobre',
	       rota:'sobre',
	       icon: 'dashboard',
	       tipo:'link'
	     },
	     {
	         title: 'Tela 1',
	         rota:'tela1',
	         icon: 'dashboard',
	         tipo:'link'
	       }
	    ]
	  
		 $scope.iconFavorite = "app/assets/img/icons/ic_favorite_border_white_48px.svg";
	  
		 $scope.trocaCoracao = function() {
		  
			 if ($scope.iconFavorite=="app/assets/img/icons/ic_favorite_white_48px.svg") {
				 $scope.iconFavorite = "app/assets/img/icons/ic_favorite_border_white_48px.svg";
			 } else {
				 $scope.iconFavorite = "app/assets/img/icons/ic_favorite_white_48px.svg";
			 }
			 
		  } 
	}]);
})();

