import {Component, Input, Output, EventEmitter} from 'angular2/core';
import {SearchService} from './search.service';


@Component({
    selector: 'search',
    templateUrl: 'app/components/display/search.component.html',
    directives: [],
    providers: [SearchService]

})
export class SearchComponent {

    query;
    @Output() filmUpdates = new EventEmitter();

    constructor(private service:SearchService) {

    }

    public search() {
        var results = this.service.search(this.query);
        this.filmUpdates.emit(results);
    }

}