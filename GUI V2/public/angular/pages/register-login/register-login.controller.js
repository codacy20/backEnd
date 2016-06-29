(function () {

function RegisterLoginCtrl ($http, $state, UserStore, $rootScope) {
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



}


angular
    .module('app')
    .controller('RegisterLoginCtrl', RegisterLoginCtrl);
}());

