import {Component} from 'angular2/core';
import {FilmsDisplayComponent} from './display/films-display.component';
import {SearchComponent} from './display/search.component';

@Component({
    selector: 'app',
    templateUrl: 'app/components/app.component.html',
    directives: [FilmsDisplayComponent, SearchComponent]
})
export class AppComponent {

    films;
    
    setFilms($event){
        this.films = $event;
    }

}