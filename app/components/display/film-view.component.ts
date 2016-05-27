import {Component, Input, OnInit} from 'angular2/core';
import {TagViewComponent} from './tag-view.component';

@Component({
    selector: 'film-view',
    templateUrl: 'app/components/display/film-view.component.html',
    directives: [TagViewComponent]
})
export class FilmViewComponent implements OnInit {

    @Input() film;

    ngOnInit() {

    }

}