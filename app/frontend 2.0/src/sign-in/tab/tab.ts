import { Component, Input } from '@angular/core';

@Component({
    selector: 'tab',
    styles: [`
    .pane{
      padding: 1em;
    }
    .nav nav-tabs
    {
        margin-top: 10%;
        border-bottom: none;
    }
  `],
    template: `
    <div [hidden]="!active" class="pane">
      <ng-content></ng-content>
    </div>
  `
})
export class Tab {
    @Input('tabTitle') title: string;
    @Input() active = false;
}