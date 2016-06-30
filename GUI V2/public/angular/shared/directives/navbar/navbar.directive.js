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
            scope.showDashboardMenuItem = false;

            function init() {
                console.log(scope.user)
                if (scope.user.group == 'restaurant') {
                    showMenuForRestaurant();
                }
            }

            function showMenuForRestaurant () {
                scope.showDashboardMenuItem = true;
            }

            scope.logout = function() {
                UserStore.logout();
                scope.user = undefined;
                scope.showDashboardMenuItem = false;
            }
            
            scope.removeShoppingCartItem = function(item) {
                ShoppingCart.removeItem(item);
            }

            scope.$on('login', function () {
                scope.user = undefined;
                scope.user = UserStore.getUserInfo();
                init();
            })

            scope.$on('shoppingCartUpdated', function () {
                scope.shoppingCart = undefined;
                scope.shoppingCart = ShoppingCart.getShoppingCart();
            })

            init();
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