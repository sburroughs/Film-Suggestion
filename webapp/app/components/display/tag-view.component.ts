import {Component, Input, Output, EventEmitter, OnInit} from 'angular2/core';
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
        this.tagManager.addTag(tag);
    }

}