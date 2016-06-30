(function () {

function CheckoutCtrl ($scope, ShoppingCart, UserStore, Api) {
    var vm = this;
    vm.shoppingCart = ShoppingCart.getShoppingCart();

    
    vm.checkout = function() {
        if (UserStore.getUserInfo()) {
            var params = {
                username: UserStore.getUserInfo().username,
                OrderList: ShoppingCart.getShoppingCart().orderList
            };
            Api.checkout(params).then(function() {
                alert("success")
            }, function(err) {
                alert("error")
            })
        } else {
            alert("Login first")
        }
    };

    vm.getTotal = function() {
        var total = 0;
        angular.forEach(vm.shoppingCart.orderList, function(order) {
            total += order.price;
        });
        return total;
    }

    vm.removeItem = function(item) {
        ShoppingCart.removeItem(item);
    }

    $scope.$on('shoppingCartUpdated', function () {
        vm.shoppingCart = undefined;
        vm.shoppingCart = ShoppingCart.getShoppingCart();
    })


}


angular
    .module('app')
    .controller('CheckoutCtrl', CheckoutCtrl);
}());

