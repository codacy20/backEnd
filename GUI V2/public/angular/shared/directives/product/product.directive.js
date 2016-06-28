(function () {
    'use strict';
    function product ($parse) {
        /**
         * @name link
         * @desc Directive link
         */
        function link (scope, elem, attrs) {

        }

        return {
            restrict: 'E',
            link: link,
            templateUrl: 'angular/shared/directives/product/product.tpl.html',
            scope: {
                name: '@',
                price: '@',
                imageurl: '@',
                restaurant: '@'
            }
        }
    }

    angular
        .module('app')
        .directive('product', product);

}());
