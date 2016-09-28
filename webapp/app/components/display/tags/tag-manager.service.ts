import {Injectable} from '@angular/core';
import {Tag} from "../../model/tag";

@Injectable()
export class TagManagerService {

    like: Tag[];
    // dislike: Set<Tag>;

    constructor(){
        this.like = [];
    }

    public addLike(tag:Tag) {
        var index = this.like.findIndex(t => t.display == tag.display);
        if (index === -1) {
            this.like.push(tag);
        }
    }

    public removeLike(tag:Tag) {
        var idx = this.like.indexOf(tag);
        if (idx !== -1) {
            this.like.splice(idx, 1);
        }
    }
}