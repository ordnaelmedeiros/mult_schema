(function() {

angular.module('app')
.config(RouteProvider);

RouteProvider.$inject = [
  '$routeProvider'
];

function RouteProvider($routeProvider)
{
  $routeProvider
  .when('/', {
    controller: 'HomeController',
    templateUrl: 'app/views/tela-home.html',
    controllerAs: 'vm'
  })
  .when('/login', {
    controller: 'LoginController',
    templateUrl: 'views/login.html',
    controllerAs: 'vm'
  })
  .otherwise('/');
};

})();
