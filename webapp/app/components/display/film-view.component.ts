import {Component, Input, NgModule} from '@angular/core';
import {Film} from "../model/film";
import {Tag} from "../model/tag";
import {TagManagerService} from "./tags/tag-manager.service";


@Component({
    selector: 'film-view',
    templateUrl: 'app/components/display/film-view.component.html',
})
export class FilmViewComponent {

    @Input() film: Film;

    constructor(private tagManager:TagManagerService){

    }

    addTag(){
        let title = this.film.title;

        let tag:Tag = new Tag();
        tag.display = title;
        this.tagManager.addTag(tag);
    }

}