import {Injectable} from '@angular/core';
import {Http} from '@angular/http';
import 'rxjs/Rx'
import {Film} from "../model/film";
import {Observable} from 'rxjs/Observable';


@Injectable()
export class SearchService {

    endpoint_url: String = "localhost:8080/";

    constructor(private http: Http) {
    }

    public search(query: string): Observable<Film[]> {



        return this.http.get(this.endpoint_url + query).map(res => res.json());
    }

}