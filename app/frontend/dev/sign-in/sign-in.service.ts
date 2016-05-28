/**
 * Created by Adjoa on 5/27/2016.
 */
import {Injectable} from '@angular/core';
import {Http} from '@angular/http';

@Injectable()
export class SignInService
{
    http: Http;

    constructor(private _http: Http){
        this.http = _http;
    }
}