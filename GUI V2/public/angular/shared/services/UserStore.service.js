(function () {
    'use strict';
    function UserStore($http, $q, $window) {
        var userInfo;

        function loginUser(username, password) {
            var deferred = $q.defer();

            $http.post("http://192.168.20.17:8080/webshop/api/user/login", { username: username, password: password })
                .then(function (result) {
                    console.log(result)
                    userInfo = result.data;
                    $window.sessionStorage["userInfo"] = JSON.stringify(userInfo);
                    deferred.resolve(userInfo);
                }, function (error) {
                    deferred.reject(error);
                });

            return deferred.promise;
        }

        function logout() {
            var deferred = $q.defer();

            $http({
                method: "POST",
                url: "/api/logout",
                headers: {
                    "access_token": userInfo.accessToken
                }
            }).then(function (result) {
                userInfo = null;
                $window.sessionStorage["userInfo"] = null;
                deferred.resolve(result);
            }, function (error) {
                deferred.reject(error);
            });

            return deferred.promise;
        }

        function getUserInfo() {
            return userInfo;
        }

        function init() {
            if ($window.sessionStorage["userInfo"]) {
                userInfo = JSON.parse($window.sessionStorage["userInfo"]);
                console.log($window.sessionStorage["userInfo"])
            }
        }
        init();

        return {
            loginUser: loginUser,
            logout: logout,
            getUserInfo: getUserInfo
        };
    }

    angular
        .module('app')
        .factory('UserStore', UserStore);
}());
