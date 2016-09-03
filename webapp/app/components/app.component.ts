import {Component, OnInit} from 'angular2/core';
import {FilmsDisplayComponent} from './display/films-display.component';
import {SearchComponent} from './display/search.component';
import {TagManagerComponent} from "./display/tags/tag-manager.component";
import {Film} from './model/film';
import {Tag} from './model/tag';
import {TagManagerService} from "./display/tags/tag-manager.service";
import {ValuesPipe} from "./util/pipes/value-pipe";

@Component({
    selector: 'app',
    templateUrl: 'app/components/app.component.html',
    directives: [SearchComponent, TagManagerComponent, FilmsDisplayComponent],
    providers: [TagManagerService]
})
export class AppComponent implements OnInit {

    films:Film[];

    setFilms($event) {
        this.films = $event;
    }

    ngOnInit() {

    }

}