(function () {
    'use strict';
    function fbLike ($window) {
        /**
         * @name link
         * @desc Directive link
         */
        return {
            restrict: 'A',
            link: function (scope, element, attrs) {
                (function(d, s, id) {
                        var js, fjs = d.getElementsByTagName(s)[0];
                        if (d.getElementById(id)) return;
                        js = d.createElement(s); js.id = id;
                        js.src = "//connect.facebook.net/en_LA/sdk.js#xfbml=1&version=v2.5";
                        fjs.parentNode.insertBefore(js, fjs);
                    }(document, 'script', 'facebook-jssdk'));
            },
            template: '<div class="fb-like" data-href="https://www.facebook.com/fusionfreakz/" data-layout="button" data-action="like" data-show-faces="true" data-share="true"></div>'
        }
    }

    angular
        .module('app')
        .directive('fbLike', fbLike);

}());
