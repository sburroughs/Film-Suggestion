import {Component, Input, NgModule, OnInit} from '@angular/core';
import {Film} from "../model/film";
import {Tag} from "../model/tag";
import {TagManagerService} from "./tags/tag-manager.service";


@Component({
    selector: 'film-view',
    templateUrl: 'app/components/display/film-view.component.html',
})
export class FilmViewComponent implements OnInit {


    @Input() film: Film;

    year:any;

    constructor(private tagManager: TagManagerService) {

    }

    ngOnInit(): void {

        console.log(this.film);

    }

    addTag() {
        let title = this.film.title;

        let tag: Tag = new Tag(title);
        tag.display = title;
        this.tagManager.addLike(tag);
    }

}