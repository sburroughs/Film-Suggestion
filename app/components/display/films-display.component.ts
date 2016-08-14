import {Component, Input, Output, EventEmitter, OnInit} from 'angular2/core';
import {FilmViewComponent} from './film-view.component'

@Component({
    selector: 'films-display',
    templateUrl: 'app/components/display/films-display.component.html',
    directives: [FilmViewComponent]
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