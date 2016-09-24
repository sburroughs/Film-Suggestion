import {Tag} from './tag';

export class Film {
    title: string;
    releaseDate: string;
    rated: string;
    runtime: string;
    plot: string;
    genre: string[];

    poster: string;
    tags: Tag[];
}