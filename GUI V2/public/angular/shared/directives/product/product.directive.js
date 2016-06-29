(function () {
    'use strict';
    function product (ShoppingCart) {
        /**
         * @name link
         * @desc Directive link
         */
        function link (scope, elem, attrs) {
            scope.addProduct = function(item) {
                ShoppingCart.addItem(item);
            }
        }

        return {
            restrict: 'E',
            link: link,
            templateUrl: 'angular/shared/directives/product/product.tpl.html',
            scope: {
                product: '='
            }
        }
    }

    angular
        .module('app')
        .directive('product', product);

}());
