import {Component, Output, EventEmitter} from '@angular/core';
import {SearchService} from './search.service';
import {Tag} from '../model/tag';

import {TagManagerService} from "./tags/tag-manager.service";
import {TagManager} from "../model/tag-manager";

@Component({
    selector: 'search',
    templateUrl: 'app/components/display/search.component.html',
    providers: [SearchService]
})
export class SearchComponent {

    query: string;

    @Output() filmUpdates = new EventEmitter();

    constructor(private service: SearchService, private tagManagerService: TagManagerService) {

    }

    public search() {

        let display: string = this.query;
        let tag: Tag = new Tag(display);

        let tagManager: TagManager = this.tagManagerService.getTagManager();
        tagManager.addLike(tag);

        let searchTags: Tag[] = tagManager.like;
        this.service.search(searchTags).subscribe((films)=> {
            this.filmUpdates.emit(films);
            console.log("SHOOOOOOOOO");
        });

        console.log("OH YEAH");
        this.query = "";

        return false;
    }

}