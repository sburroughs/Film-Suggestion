import {Component, OnInit} from "@angular/core";
import {Film} from "./model/film";
import {TagManagerService} from "./display/tags/tag-manager.service";
import {SearchService} from "./display/search.service";
import {TagDiscoveryService} from "./display/tags/tag-discovery.service";
import {Location, LocationStrategy, PathLocationStrategy} from "@angular/common";

@Component({
    selector: 'app',
    templateUrl: 'app/components/app.component.html',
    providers: [TagManagerService, SearchService, TagDiscoveryService,
        Location, {
            provide: LocationStrategy,
            useClass: PathLocationStrategy
        }]
})
export class AppComponent implements OnInit {

    films: Film[];

    constructor(private searchService: SearchService) {
    }

    setFilms($event) {
        this.films = $event;
    }

    tagSelected($event) {
        this.searchService.search($event)
            .subscribe((films) => this.setFilms(films));
    }

    ngOnInit() {

    }

}