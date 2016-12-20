import {Component, Input, OnInit, Output, EventEmitter} from '@angular/core';
import {Tag} from "../../model/tag";
import {TagManagerService} from "../tags/tag-manager.service"

@Component({
    selector: 'tag-manager',
    templateUrl: 'app/components/display/tags/tag-manager.component.html',
})
export class TagManagerComponent implements OnInit {

    @Output() tagSelected = new EventEmitter();

    selectedTags: Tag[];

    constructor(private tagManagerService: TagManagerService) {
        tagManagerService.tagUpdates.subscribe(tags => this.selectedTags = tags);
    };

    removeTag(tag: Tag): void {
        this.tagManagerService.removeLike(tag);
    };

    ngOnInit() {
        this.selectedTags = this.tagManagerService.like;
    }

}