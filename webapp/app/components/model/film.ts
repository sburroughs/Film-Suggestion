import {Tag} from './Tag.ts';

export class Film {
    'title': string;
    'released': string;
    'rated': string;
    'runtime': string;
    'genre': string[];
    'cast': Cast;
    'ratings': Ratings;
    'plot': string;
    'language': string;
    'country': string;
    'poster': string;
    'boxOffice': string;
    'tags': Tag[];
    'watch': MediaAccess[];
}

export class Cast {
    'director': string;
    'writer': string;
    'actors': string[];
    'production': string;
}

export class Ratings {
    'metascore': string;
    'IMDB': string;
    'rottenTomatoes': string;
    'nominations': string;
}

export class MediaAccess{
    url: string;
}