(function () {
    'use strict';
    function Api ($q, $http) {

        var url = {
            base: 'http://192.168.20.17:8080/webshop/api/'
            // base: 'localhost'
        }

        function success(res) {
            return res;
        }

        function error(err){
            return $q.reject(err);
        }

        this.getProducts = function () {
            return $http.get(url.base + 'item/').then(success, error);
        };

        this.loginUser = function (username, password) {
            var params = {};
            params.username = username;
            params.password = password;
            return $http.post(url.base + 'user/login/', params).then(success, error);
        };
        
        this.checkout = function (params) {
            return $http.post(url.base + 'order/create/', params).then(success, error);
        };

    }

    angular
        .module('app')
        .service('Api', Api);
}());