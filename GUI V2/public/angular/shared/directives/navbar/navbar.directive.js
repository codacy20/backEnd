(function () {
    'use strict';
    function navbar (UserStore) {
        /**
         * @name link
         * @desc Directive link
         */
        function link (scope, elem, attrs) {
            scope.user = UserStore.getUserInfo();

            scope.logout = function() {
                UserStore.logout();
                scope.user = undefined;
            }

            scope.$on('login', function () {
                scope.user = undefined;
                scope.user = UserStore.getUserInfo();
            })

        }

        return {
            restrict: 'E',
            link: link,
            templateUrl: 'angular/shared/directives/navbar/navbar.tpl.html'
        }
    }

    angular
        .module('app')
        .directive('navbar', navbar);

}());