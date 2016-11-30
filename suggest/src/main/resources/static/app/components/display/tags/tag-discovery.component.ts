import {Component, Input, OnInit} from '@angular/core';
import {Tag} from "../../model/tag";
import {TagManagerService} from "./tag-manager.service";
import {TagDiscoveryService} from "./tag-discovery.service";

@Component({
    selector: 'tag-discovery',
    templateUrl: 'app/components/display/tags/tag-discovery.component.html',
})
export class TagDiscoveryComponent implements OnInit {

    tags:Tag[];

    constructor(private tagManager: TagManagerService, private tagDiscoveryService: TagDiscoveryService) {
        //NO-OP
    }

    submitTag(tag: Tag) {
        this.tagManager.addLike(tag);
    }

    ngOnInit(): void {

        this.tagDiscoveryService.discover().subscribe((tags) => {
            this.tags = tags;
        });

    }


}