(function () {

function DashboardViewCtrl ($http, $state, $uibModal, Api) {
    var vm = this;


    vm.showModal = function(){
        $uibModal.open({
            templateUrl: 'addModalContent.html', //change this
            controller: "AddMenuModalController", //change this
            controllerAs: 'modal' //change this
        })
            .result.then(
            function (product) {
                Api.addItemToOrder(product).then(success,error);
            },
            function () {
                //cancelled
            }
        );
    }

}
    function AddMenuModalController ($uibModalInstance) {
        var vm = this;
        vm.product = {};

        vm.ok = function () {
            $uibModalInstance.close(vm.product);//change the param
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

