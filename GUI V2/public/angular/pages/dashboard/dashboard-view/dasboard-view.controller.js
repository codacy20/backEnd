(function () {

function DashboardViewCtrl ($http, $state, $uibModal) {
    var vm = this;


    vm.showModal = function(){
        $uibModal.open({
            templateUrl: 'addModalContent.html', //change this
            controller: "AddMenuModalController", //change this
            controllerAs: 'modal' //change this
        })
            .result.then(
            function () {
                //ok
            },
            function () {
                //cancelled
            }
        );
    }

}
    function AddMenuModalController ($uibModalInstance) {
        var vm = this;

        vm.ok = function () {
            $uibModalInstance.close();//change the param
        };

        vm.cancel = function () {
            $uibModalInstance.dismiss('cancel');
        };
    }


angular
    .module('app')
    .controller('DashboardViewCtrl', DashboardViewCtrl)
    .controller('AddMenuModalController', AddMenuModalController);
}());

