(function () {
'use strict';
function RestaurantPreviewCtrl ($state, Api, UserStore) {
    var vm = this;
    vm.restaurant = {};
    vm.products = [];
    vm.user = UserStore.getUserInfo();


    function init() {
        getRestaurant();
    }

    function getProducts() {
        Api.getProducts().then(function(res) {
            var response = res.data;
            angular.forEach(response, function(value, key) {
                if (vm.restaurant.restaurantName == value.resteurant) {
                    vm.products.push(value);
                }
            });

        })
    }

    function getRestaurant() {
        var restaurantName = $state.params.name;
        if (restaurantName) {
            Api.getRestaurant(restaurantName).then(function (res) {
                vm.restaurant = res.data;
            }, function () {

            })
        } else {
            $state.go('app.main')
        }
        getProducts();
    }

    vm.addcomment = function(comment) {
        var params = {
            username: vm.user.username,
            restaurant: vm.restaurant.username,
            comment:comment
        };
        Api.addComment(params).then(function() {
            getRestaurant();
            vm.comment = "";

        }, function(err) {
            alert("error")
        })

    }

    init();


}


angular
    .module('app')
    .controller('RestaurantPreviewCtrl', RestaurantPreviewCtrl);
}());

