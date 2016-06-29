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
            console.log(params);
            return $http.post(url.base + 'order/create/', params).then(success, error);
        };

        //add item to Order
        this.addItemToOrder = function (restaurantUsername, item) {
            console.log(item);
            item.restaurant = "laplace"; //for testing purposes
            console.log(item);
            return $http.post(url.base+'item/create',item).then(success,error);//
            // console.log(item);
        }

    }

    angular
        .module('app')
        .service('Api', Api);
}());