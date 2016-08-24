import {Component, Input, Output, EventEmitter} from 'angular2/core';
import {SearchService} from './search.service';
import {Tag} from '../model/tag';
import {SpinnerService} from "../spinner/spinner.service";
import {TagManagerService} from "./tags/tag-manager.service";


@Component({
    selector: 'search',
    templateUrl: 'app/components/display/search.component.html',
    directives: [],
    providers: [SearchService, SpinnerService]

})
export class SearchComponent {

    query:string;

    @Output() filmUpdates = new EventEmitter();

    constructor(private service:SearchService, private spinner:SpinnerService, private tagManager:TagManagerService) {

    }

    public search() {

        this.spinner.start()

        let query:string = this.query;
        this.service.search(query).then((films)=> {

            let tag:Tag = {'display': query};
            this.tagManager.addTag(tag);

            this.filmUpdates.emit(films);

            this.spinner.stop();
        });

    }

}