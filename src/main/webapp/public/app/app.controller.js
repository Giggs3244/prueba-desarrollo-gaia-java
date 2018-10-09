(function () {
  'use strict';

  angular.module('HeladosApp').controller('heladosController', heladosController);

  heladosController.inject = ['Services', '$sce', '$rootScope', '$scope'];

  function heladosController(Services, $sce, $rootScope, $scope) {
      var vm = this;
  }

})();