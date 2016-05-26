import {Component, Input, OnInit} from 'angular2/core';

@Component({
    selector: 'film-view',
    templateUrl: 'app/components/display/film-view.component.html',
})
export class FilmViewComponent implements OnInit {

    @Input() film;

    ngOnInit() {

    }

}