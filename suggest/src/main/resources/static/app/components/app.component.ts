import {Component, OnInit} from '@angular/core';
import {Film} from './model/film';
import {TagManagerService} from "./display/tags/tag-manager.service";
import {SearchService} from "./display/search.service";

@Component({
    selector: 'app',
    templateUrl: 'app/components/app.component.html',
    providers: [TagManagerService, SearchService]
})
export class AppComponent implements OnInit {

    films:Film[];

    constructor(private searchService:SearchService){
    }

    setFilms($event) {
        this.films = $event;
    }

    tagSelected($event){
        this.searchService.search($event)
            .subscribe((films) => this.setFilms(films));
    }

    ngOnInit() {

    }

}