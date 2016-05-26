import {Component, Input, OnInit} from 'angular2/core';
import {Media} from '../media/media';
import {FilmViewComponent} from './film-view.component'

@Component({
    selector: 'films-display',
    templateUrl: 'app/components/display/films-display.component.html',
    directives: [FilmViewComponent]
})
export class FilmsDisplayComponent implements OnInit {

    @Input() films;

    ngOnInit() {

    }

}