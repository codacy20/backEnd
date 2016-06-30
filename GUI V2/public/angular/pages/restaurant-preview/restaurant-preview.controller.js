(function () {
'use strict';
function RestaurantPreviewCtrl ($http, $state, Api) {
    var vm = this;

    vm.addcomment = function(comment) {
        var params = {
            // username: UserStore.getUserInfo().username,
            // orderList: ShoppingCart.getShoppingCart().orderList
            restaurantUsername: "vapiano",
            username:"Tina",
            comment:comment
        };
        console.log(params);
        Api.addComment(params).then(function() {
            alert("success")
        }, function(err) {
            alert("error")
        })

    }


}


angular
    .module('app')
    .controller('RestaurantPreviewCtrl', RestaurantPreviewCtrl);
}());

