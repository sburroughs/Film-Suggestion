import {Injectable, Output, EventEmitter} from '@angular/core';
import {Tag} from "../../model/tag";

@Injectable()
export class TagManagerService {

    like: Tag[];
    // dislike: Set<Tag>;

    @Output() tagUpdates = new EventEmitter();


    constructor() {
        this.like = [];
    }

    public update() {
        this.tagUpdates.emit(this.like);
    }

    public addLike(tag: Tag) {
        var index = this.like.findIndex(t => t.display == tag.display);
        if (index === -1) {
            this.like.push(tag);
        }

        this.update();

    }

    public removeLike(tag: Tag) {
        var idx = this.like.indexOf(tag);
        if (idx !== -1) {
            this.like.splice(idx, 1);
        }

        this.update();

    }
}