import {Component, Output, EventEmitter} from '@angular/core';
import {SearchService} from './search.service';
import {CompleterService, CompleterData} from 'ng2-completer';
import {Tag} from '../model/tag';

import {TagManagerService} from "./tags/tag-manager.service";
import {Location} from "@angular/common";

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

    constructor(private tagManager: TagManagerService, private completerService: CompleterService, location: Location) {
        this.dataService = completerService.remote(location.prepareExternalUrl(AUTOCOMPLETE_ENDPOINT), 'name', 'name').descriptionField("source");
    }

    public search() {

        let display: string = this.query;
        let tag: Tag = new Tag(display);

        this.tagManager.addLike(tag);

        this.query = "";

        return false;
    }

}