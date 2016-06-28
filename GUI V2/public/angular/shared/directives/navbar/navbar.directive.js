(function () {
    'use strict';
    function navbar ($parse) {
        /**
         * @name link
         * @desc Directive link
         */
        function link (scope, elem, attrs) {

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