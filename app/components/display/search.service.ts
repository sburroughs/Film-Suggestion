import {Injectable} from 'angular2/core';
import {Film} from "../model/film";

@Injectable()
export class SearchService {

    inverse:boolean = true;

    public search(query:string) {
        
        return new Promise<Film[]>((resolve) => {

            var mock = [];

            let count:number = query.length;

            for (var i = 0; i < count; i++) {

                let filmA:Film = {
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
                    'ratings': {
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
                    'watch': [{'url': 'https://www.netflix.com/title/70178217'}]
                };//END OBJECT

                let filmB:Film = {
                    'title': 'Frozen',
                    'released': '27 Nov 2013',
                    'rated': 'PG',
                    'runtime': '102 min',
                    'genre': ['Animation', 'Adventure', 'Comedy'],
                    'cast': {
                        'director': 'Stephen Frears',
                        'writer': 'Steve Coogan (screenplay), Jeff Pope (screenplay), Martin Sixsmith (book)',
                        'actors': ['Kristen Bell', 'Idina Menzel', 'Jonathan Groff', 'Josh Gad'],
                        'production': 'The Weinstein Company',
                    },
                    'ratings': {
                        'metascore': '74',
                        'IMDB': '7.6',
                        'rottenTomatoes': '92',
                        'nominations': 'Won 2 Oscars. Another 72 wins & 57 nominations',
                    },
                    'plot': 'When the newly crowned Queen Elsa accidentally uses her power to turn things into ice to curse her home in infinite winter, her sister, Anna, teams up with a mountain man, his playful reindeer, and a snowman to change the weather condition.',
                    'language': 'English',
                    'country': 'USA',
                    'poster': 'http://ia.media-imdb.com/images/M/MV5BMTQ1MjQwMTE5OF5BMl5BanBnXkFtZTgwNjk3MTcyMDE@._V1_SX300.jpg',
                    'boxOffice': 'N/A',

                    'tags': [
                        {'display': 'Animated'},
                        {'display': 'Children'},
                        {'display': 'Popular'},
                        {'display': 'Uplifting'},
                        {'display': 'Popular'},
                        {'display': 'Disney'}
                    ],
                    'watch': [
                        {
                            'url': 'https://www.amazon.com/dp/B00J2PCCYQ'
                        },
                        {
                            'url': 'http://www.vudu.com/movies/#!content/489612'
                        }
                    ]
                };//END OBJECT


                this.inverse = !this.inverse;
                if (this.inverse) {
                    mock.push(filmA);
                }
                else {
                    mock.push(filmB);
                }
            }

            if (count % 2 == 0)
                this.inverse = !this.inverse;


            //mimics long query return
            var millisecondsToWait = 200;
            setTimeout(function () {
                resolve(mock);
            }, millisecondsToWait);
        });
    }

}