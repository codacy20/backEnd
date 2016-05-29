import {Component} from '@angular/core';
import {SignInService} from "./sign-in.service";


@Component({
    selector: 'app-sign-in',
    templateUrl: '/static/sign-in.html',
    styleUrls: ['/assets/css/style.css']
})

export class SignInComponent {
    response: string;
    constructor(private _signInService: SignInService){}
    onPost(first_name: string, last_name: string, username: string, housenumber: number, address: string, postcode: string, emailaddress:string, passwrd: string){
        const data={
            firstname: first_name,
            lastname: last_name,
            username: username,
            housenum: housenumber,
            address: address,
            postcode: postcode,
            emailaddress: emailaddress,
            passwrd: passwrd
        }
        this._signInService.postData(data)
            .subscribe(
                data => this.response = JSON.stringify(data),
                error => console.log(error)
            );
    };

}