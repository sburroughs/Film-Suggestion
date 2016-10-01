import {Component, Input, OnInit} from '@angular/core';
import {Tag} from "../../model/tag";
import {TagManagerService} from "../tags/tag-manager.service"

@Component({
    selector: 'tag-manager',
    templateUrl: 'app/components/display/tags/tag-manager.component.html',
})
export class TagManagerComponent implements OnInit{

    selectedTags:Tag[];

    constructor(private tagManagerService:TagManagerService) {
    };

    removeTag(tag:Tag):void {
        this.tagManagerService.removeLike(tag);
    };

    ngOnInit(){
        this.selectedTags = this.tagManagerService.like;
    }

}