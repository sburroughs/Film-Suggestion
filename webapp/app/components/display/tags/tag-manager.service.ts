import {Injectable} from '@angular/core';
import {TagManager} from "../../model/tag-manager";

@Injectable()
export class TagManagerService {

    tagManager: TagManager;

    constructor() {
        this.tagManager = new TagManager();
    }

    public getTagManager(): TagManager {
        return this.tagManager;
    }

}