(function () {

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
        $urlRouterProvider.otherwise('/main');
        $stateProvider
            .state('app', {
                url: '/',
                redirectTo: 'app.main',
                templateUrl: 'angular/pages/home.tpl.html',
                resolve: {
                    auth: function (UserStore) {
                        var userInfo = UserStore.getUserInfo();
                        if (userInfo) {
                            return userInfo;
                        }
                    }
                }
            })
            .state('app.main', {
                url: 'main',
                templateUrl: 'angular/pages/main/main.html',
                controller: 'MainController as Main'
            })
            .state('app.checkout', {
                url: 'checkout',
                templateUrl: 'angular/pages/checkout/checkout.tpl.html',
                controller: 'CheckoutCtrl as Checkout',
                data: {
                    requireLogin: true
                }
            })
            .state('app.register-login', {
                url: 'register-login',
                templateUrl: 'angular/pages/register-login/register-login.tpl.html',
                controller: 'RegisterLoginCtrl as RegisterLogin'
            })
          
            .state('app.restaurant-preview', {
                url: 'restaurant-preview',
                templateUrl: 'angular/pages/restaurant-preview/restaurant-preview.tpl.html',
                controller: 'RestaurantPreviewCtrl as RestaurantPreview'
            })

            //everything for the dashboard
            .state('app.dashboard', {
                url: 'dashboard',
                redirectTo: 'dashboard.dashboard-view',
                templateUrl: 'angular/pages/dashboard/dashboard.tpl.html'
            })
            .state('app.dashboard.dashboard-view', {
                url: '/view',
                templateUrl: 'angular/pages/dashboard/dashboard-view/dashboard-view.tpl.html',
                controller: 'DashboardViewCtrl as Dashboard',
                data: {
                    requireLogin: false
                }
            })
            .state('app.dashboard.orders', {
                url: '/view',
                templateUrl: 'angular/pages/dashboard/orders/orders.tpl.html',
                controller: 'OrderCtrl as Order'
            })
            .state('app.dashboard.comments', {
                url: '/view',
                templateUrl: 'angular/pages/dashboard/comments/comments.tpl.html',
                controller: 'CommentsCtrl as Comments'
            })

            .state('app.edit-event', {
                url: '/edit/:accessCode',
                templateUrl: 'angular/pages/admin/edit-dashboard-view.tpl.html',
                controller: 'EditEventCtrl as EditEvent',
                data: {
                    requireLogin: true
                }
            })
    }


    /**
     * Run block
     */
    angular
        .module('app')
        .run(run);


    function run($rootScope, $location, $state, UserStore) {

        $rootScope.$on('$stateChangeStart', function (evt, to, params, from) {
            var requireLogin = false;
            if (typeof to.data != 'undefined') {
                requireLogin = to.data.requireLogin;
            }


            //Check if user is not logged in
            // if (requireLogin && typeof UserStore.getUserInfo() === 'undefined' || UserStore.getUserInfo() == null) {
            //     evt.preventDefault();
            //    // $state.go('app.main')
            // }


            if(to.url == "/user-login"){
                if(from.url != "register-login") {
                    evt.preventDefault();
                    $state.go('app.register-login')
                }
            }

            if (to.redirectTo) {
                evt.preventDefault();
                $state.go(to.redirectTo, params, {location: 'replace'})
            }

        });

    }


})();