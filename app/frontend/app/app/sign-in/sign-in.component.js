System.register(['@angular/core', "./sign-in.service"], function(exports_1, context_1) {
    "use strict";
    var __moduleName = context_1 && context_1.id;
    var __decorate = (this && this.__decorate) || function (decorators, target, key, desc) {
        var c = arguments.length, r = c < 3 ? target : desc === null ? desc = Object.getOwnPropertyDescriptor(target, key) : desc, d;
        if (typeof Reflect === "object" && typeof Reflect.decorate === "function") r = Reflect.decorate(decorators, target, key, desc);
        else for (var i = decorators.length - 1; i >= 0; i--) if (d = decorators[i]) r = (c < 3 ? d(r) : c > 3 ? d(target, key, r) : d(target, key)) || r;
        return c > 3 && r && Object.defineProperty(target, key, r), r;
    };
    var __metadata = (this && this.__metadata) || function (k, v) {
        if (typeof Reflect === "object" && typeof Reflect.metadata === "function") return Reflect.metadata(k, v);
    };
    var core_1, sign_in_service_1;
    var SignInComponent;
    return {
        setters:[
            function (core_1_1) {
                core_1 = core_1_1;
            },
            function (sign_in_service_1_1) {
                sign_in_service_1 = sign_in_service_1_1;
            }],
        execute: function() {
            SignInComponent = (function () {
                function SignInComponent(_signInService) {
                    this._signInService = _signInService;
                }
                SignInComponent.prototype.onPost = function (first_name, last_name, username, housenumber, address, postcode, emailaddress, passwrd) {
                    var _this = this;
                    var data = {
                        firstname: first_name,
                        lastname: last_name,
                        username: username,
                        housenum: housenumber,
                        address: address,
                        postcode: postcode,
                        emailaddress: emailaddress,
                        passwrd: passwrd
                    };
                    this._signInService.postData(data)
                        .subscribe(function (data) { return _this.response = JSON.stringify(data); }, function (error) { return console.log(error); });
                };
                ;
                SignInComponent = __decorate([
                    core_1.Component({
                        selector: 'app-sign-in',
                        templateUrl: '../src/login.html',
                        styleUrls: ['../assets/css/style.css'],
                        providers: [sign_in_service_1.SignInService]
                    }), 
                    __metadata('design:paramtypes', [sign_in_service_1.SignInService])
                ], SignInComponent);
                return SignInComponent;
            }());
            exports_1("SignInComponent", SignInComponent);
        }
    }
});

