(function() {
    'use strict';

var HeladosApp = angular.module('HeladosApp', [ 'ngRoute', 'ngCookies', 'ui.router' ]);

HeladosApp.config(function ($stateProvider, $urlRouterProvider) {

    $urlRouterProvider.otherwise('/');

    $stateProvider.state('home', {
        url : '/',
        controller : 'heladosController as vm',
        templateUrl : urls.consultarTiposHelados
    }).state('createTipoHelado', {
        url : '/registrar',
        controller : 'createTipoHeladoController as vm',
        templateUrl : urls.crearTipoHelado
    }).state('error', {
        url: "/error",
        templateUrl: urls.error
    });
});

HeladosApp.constant('endpoints', {
    host : 'http://localhost:8080',
    api : '/api/v1',
    operations : {
        getTiposHeladosList : '/tiposhelados',
        createTipoHelado: '/tiposhelados',
        deleteTipoHelado: '/tiposhelados'
    }
})

.constant('header_content_json', {
    'Content-Type' : 'application/json',
    'Accept' : '*/*'
})

.constant('constants', {
    response_type_json : 'json',
});

})();