(function() {

    angular
        .module('app', [
            'ui.router',
            'ui.bootstrap'
        ])
        .config(config);


    // safe dependency injection
    // this prevents minification issues
    config.$inject = ['$stateProvider', '$urlRouterProvider'];

    function config($stateProvider, $urlRouterProvider) {
        console.log($urlRouterProvider)
        $urlRouterProvider.otherwise('/main');
        $stateProvider
            .state('app', {
                url: '/',
                redirectTo: 'app.main',
                templateUrl: 'angular/pages/home.tpl.html'
            })
            .state('app.main', {
                url: 'main',
                templateUrl: 'angular/pages/main/main.html',
                controller: 'MainController as Main'
            })
            .state('app.checkout', {
                url: 'checkout',
                templateUrl: 'angular/pages/checkout/checkout.tpl.html',
                controller: 'CheckoutCtrl as Checkout'
            })
            .state('app.register-login', {
                url: 'register-login',
                templateUrl: 'angular/pages/register-login/register-login.tpl.html',
                controller: 'RegisterLoginCtrl as RegisterLogin'
            })
            .state('edit-event', {
                url: '/edit/:accessCode',
                templateUrl: 'angular/pages/admin/edit-register-login.tpl.html',
                controller: 'EditEventCtrl as EditEvent',
                data: {
                    requireLogin: false
                }
            })
    }


    /**
     * Run block
     */
    angular
        .module('app')
        .run(run);

    run.$inject = ['$rootScope', '$location'];

    function run($rootScope, $location) {

        $rootScope.$on('$stateChangeStart', function(evt, to, params) {
            if (to.redirectTo) {
                evt.preventDefault();
                $state.go(to.redirectTo, params, {location: 'replace'})
            }
        });

    }


})();