import {Component, Output, EventEmitter} from '@angular/core';
import {SearchService} from './search.service';
import { CompleterService, CompleterData } from 'ng2-completer';
import {Tag} from '../model/tag';

import {TagManagerService} from "./tags/tag-manager.service";

const AUTOCOMPLETE_ENDPOINT = "/autocomplete/";

@Component({
    selector: 'search',
    templateUrl: 'app/components/display/search.component.html',
    providers: [SearchService]
})
export class SearchComponent {

    @Output() filmUpdates = new EventEmitter();

    private query: string;
    private dataService: CompleterData;

    constructor(private service: SearchService, private tagManager: TagManagerService, private completerService: CompleterService) {
        this.dataService = completerService.remote(AUTOCOMPLETE_ENDPOINT, 'name', 'name').descriptionField("source");
    }

    public search() {

        let display: string = this.query;
        let tag: Tag = new Tag(display);

        this.tagManager.addLike(tag);

        let searchTags: Tag[] = this.tagManager.like;
        this.service.search(searchTags).subscribe((films)=> {
            this.filmUpdates.emit(films);
        });

        this.query = "";

        return false;
    }

}