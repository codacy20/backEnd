(function (angular) {
    function $sw ($window, $q) {
        'use strict';
        return {
            alert: function (title, text, type, html) {
                var def = $q.defer();
                var obj = _.isObject(title) ? title: {title: title, text: text, type: type, html: html};
                console.log(obj);
                $window.swal(obj, function (result) {def[result ? 'resolve' : 'reject'](result);});
                return def.promise;
            },
            warning: function (title, text) {return this.alert(title, text, 'warning');},
            error: function (title, text) {return this.alert(title, text, 'error');},
            success: function (title, text) {return this.alert(title, text, 'success');},
            info: function (title, text) {return this.alert(title, text, 'info');},
            prompt: function(options, result){
                $window.swal(options, result)
            }
            //close: $window.swal.close,
            //disableButtons: $window.swal.disableButtons,
            //enableButtons: $window.swal.enableButtons,
            //resetInputError: $window.swal.resetInputError,
            //setDefaults: $window.swal.setDefaults,
            //showInputError: $window.swal.showInputError
        };
    }
    angular
        .module('app')
        .factory('$sw', $sw);

}(angular));