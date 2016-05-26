import {Component} from 'angular2/core';
import {Media} from './media/media';
import {FilmsDisplayComponent} from './display/films-display.component'

@Component({
    selector: 'app',
    templateUrl: 'app/components/app.component.html',
    directives: [FilmsDisplayComponent]
})
export class AppComponent {

    films;

    public search(query) {

        var mock = [];

        var count = query.length;
        for(var i = 0; i < count; i++){
            mock.push({'title': 'Free Willy'});
        }
        this.films = mock;
    }

}