//# sourceMappingURL=data:application/json;base64,eyJ2ZXJzaW9uIjozLCJzb3VyY2VzIjpbImFwcC9zaWduLWluL3NpZ24taW4uY29tcG9uZW50LnRzIl0sIm5hbWVzIjpbXSwibWFwcGluZ3MiOiI7Ozs7Ozs7Ozs7Ozs7Ozs7Ozs7Ozs7O1lBVUE7Z0JBRUkseUJBQW9CLGNBQTZCO29CQUE3QixtQkFBYyxHQUFkLGNBQWMsQ0FBZTtnQkFBRSxDQUFDO2dCQUNwRCxnQ0FBTSxHQUFOLFVBQU8sVUFBa0IsRUFBRSxTQUFpQixFQUFFLFFBQWdCLEVBQUUsV0FBbUIsRUFBRSxPQUFlLEVBQUUsUUFBZ0IsRUFBRSxZQUFtQixFQUFFLE9BQWU7b0JBQTVKLGlCQWdCQztvQkFmRyxJQUFNLElBQUksR0FBQzt3QkFDUCxTQUFTLEVBQUUsVUFBVTt3QkFDckIsUUFBUSxFQUFFLFNBQVM7d0JBQ25CLFFBQVEsRUFBRSxRQUFRO3dCQUNsQixRQUFRLEVBQUUsV0FBVzt3QkFDckIsT0FBTyxFQUFFLE9BQU87d0JBQ2hCLFFBQVEsRUFBRSxRQUFRO3dCQUNsQixZQUFZLEVBQUUsWUFBWTt3QkFDMUIsT0FBTyxFQUFFLE9BQU87cUJBQ25CLENBQUE7b0JBQ0QsSUFBSSxDQUFDLGNBQWMsQ0FBQyxRQUFRLENBQUMsSUFBSSxDQUFDO3lCQUM3QixTQUFTLENBQ04sVUFBQSxJQUFJLElBQUksT0FBQSxLQUFJLENBQUMsUUFBUSxHQUFHLElBQUksQ0FBQyxTQUFTLENBQUMsSUFBSSxDQUFDLEVBQXBDLENBQW9DLEVBQzVDLFVBQUEsS0FBSyxJQUFJLE9BQUEsT0FBTyxDQUFDLEdBQUcsQ0FBQyxLQUFLLENBQUMsRUFBbEIsQ0FBa0IsQ0FDOUIsQ0FBQztnQkFDVixDQUFDOztnQkF6Qkw7b0JBQUMsZ0JBQVMsQ0FBQzt3QkFDUCxRQUFRLEVBQUUsYUFBYTt3QkFDdkIsV0FBVyxFQUFFLG1CQUFtQjt3QkFDaEMsU0FBUyxFQUFFLENBQUMseUJBQXlCLENBQUM7d0JBQ3RDLFNBQVMsRUFBQyxDQUFDLCtCQUFhLENBQUM7cUJBQzVCLENBQUM7O21DQUFBO2dCQXNCRixzQkFBQztZQUFELENBckJBLEFBcUJDLElBQUE7WUFyQkQsNkNBcUJDLENBQUEiLCJmaWxlIjoiYXBwL3NpZ24taW4vc2lnbi1pbi5jb21wb25lbnQuanMiLCJzb3VyY2VzQ29udGVudCI6WyJpbXBvcnQge0NvbXBvbmVudH0gZnJvbSAnQGFuZ3VsYXIvY29yZSc7XHJcbmltcG9ydCB7U2lnbkluU2VydmljZX0gZnJvbSBcIi4vc2lnbi1pbi5zZXJ2aWNlXCI7XHJcblxyXG5cclxuQENvbXBvbmVudCh7XHJcbiAgICBzZWxlY3RvcjogJ2FwcC1zaWduLWluJyxcclxuICAgIHRlbXBsYXRlVXJsOiAnLi4vc3JjL2xvZ2luLmh0bWwnLFxyXG4gICAgc3R5bGVVcmxzOiBbJy4uL2Fzc2V0cy9jc3Mvc3R5bGUuY3NzJ10sXHJcbiAgICBwcm92aWRlcnM6W1NpZ25JblNlcnZpY2VdXHJcbn0pXHJcbmV4cG9ydCBjbGFzcyBTaWduSW5Db21wb25lbnQge1xyXG4gICAgcmVzcG9uc2U6IHN0cmluZztcclxuICAgIGNvbnN0cnVjdG9yKHByaXZhdGUgX3NpZ25JblNlcnZpY2U6IFNpZ25JblNlcnZpY2Upe31cclxuICAgIG9uUG9zdChmaXJzdF9uYW1lOiBzdHJpbmcsIGxhc3RfbmFtZTogc3RyaW5nLCB1c2VybmFtZTogc3RyaW5nLCBob3VzZW51bWJlcjogbnVtYmVyLCBhZGRyZXNzOiBzdHJpbmcsIHBvc3Rjb2RlOiBzdHJpbmcsIGVtYWlsYWRkcmVzczpzdHJpbmcsIHBhc3N3cmQ6IHN0cmluZyl7XHJcbiAgICAgICAgY29uc3QgZGF0YT17XHJcbiAgICAgICAgICAgIGZpcnN0bmFtZTogZmlyc3RfbmFtZSxcclxuICAgICAgICAgICAgbGFzdG5hbWU6IGxhc3RfbmFtZSxcclxuICAgICAgICAgICAgdXNlcm5hbWU6IHVzZXJuYW1lLFxyXG4gICAgICAgICAgICBob3VzZW51bTogaG91c2VudW1iZXIsXHJcbiAgICAgICAgICAgIGFkZHJlc3M6IGFkZHJlc3MsXHJcbiAgICAgICAgICAgIHBvc3Rjb2RlOiBwb3N0Y29kZSxcclxuICAgICAgICAgICAgZW1haWxhZGRyZXNzOiBlbWFpbGFkZHJlc3MsXHJcbiAgICAgICAgICAgIHBhc3N3cmQ6IHBhc3N3cmRcclxuICAgICAgICB9XHJcbiAgICAgICAgdGhpcy5fc2lnbkluU2VydmljZS5wb3N0RGF0YShkYXRhKVxyXG4gICAgICAgICAgICAuc3Vic2NyaWJlKFxyXG4gICAgICAgICAgICAgICAgZGF0YSA9PiB0aGlzLnJlc3BvbnNlID0gSlNPTi5zdHJpbmdpZnkoZGF0YSksXHJcbiAgICAgICAgICAgICAgICBlcnJvciA9PiBjb25zb2xlLmxvZyhlcnJvcilcclxuICAgICAgICAgICAgKTtcclxuICAgIH07XHJcblxyXG59Il0sInNvdXJjZVJvb3QiOiIvc291cmNlLyJ9
