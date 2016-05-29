///<reference path="../typings/browser.d.ts"/>
import {bootstrap} from '@angular/platform-browser-dynamic';
import {SignInComponent} from "./app/sign-in/sign-in.component.ts";
import {HTTP_PROVIDERS} from "@angular/http";

bootstrap(SignInComponent, HTTP_PROVIDERS);