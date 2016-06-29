(function () {
    'use strict';
    function Api ($q, $http) {

        var url = {
            base: 'http://192.168.20.20:8080/webshop/api/'
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

        this.getBid = function (amount) {
            return $http.post(url.base + 'item/surpriseme', '{"amount": amount}').then(success, error);
        };

        this.loginUser = function (username, password) {
            var params = {};
            params.username = username;
            params.password = password;
            return $http.post(url.base + 'user/login/', params).then(success, error);
        };

        //add item to Order
        this.addItemToOrder = function (restaurantUsername, item) {
            var params = {};
            params.restaurantUsername = restaurantUsername;
            params.item = item;
            return $http.post(url.base);//

        }

    }

    angular
        .module('app')
        .service('Api', Api);
}());