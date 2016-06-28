(function () {

function RegisterLoginCtrl ($http, $state, UserStore    ) {
    var vm = this;
    console.log(UserStore);
    vm.state = $state.current.url;
    vm.showDetailedLogin = false;


    vm.OnloginSelection = function() {
        vm.showDetailedLogin = true;
    }

    vm.loginUser = function(username, password) {
        UserStore.loginUser(username, password).then(function(res){
            alert("yes")
        }, function(err) {
            alert("no")

        })
    }


}


angular
    .module('app')
    .controller('RegisterLoginCtrl', RegisterLoginCtrl);
}());

