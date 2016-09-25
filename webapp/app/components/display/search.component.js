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
var search_service_1 = require('./search.service');
var tag_1 = require('../model/tag');
var tag_manager_service_1 = require("./tags/tag-manager.service");
var SearchComponent = (function () {
    function SearchComponent(service, tagManagerService) {
        this.service = service;
        this.tagManagerService = tagManagerService;
        this.filmUpdates = new core_1.EventEmitter();
    }
    SearchComponent.prototype.search = function () {
        var _this = this;
        var display = this.query;
        var tag = new tag_1.Tag(display);
        var tagManager = this.tagManagerService.getTagManager();
        tagManager.addLike(tag);
        var searchTags = tagManager.like;
        this.service.search(searchTags).subscribe(function (films) {
            _this.filmUpdates.emit(films);
            console.log("SHOOOOOOOOO");
        });
        console.log("OH YEAH");
        this.query = "";
        return false;
    };
    __decorate([
        core_1.Output(), 
        __metadata('design:type', Object)
    ], SearchComponent.prototype, "filmUpdates", void 0);
    SearchComponent = __decorate([
        core_1.Component({
            selector: 'search',
            templateUrl: 'app/components/display/search.component.html',
            providers: [search_service_1.SearchService]
        }), 
        __metadata('design:paramtypes', [search_service_1.SearchService, tag_manager_service_1.TagManagerService])
    ], SearchComponent);
    return SearchComponent;
}());
exports.SearchComponent = SearchComponent;
//# sourceMappingURL=search.component.js.map