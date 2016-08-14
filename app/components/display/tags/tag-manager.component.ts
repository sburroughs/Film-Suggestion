import {Component, Input, OnInit} from 'angular2/core';
import {Tag} from "../../model/tag";

@Component({
    selector: 'tag-manager',
    templateUrl: 'app/components/display/tags/tag-manager.component.html',
    directives: []
})
export class TagManagerComponent implements OnInit {

    @Input() selectedTags: Tag[];

    ngOnInit() {

    }

    removeTag(tag: Tag){
        this.selectedTags.delete(tag);
    }

}