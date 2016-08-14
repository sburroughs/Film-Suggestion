import {Component, Input, Output, EventEmitter} from 'angular2/core';
import {SearchService} from './search.service';
import {Tag} from '../model/tag';


@Component({
    selector: 'search',
    templateUrl: 'app/components/display/search.component.html',
    directives: [],
    providers: [SearchService]

})
export class SearchComponent {

    query: string;

    @Output() queryUpdates = new EventEmitter();
    @Output() filmUpdates = new EventEmitter();

    constructor(private service:SearchService) {

    }

    public search() {
        this.service.search(this.query)
            .then((results)=> {
                this.filmUpdates.emit(results);

                let tag: Tag = {'display': this.query}
                this.queryUpdates.emit(tag);
            });

    }

}