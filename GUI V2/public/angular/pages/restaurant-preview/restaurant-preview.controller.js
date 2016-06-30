(function () {
'use strict';
function RestaurantPreviewCtrl ($state, Api) {
    var vm = this;
    vm.restaurant = {};

    function init() {
        getRestaurant();
    }

    function getRestaurant() {
        var restaurantName = $state.params.name;
        if(restaurantName){
             Api.getRestaurant(restaurantName).then(function(res) {
                 vm.restaurant = res.data;
             }, function() {
                 
             })
        } else {
            $state.go('app.main')
        }


    }

    init();


}


angular
    .module('app')
    .controller('RestaurantPreviewCtrl', RestaurantPreviewCtrl);
}());

