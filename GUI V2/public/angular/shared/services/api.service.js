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

        this.loginRestaurant = function (username, password) {
            console.log(username)
            var params = {};
            params.username = username;
            params.password = password;
            return $http.post(url.base + 'restaurant/login', params).then(success, error);
        };

        this.createRestaurant = function (params) {
            return $http.post(url.base + 'restaurant/create', params).then(success, error);
        };


        this.createUser = function (params) {
            return $http.post(url.base + 'user/create', params).then(success, error);
        };


        this.checkout = function (params) {
            console.log(params);
            return $http.post(url.base + 'order/create/', params).then(success, error);
        };

        this.addItemToOrder = function (restaurantUsername, item) {
            item.restaurant = restaurantUsername; //for testing purposes
            return $http.post(url.base+'item/create',item).then(success,error);
        }

        this.getRestaurant = function (name) {
            return $http.get(url.base+'restaurant/restaurant_Name/'+ name).then(success,error);
        }

        //add comment to restaurnt preview page
        this.addComment = function (params) {
            console.log(params);

            return $http.post(url.base+'restaurant/comment', params).then(success, error)

        }

    }

    angular
        .module('app')
        .service('Api', Api);
}());