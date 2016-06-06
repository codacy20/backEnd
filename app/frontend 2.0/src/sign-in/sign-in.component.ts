import {Component} from "@angular/core";
import {Tabs} from './tab/tabs.ts';
import {Tab} from './tab/tab.ts';

@Component({
    selector: 'sign-in-page',
    templateUrl: "./src/sign-in/sign-in.component.html",
    directives: [Tabs, Tab]
})


export class SignInComponent{

   
}