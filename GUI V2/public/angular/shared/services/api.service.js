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

        this.getBid = function (amount) {
            return $http.post(url.base + 'item/surpriseme', {"amount": amount}).then(success, error);
        };

        this.loginRestaurant = function () {
            return $http.get(url.base).then(success, error);
        };

        this.getCustomer = function (id) {
            return $http.get(url.base + '/' + id);
        };

        this.insertCustomer = function (cust) {
            return $http.post(url.base, cust);
        };

        this.updateCustomer = function (cust) {
            return $http.put(url.base + '/' + cust.ID, cust)
        };

        this.deleteCustomer = function (id) {
            return $http.delete(url.base + '/' + id);
        };

        this.getOrders = function (id) {
            return $http.get(url.base + '/' + id + '/orders');
        };
    }

    angular
        .module('app')
        .service('Api', Api);
}());