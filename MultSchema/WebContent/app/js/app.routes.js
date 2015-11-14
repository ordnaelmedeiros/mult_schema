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
  .when('/propriedades', {
    controller: 'OperadorCtrl',
    templateUrl: 'app/operadores/tela-operador.html',
    controllerAs: 'vm'
  })
  .otherwise('/');
  
};

})();
