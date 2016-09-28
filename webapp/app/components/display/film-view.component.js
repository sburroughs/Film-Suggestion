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
var film_1 = require("../model/film");
var tag_1 = require("../model/tag");
var tag_manager_service_1 = require("./tags/tag-manager.service");
var FilmViewComponent = (function () {
    function FilmViewComponent(tagManager) {
        this.tagManager = tagManager;
    }
    FilmViewComponent.prototype.ngOnInit = function () {
        console.log(this.film);
    };
    FilmViewComponent.prototype.addTag = function () {
        var title = this.film.title;
        var tag = new tag_1.Tag(title);
        tag.display = title;
        this.tagManager.addLike(tag);
    };
    __decorate([
        core_1.Input(), 
        __metadata('design:type', film_1.Film)
    ], FilmViewComponent.prototype, "film", void 0);
    FilmViewComponent = __decorate([
        core_1.Component({
            selector: 'film-view',
            templateUrl: 'app/components/display/film-view.component.html',
        }), 
        __metadata('design:paramtypes', [tag_manager_service_1.TagManagerService])
    ], FilmViewComponent);
    return FilmViewComponent;
}());
exports.FilmViewComponent = FilmViewComponent;
//# sourceMappingURL=film-view.component.js.map