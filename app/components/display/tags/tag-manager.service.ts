import {Injectable} from 'angular2/core';
import {Tag} from "../../model/tag";

@Injectable()
export class TagManagerService {

    //this would be better off a Map, having trouble getting it to work with live view
    tags:Tag[];

    constructor() {
        this.tags = [];
    }

    public addTag(tag:Tag) {

        var index = this.tags.findIndex(t => t.display == tag.display);
        if (index === -1) {
            this.tags.push(tag);
        }
        console.log(this.tags);
    }

    public removeTag(tag:Tag) {

        var idx = this.tags.indexOf(tag);
        if (idx !== -1) {
            this.tags.splice(idx, 1);
        }
    }


}