(function () {
    'use strict';
    function RegisterRoute ($stateProvider) {
        $stateProvider
            .state('app.register-login.user-login', {
                templateUrl: 'user-login.tpl.html',
                url: '/user-login'
            })
            .state('app.register-login.restaurant-login', {
                templateUrl: 'restaurant-login.tpl.html',
                url: '/restaurant-login'
            })
    }


    angular
        .module('app')
        .config(RegisterRoute);
}());