"use strict";
var __decorate = (this && this.__decorate) || function (decorators, target, key, desc) {
    var c = arguments.length, r = c < 3 ? target : desc === null ? desc = Object.getOwnPropertyDescriptor(target, key) : desc, d;
    if (typeof Reflect === "object" && typeof Reflect.decorate === "function") r = Reflect.decorate(decorators, target, key, desc);
    else for (var i = decorators.length - 1; i >= 0; i--) if (d = decorators[i]) r = (c < 3 ? d(r) : c > 3 ? d(target, key, r) : d(target, key)) || r;
    return c > 3 && r && Object.defineProperty(target, key, r), r;
};
var __metadata = (this && this.__metadata) || function (k, v) {
    if (typeof Reflect === "object" && typeof Reflect.metadata === "function") return Reflect.metadata(k, v);
};
var core_1 = require('@angular/core');
var http_1 = require('@angular/http');
require('rxjs/Rx');
var Observable_1 = require('rxjs/Observable');
var SearchService = (function () {
    function SearchService(_http) {
        this._http = _http;
        this.endpoint_url = "http://localhost:8080/search";
        this.headers = new http_1.Headers();
        this.headers.append('Content-Type', 'application/json');
        this.headers.append('Accept', 'application/json');
    }
    // public search(tagManager: TagManager): Observable<Film[]> {
    SearchService.prototype.search = function (likes) {
        console.log(likes);
        var tags = likes.map(function (tag) {
            return tag['display'];
        });
        var params = new http_1.URLSearchParams();
        params.set('likes', tags.toString());
        var yeah = this._http.get(this.endpoint_url, { 'search': params })
            .map(function (response) { return response.json(); })
            .catch(function (error) {
            console.log("BONE SAW IS READY");
            console.error(error);
            return Observable_1.Observable.throw(error.json().error || 'Server error');
        });
        console.log(yeah);
        return yeah;
    };
    SearchService = __decorate([
        core_1.Injectable(), 
        __metadata('design:paramtypes', [http_1.Http])
    ], SearchService);
    return SearchService;
}());
exports.SearchService = SearchService;
//# sourceMappingURL=search.service.js.map