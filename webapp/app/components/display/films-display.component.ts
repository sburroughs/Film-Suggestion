import {Component, Input, Output, EventEmitter, OnInit} from '@angular/core';

@Component({
    selector: 'films-display',
    templateUrl: 'app/components/display/films-display.component.html',
})
export class FilmsDisplayComponent implements OnInit {

    @Input() films;

    @Output() tagSelected = new EventEmitter();

    ngOnInit() {

    }

    addTag($event){
        this.tagSelected.emit($event);
    }

}