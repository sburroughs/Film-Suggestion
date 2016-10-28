import {Component, Input, OnInit, Output, EventEmitter} from '@angular/core';
import {Tag} from "../../model/tag";
import {TagManagerService} from "../tags/tag-manager.service"

@Component({
    selector: 'tag-manager',
    templateUrl: 'app/components/display/tags/tag-manager.component.html',
})
export class TagManagerComponent implements OnInit{

    @Output() tagSelected = new EventEmitter();

    selectedTags:Tag[];

    constructor(private tagManagerService:TagManagerService) {
    };

    removeTag(tag:Tag):void {
        this.tagManagerService.removeLike(tag);
        console.log("removing tag");
        this.emit();
    };

    emit(){
        this.tagSelected.emit(this.selectedTags);
    }

    ngOnInit(){
        this.selectedTags = this.tagManagerService.like;
    }

}