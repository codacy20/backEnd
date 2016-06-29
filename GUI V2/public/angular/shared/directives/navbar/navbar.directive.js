(function () {
    'use strict';
    function navbar (UserStore, ShoppingCart) {
        /**
         * @name link
         * @desc Directive link
         */
        function link (scope, elem, attrs) {
            scope.user = UserStore.getUserInfo();
            scope.shoppingCart = ShoppingCart.getShoppingCart();
            

            scope.logout = function() {
                UserStore.logout();
                scope.user = undefined;
            }
            
            scope.removeShoppingCartItem = function(item) {
                ShoppingCart.removeItem(item);
            }

            scope.$on('login', function () {
                scope.user = undefined;
                scope.user = UserStore.getUserInfo();
            })

            scope.$on('shoppingCartUpdated', function () {
                scope.shoppingCart = undefined;
                scope.shoppingCart = ShoppingCart.getShoppingCart();
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