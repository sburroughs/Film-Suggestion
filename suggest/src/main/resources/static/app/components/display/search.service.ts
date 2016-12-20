import {Injectable} from '@angular/core';
import {Http, Headers, Response, URLSearchParams} from '@angular/http';
import {Location} from '@angular/common';
import 'rxjs/Rx'
import {Film} from "../model/film";
import {Observable} from 'rxjs/Observable';
import {Tag} from "../model/tag";
import {TagManagerService} from "./tags/tag-manager.service";

@Injectable()
export class SearchService {

    private endpoint_url: string = "/search";

    constructor(private _http: Http, private _location: Location) {
    }

    public search(likes: Tag[]): Observable<Film[]> {

        console.log("SEARCHING");

        var tags = likes.map(function (tag) {
            return tag['display'];
        });

        let params: URLSearchParams = new URLSearchParams();
        params.set('likes', tags.toString());

        return this._http.get(this._location.prepareExternalUrl(this.endpoint_url), {'search': params})
            .map((response: Response) => <Film[]>response.json())
            .catch((error) => {
                console.error(error);
                return Observable.throw(error.json().error || 'Server error');
            });
    }

}