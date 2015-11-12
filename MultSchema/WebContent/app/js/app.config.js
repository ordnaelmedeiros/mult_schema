(function() {
  'use strict';

  angular.module('app')
  .run(AppSecurity);

  function AppSecurity($rootScope, $location, AutenticaService){
    $rootScope.$on('$routeChangeStart',function(event, next, current) {

      console.log('->', $location.path());

      if ($location.path() == '/cadastro'){

        if (!AutenticaService.logado()) {
          $location.path('/login');
        }

      }
    });
  }

})();
