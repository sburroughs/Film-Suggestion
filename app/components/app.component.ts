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
    selectedTags = [];

    public search(query) {

        var mock = [];

        var count = query.length;
        for (var i = 0; i < count; i++) {
            mock.push({
                'title': 'Free Willy',
                'description': 'This movie is dope as fuck yo.',
                'tags': [
                    {'display': 'HOT'},
                    {'display': 'WHALE'},
                    {'display': 'ACTION'}
                ],
                'imageUrl': '../../images/sample.jpg'
            });
        }
        this.films = mock;
    }

    public addTag(tag) {
        this.selectedTags.push(tag);
    }

}