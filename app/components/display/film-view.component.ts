import {Component, Input, Output, EventEmitter, OnInit} from 'angular2/core';
import {TagViewComponent} from './tag-view.component';
import {Film} from "../model/film";

@Component({
    selector: 'film-view',
    templateUrl: 'app/components/display/film-view.component.html',
    directives: [TagViewComponent]
})
export class FilmViewComponent implements OnInit {

    @Input() film: Film;

    @Output() tagSelected = new EventEmitter();

    ngOnInit() {

    }

    addTag($event){
        this.tagSelected.emit($event);
    }

}