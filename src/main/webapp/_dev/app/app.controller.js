(function () {

  angular.module('HeladosApp').controller('heladosController', heladosController);

  heladosController.inject = ['Services', '$sce', '$rootScope', '$scope', 'endpoints'];

  function heladosController(Services, $sce, $rootScope, $scope, endpoints) {
      var vm = this;
      vm.tiposHelados = [];
      
      vm.init = function() {
          $rootScope.cargando = true;
          var url = endpoints.host + endpoints.api + endpoints.operations.getTiposHeladosList;
          Services.invokeRequestGet(url).then(function(result) {
              vm.tiposHelados = result.data;
          }, function(err) {
              console.log("error cargando los tipos de helados. ", err);
          }).finally(function() {
              $rootScope.cargando = false;
          });
      };

      vm.eliminarTipoHelado = function(indiceTipoHelado) {
          var tipoHelado = vm.tiposHelados[indiceTipoHelado];
          var url = endpoints.host + endpoints.api + endpoints.operations.deleteTipoHelado + "/" + tipoHelado.idTipoHelado;
          Services.invokeRequestDelete(url).then(function(result) {
              console.log("Se elimino el tipo de helado");
              vm.tiposHelados.splice(indiceTipoHelado, 1);
          }, function(err) {
              console.log("error eliminando el tipo de helado", err);
          }).finally(function() {
              $rootScope.cargando = false;
          });
      };
      
  }

})();