import {Tag} from './tag';

export class Film {
    title: string;
    releaseDate: Date;
    rated: string;
    runtime: string;
    plot: string;
    genre: string[];

    poster: string;
    tags: Tag[];
}