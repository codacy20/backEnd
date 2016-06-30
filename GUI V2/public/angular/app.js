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
                controller: 'CheckoutCtrl as Checkout'
            })
            .state('app.register-login', {
                url: 'register-login',
                templateUrl: 'angular/pages/register-login/register-login.tpl.html',
                controller: 'RegisterLoginCtrl as RegisterLogin'
            })
          
            .state('app.restaurant-preview', {
                url: 'restaurant-preview/:name',
                templateUrl: 'angular/pages/restaurant-preview/restaurant-preview.tpl.html',
                controller: 'RestaurantPreviewCtrl as Restaurant'
            })

            //everything for the dashboard
            .state('app.dashboard', {
                url: 'dashboard',
                redirectTo: 'dashboard.dashboard-view',
                templateUrl: 'angular/pages/dashboard/dashboard.tpl.html',
                data: {
                    allowedUsers: ['restaurant']
                }
            })
            .state('app.dashboard.dashboard-view', {
                url: '/view',
                templateUrl: 'angular/pages/dashboard/dashboard-view/dashboard-view.tpl.html',
                controller: 'DashboardViewCtrl as Dashboard'
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
    }


    /**
     * Run block
     */
    angular
        .module('app')
        .run(run);


    function run($rootScope, $location, $state, UserStore) {

        $rootScope.$on('$stateChangeStart', function (evt, to, params, from) {

           //Check If user is authorized to go to an specific page
           if(to.data){
               if ('allowedUsers' in to.data) {
                   var allowedUsers = [];
                   if (typeof to.data != 'undefined') {
                       allowedUsers = to.data.allowedUsers;
                   }

                    console.log(UserStore.userNotAllowed(allowedUsers))
                   // Check if user is not logged in
                   if (!UserStore.userNotAllowed(allowedUsers) || !UserStore.userLoggedIn()  ) {
                       alert("Not Allowed")
                       evt.preventDefault();
                       $state.go('app.main')
                   }
               }
           }

            if(to.url == "/user-login" || to.url == "/restaurant-login"){
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