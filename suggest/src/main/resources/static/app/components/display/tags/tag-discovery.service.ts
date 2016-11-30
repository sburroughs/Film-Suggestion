import {Injectable} from '@angular/core';
import {Tag} from "../../model/tag";
import {Headers, Http, URLSearchParams, Response} from "@angular/http";
import 'rxjs/Rx'
import {Observable} from 'rxjs/Observable';


@Injectable()
export class TagDiscoveryService {

    endpoint_url: string = "http://localhost:8080/discover";

    private headers: Headers;

    constructor(private _http: Http) {

        this.headers = new Headers();
        this.headers.append('Content-Type', 'application/json');
        this.headers.append('Accept', 'application/json');
    }


    public discover(): Observable<Tag[]> {

        let params: URLSearchParams = new URLSearchParams();
        params.set('type', "default");

        return this._http.get(this.endpoint_url, {'search': params})
            .map((response: Response) => <Tag[]>response.json())
            .catch((error)=> {
                console.error(error);
                return Observable.throw(error.json().error || 'Server error');
            });
    }

}