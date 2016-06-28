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
        // $urlRouterProvider.otherwise('/main');
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
                templateUrl: 'angular/pages/register-login/dashboard-view.tpl.html',
                controller: 'RegisterLoginCtrl as RegisterLogin'
            })
            .state('app.restaurant-admin', {
                url: 'restaurant-admin',
                templateUrl: 'angular/pages/restaurant-admin/restaurant-admin.tpl.html'
                // controller: 'RestaurantAdminCtrl as RestaurantAdmin'
            })
            .state('app.restaurant-preview', {
                url: 'restaurant-preview',
                templateUrl: 'angular/pages/restaurant-preview/restaurant-preview.tpl.html'
                // controller: 'RestaurantPreviewCtrl as RestaurantPreview'
            })
            
            //everything for the dashboard
            .state('dashboard', {
                url: 'dashboard',
                redirectTo: 'dashboard.dashboard-view',
                templateUrl: 'angular/pages/dashboard/dashboard.tpl.html'
            })
            .state('dashboard.dashboard-view', {
                url: '/view',
                templateUrl: 'angular/pages/dashboard/dashboard-view/dashboard-view.tpl.html',
                controller: 'DashboardViewCtrl as Dashboard'
            })
            .state('dashboard.orders', {
                url: '/view',
                templateUrl: 'angular/pages/dashboard/orders/orders.tpl.html',
                controller: 'OrderCtrl as Order'
            })
            .state('dashboard.comments', {
                url: '/view',
                templateUrl: 'angular/pages/dashboard/comments/comments.tpl.html',
                controller: 'CommentsCtrl as Comments'
            })

            .state('edit-event', {
                url: '/edit/:accessCode',
                templateUrl: 'angular/pages/admin/edit-dashboard-view.tpl.html',
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