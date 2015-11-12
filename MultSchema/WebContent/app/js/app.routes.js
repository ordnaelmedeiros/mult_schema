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
    templateUrl: 'app/views/tela-home.html',
  })
  .when('/login', {
    controller: 'LoginController',
    templateUrl: 'views/login.html',
    controllerAs: 'vm'
  })
  .otherwise('/');
};

})();
