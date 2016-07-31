import {Injectable} from 'angular2/core';

@Injectable()
export class SearchService {

    public search(query) {
        return new Promise((resolve) => {

            var mock = [];

            var count = query.length;
            for (var i = 0; i < count; i++) {
                mock.push(
                    {
                        'title': 'Philomena',
                        'released': '27 Nov 2013',
                        'rated': 'PG-13',
                        'runtime': '98 min',
                        'genre': ['Biography', 'Drama'],
                        'cast': {
                            'director': 'Stephen Frears',
                            'writer': 'Steve Coogan (screenplay), Jeff Pope (screenplay), Martin Sixsmith (book)',
                            'actors': ['Judi Dench', 'Steve Coogan', 'Sophie Kennedy Clark', 'Mare Winningham'],
                            'production': 'The Weinstein Company',
                        },
                        'reviewsRatings': {
                            'metascore': '76',
                            'IMDB': '7.6',
                            'rottenTomatoes': '92',
                            'nominations': 'Nominated for 4 Oscars. Another 31 wins & 75 nominations.',
                        },
                        'plot': 'A world-weary political journalist picks up the story of a woman\'s search for her son, who was taken away from her decades ago after she became pregnant and was forced to live in a convent.',
                        'language': 'English',
                        'country': 'UK, USA, France',
                        'poster': 'http://ia.media-imdb.com/images/M/MV5BMjA5ODgyNzcxMV5BMl5BanBnXkFtZTgwMzkzOTYzMDE@._V1_SX300.jpg',
                        'boxOffice': 'N/A',

                        'tags': [
                            {'display': 'Award Winning'},
                            {'display': 'Highly Rated'},
                            {'display': 'Action Packed'},
                            {'display': 'Moist'}
                        ],
                        'watch':['https://www.netflix.com/title/70178217']
                    } //END OBJECT
                );
            }

            resolve(mock);
        });
    }

}