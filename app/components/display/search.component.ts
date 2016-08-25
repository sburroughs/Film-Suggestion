import {Component, Output, EventEmitter} from 'angular2/core';
import {SearchService} from './search.service';
import {Tag} from '../model/tag';
import {TagManagerService} from "./tags/tag-manager.service";


@Component({
    selector: 'search',
    templateUrl: 'app/components/display/search.component.html',
    directives: [],
    providers: [SearchService]

})
export class SearchComponent {

    query:string;

    @Output() filmUpdates = new EventEmitter();

    constructor(private service:SearchService, private tagManager:TagManagerService) {

    }

    public search() {
        
        let query:string = this.query;
        
        let tag:Tag = new Tag();
        tag.display = query;
        this.tagManager.addTag(tag);

        this.service.search(query).then((films)=> {
            this.filmUpdates.emit(films);
        });

        this.query = "";
    }

}