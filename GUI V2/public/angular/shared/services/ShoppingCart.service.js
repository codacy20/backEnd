(function () {
    'use strict';
    function ShoppingCart($rootScope, $window, UserStore) {
        var shoppingCart = [];

        function addItem(item) {
            console.log(item)
            shoppingCart.push(item);
            $window.localStorage && $window.localStorage.setItem('shoppingCart', JSON.stringify(shoppingCart));

            $rootScope.$broadcast('shoppingCartUpdated');


            console.log(getShoppingCart())
        }

        function removeItem(item) {
            console.log(item)
            var index = shoppingCart.indexOf(item);

            if (index > -1) {
                shoppingCart.splice(index, 1);
            }

            $window.localStorage && $window.localStorage.setItem('shoppingCart', JSON.stringify(shoppingCart));
            $rootScope.$broadcast('shoppingCartUpdated');
        }

        function getShoppingCart() {
            var user = UserStore.getUserInfo();

            var count = 0;
            var orderList = JSON.parse($window.localStorage && $window.localStorage.getItem('shoppingCart'));

            if (orderList !== null) {
                count = orderList.length;
            } else {
                orderList = [];
            }

            shoppingCart = orderList;
            return {
                count: count,
                orderList: orderList
            };
        }

        function updateShoppingCart() {

        }

        return {
            addItem: addItem,
            removeItem: removeItem,
            getShoppingCart: getShoppingCart
        };
    }

    angular
        .module('app')
        .factory('ShoppingCart', ShoppingCart);
}());
