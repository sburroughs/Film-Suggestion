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

    constructor(private tagManagerService: TagManagerService, private searchService: SearchService) {
        this.tagManagerService.tagUpdates.subscribe((tags) => {
            this.searchService.search(tags).subscribe(films => this.setFilms(films));
        });
    }

    setFilms(films) {
        this.films = films;
    }

    ngOnInit() {

    }

}