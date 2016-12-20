import {Injectable} from '@angular/core';
import {Http, Headers, Response, URLSearchParams} from '@angular/http';
import 'rxjs/Rx'
import {Observable} from 'rxjs/Observable';


const TITLE_ENDPOINT = "/movie";
const SEARCH_ENDPOINT = "/search";


@Injectable()
export class SearchService {

    private headers: Headers;

    constructor(private _http: Http) {

        this.headers = new Headers();
        this.headers.append('Content-Type', 'application/json');
        this.headers.append('Accept', 'application/json');
    }


    public titleImport(title: string) {

        return this._http.post(TITLE_ENDPOINT, title)
            .map((response: Response) => response.json())
            .catch((error)=> {
                console.error(error);
                return Observable.throw(error.json().error || 'Server error');
            });
    }

    public search(title: string) {

        let params: URLSearchParams = new URLSearchParams();
        params.set('title', title);

        return this._http.get(SEARCH_ENDPOINT, {'search': params})
            .map((response: Response) => response.json())
            .catch((error)=> {
                console.error(error);
                return Observable.throw(error.json().error || 'Server error');
            });
    }


}