import {Component, OnInit} from '@angular/core';
import {FilmsDisplayComponent} from './display/films-display.component';
import {SearchComponent} from './display/search.component';
import {TagManagerComponent} from "./display/tags/tag-manager.component";
import {Film} from './model/film';
import {TagManagerService} from "./display/tags/tag-manager.service";

@Component({
    selector: 'app',
    templateUrl: 'app/components/app.component.html',
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