import {Injectable} from 'angular2/core';

@Injectable()
export class SearchService {


    public search(query) {

        var mock = [];

        var count = query.length;
        for (var i = 0; i < count; i++) {
            mock.push({
                'title': 'Free Willy',
                'description': 'This movie is dope as fuck yo.',
                'year': '1997',

                'tags': [
                    {'display': 'HOT'},
                    {'display': 'WHALE'},
                    {'display': 'ACTION'}
                ],
                'imageUrl': '../../images/sample.jpg'
            });
        }
        return mock;

    }


}