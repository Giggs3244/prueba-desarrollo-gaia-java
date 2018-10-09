(function () {
    'use strict';
    angular.module('HeladosApp').factory('Services', Services);

    Services.$inject = [ '$http', 'header_content_json', 'constants' ];

    function Services($http, header_content_json, constants) {

        var services = {
            invokeRequestPost : invokeRequestPost,
            invokeRequestGet : invokeRequestGet,
            invokeRequestDelete : invokeRequestDelete
        };

        return services;
        
        function invokeRequestPost(url, params) {
            return $http.post(url, params, {
                headers : header_content_json,
                responseType : constants.response_type_json
            });
        }
        
        function invokeRequestGet(url) {
            return $http.get(url, {
                headers : header_content_json,
                responseType : constants.response_type_json
            });
        }
        
        function invokeRequestDelete(url) {
            return $http.delete(url, {
                headers : header_content_json,
                responseType : constants.response_type_json
            });
        }

    }

})();