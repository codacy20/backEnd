(function () {

function RegisterLoginCtrl ($http, $state, UserStore, $rootScope, Api) {
    var vm = this;
    vm.state = $state.current.url;
    vm.showDetailedLogin = false;


    vm.OnloginSelection = function() {
        vm.showDetailedLogin = true;
    }

    vm.loginUser = function(username, password) {

        UserStore.loginUser(username, password).then(function(res){
            $rootScope.$broadcast('login');
            $state.go('app.main');
        }, function(err) {
            alert("There was an error")
        })
    }

    vm.loginRestaurant = function(username, password) {
        UserStore.loginRestaurant(username, password).then(function(res){
            $rootScope.$broadcast('login');
            $state.go('app.main');
        }, function(err) {
            alert("There was an error")
        })
    }


    vm.registerUser = function() {
        Api.createUser(vm.regUser).then(function(res){
            alert("User Created")
        }, function(err) {
            alert("There was an error")
        })
    }


    vm.registerRestaurant = function() {
        alert("Restaurant Created")
        Api.createRestaurant(vm.regRestaurant).then(function(res){
            alert("Restaurant Created")
        }, function(err) {
            alert("There was an error")
        })
    }



}


angular
    .module('app')
    .controller('RegisterLoginCtrl', RegisterLoginCtrl);
}());

