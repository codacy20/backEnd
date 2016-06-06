import { Component, ContentChildren, QueryList, AfterContentInit } from '@angular/core';
import { Tab } from './tab.ts';

@Component({
    selector: 'tabs',
    template:`
<div class="login">
<div class="container">
        <div class="row">
            <div class="col-sm-6 col-sm-offset-3 tab-content">
              <ul class="nav nav-tabs custom_tabs ">
                <li *ngFor="#tab of tabs" (click)="selectTab(tab)" [class.active]="tab.active">
                    <a>{{tab.title}}</a>
                 </li>
             </ul>
             <ng-content></ng-content>
            </div>
        </div> 
    </div>
</div>
    
  `,
    styles: [`
    .custom_tabs
    {
        border: none;
    }
    
    .custom_tabs li
    {
        background: #fee9e4 none repeat scroll 0 0;
        border-bottom: 1px solid #ec008c;
        float: left;
        line-height: 50px;
        text-align: center;
        width: 50%;
    }
    
    .custom_tabs ul li a 
    {
      color: #191919;
      display: block;
      font-size: 24px;
    }
.custom_tabs ul li.active 
    {
        background: #fff none repeat scroll 0 0;
        border-bottom: 3px solid #ec008c;
        line-height: 48px;
        font-weight: 700;
    }
    .login {
     background: rgba(0, 0, 0, 0) url("../assets/img/signinbkg.jpg") no-repeat scroll 0 0 / cover ;
     height:100%;
}
.tab-content
{
    margin-top: 20%;
      box-shadow: 0 0 20px #666;
}
  `]
})
export class Tabs implements AfterContentInit {

    @ContentChildren(Tab) tabs: QueryList<Tab>;

    // contentChildren are set
    ngAfterContentInit() {
        // get all active tabs
        let activeTabs = this.tabs.filter((tab)=>tab.active);

        // if there is no active tab set, activate the first
        if(activeTabs.length === 0) {
            this.selectTab(this.tabs.first);
        }
    }

    selectTab(tab: Tab){
        // deactivate all tabs
        this.tabs.toArray().forEach(tab => tab.active = false);

        // activate the tab the user has clicked on.
        tab.active = true;
    }

}