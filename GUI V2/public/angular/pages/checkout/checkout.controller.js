(function () {

function CheckoutCtrl ($scope, ShoppingCart, UserStore, Api) {
    var vm = this;
    vm.shoppingCart = ShoppingCart.getShoppingCart();

    
    vm.checkout = function() {
        var params = {
            username: UserStore.getUserInfo().username,
            orderList: ShoppingCart.getShoppingCart().orderList
        };
        swal.error("ERROR", "jj");
        
        Api.checkout(params).then(function() {
            
        }, function(err) {
            swal.error("ERROR", err);
        })
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

