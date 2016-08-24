import {Component} from 'angular2/core';

@Component({
    selector: 'spinner',
    styleUrls: ['app/css/spinner.css'],
    template: `<div class="in modal-backdrop block-ui-overlay"></div>
     <div class="spinner-message-container" aria-live="assertive" aria-atomic="true">
        <div class="spinner-message">
                {{ state.message }}
                <img src="app/img/spinner.gif" />
        </div>
    </div>`,
})
export class SpinnerComponent {
    state = {
        message: 'Please wait...'
    };
}