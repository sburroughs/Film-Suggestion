System.register(['angular2/core', './tag-view.component', "../model/film", "../model/tag", "./tags/tag-manager.service"], function(exports_1, context_1) {
    "use strict";
    var __moduleName = context_1 && context_1.id;
    var __decorate = (this && this.__decorate) || function (decorators, target, key, desc) {
        var c = arguments.length, r = c < 3 ? target : desc === null ? desc = Object.getOwnPropertyDescriptor(target, key) : desc, d;
        if (typeof Reflect === "object" && typeof Reflect.decorate === "function") r = Reflect.decorate(decorators, target, key, desc);
        else for (var i = decorators.length - 1; i >= 0; i--) if (d = decorators[i]) r = (c < 3 ? d(r) : c > 3 ? d(target, key, r) : d(target, key)) || r;
        return c > 3 && r && Object.defineProperty(target, key, r), r;
    };
    var __metadata = (this && this.__metadata) || function (k, v) {
        if (typeof Reflect === "object" && typeof Reflect.metadata === "function") return Reflect.metadata(k, v);
    };
    var core_1, tag_view_component_1, film_1, tag_1, tag_manager_service_1;
    var FilmViewComponent;
    return {
        setters:[
            function (core_1_1) {
                core_1 = core_1_1;
            },
            function (tag_view_component_1_1) {
                tag_view_component_1 = tag_view_component_1_1;
            },
            function (film_1_1) {
                film_1 = film_1_1;
            },
            function (tag_1_1) {
                tag_1 = tag_1_1;
            },
            function (tag_manager_service_1_1) {
                tag_manager_service_1 = tag_manager_service_1_1;
            }],
        execute: function() {
            FilmViewComponent = (function () {
                function FilmViewComponent(tagManager) {
                    this.tagManager = tagManager;
                }
                FilmViewComponent.prototype.addTag = function () {
                    var title = this.film.title;
                    var tag = new tag_1.Tag();
                    tag.display = title;
                    this.tagManager.addTag(tag);
                };
                __decorate([
                    core_1.Input(), 
                    __metadata('design:type', film_1.Film)
                ], FilmViewComponent.prototype, "film", void 0);
                FilmViewComponent = __decorate([
                    core_1.Component({
                        selector: 'film-view',
                        templateUrl: 'app/components/display/film-view.component.html',
                        directives: [tag_view_component_1.TagViewComponent]
                    }), 
                    __metadata('design:paramtypes', [tag_manager_service_1.TagManagerService])
                ], FilmViewComponent);
                return FilmViewComponent;
            }());
            exports_1("FilmViewComponent", FilmViewComponent);
        }
    }
});
//# sourceMappingURL=film-view.component.js.map