(function () {
    function MainController ($state, $uibModal, Api) {
        var vm = this;
        vm.products = [];

        function init() {
            getProducts();
        }

        function getProducts() {
            Api.getProducts().then(function(res) {
                vm.products = res.data;
            })
        }

        vm.showModal = function(){
            $uibModal.open({
                templateUrl: 'myModalContent.html',
                controller: "ModalDialogController",
                controllerAs: 'modal'
            })
                .result.then(
                function (bidPrice) {
                    Api.getBid().then(function(res) {
                        vm.search = res.iD;
                        console.log('res ', res);
                    })
                },
                function () {
                   //cancelled
                }
            );
        }

        init();
    }

    function ModalDialogController ($uibModalInstance) {
        var vm = this;

        vm.ok = function () {
            $uibModalInstance.close(vm.bidPrice);
        };

        vm.cancel = function () {
            $uibModalInstance.dismiss('cancel');
        };
    }



    angular
        .module('app')
        .controller('MainController', MainController)
        .controller('ModalDialogController', ModalDialogController)

}());
