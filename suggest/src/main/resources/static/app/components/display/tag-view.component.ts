import {Component, Input} from '@angular/core';
import {Tag} from "../model/tag";
import {TagManagerService} from "./tags/tag-manager.service";

@Component({
    selector: 'tag-view',
    templateUrl: 'app/components/display/tag-view.component.html',
})
export class TagViewComponent {

    @Input() tags;

    constructor(private tagManager:TagManagerService){

    }

    submitTag(tag:Tag){
        this.tagManager.addLike(tag);
    }

}