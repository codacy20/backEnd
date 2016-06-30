(function () {

    function CommentsCtrl($http, $state, UserStore, Api) {
        var vm = this;
        vm.restaurant = {};
        vm.user = UserStore.getUserInfo();

        function init() {
            getRestaurant();
            console.log("asdasd")
        }


        function getRestaurant() {
            Api.getRestaurant(vm.user.username).then(function (res) {
                vm.restaurant = res.data;
            }, function () {

            })
        }

        init();

    }

        angular
            .module('app')
            .controller('CommentsCtrl', CommentsCtrl);
    }());

