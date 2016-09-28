import {Injectable} from '@angular/core';
import {Http, Headers, Response, URLSearchParams} from '@angular/http';
import 'rxjs/Rx'
import {Film} from "../model/film";
import {Observable} from 'rxjs/Observable';
import {Tag} from "../model/tag";


@Injectable()
export class SearchService {

    endpoint_url: string = "http://localhost:8080/search";

    private headers: Headers;

    constructor(private _http: Http) {

        this.headers = new Headers();
        this.headers.append('Content-Type', 'application/json');
        this.headers.append('Accept', 'application/json');
    }


    // public search(tagManager: TagManager): Observable<Film[]> {
    public search(likes: Tag[]): Observable<Film[]> {

        var tags = likes.map(function (tag) {
            return tag['display'];
        });

        let params: URLSearchParams = new URLSearchParams();
        params.set('likes', tags.toString());

        return this._http.get(this.endpoint_url, {'search': params})
            .map((response: Response) => <Film[]>response.json())
            .catch((error)=> {
                console.error(error);
                return Observable.throw(error.json().error || 'Server error');
            });
    }

}