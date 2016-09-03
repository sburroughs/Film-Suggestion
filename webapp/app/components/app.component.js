System.register(['angular2/core', './display/films-display.component', './display/search.component', "./display/tags/tag-manager.component", "./display/tags/tag-manager.service"], function(exports_1, context_1) {
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
    var core_1, films_display_component_1, search_component_1, tag_manager_component_1, tag_manager_service_1;
    var AppComponent;
    return {
        setters:[
            function (core_1_1) {
                core_1 = core_1_1;
            },
            function (films_display_component_1_1) {
                films_display_component_1 = films_display_component_1_1;
            },
            function (search_component_1_1) {
                search_component_1 = search_component_1_1;
            },
            function (tag_manager_component_1_1) {
                tag_manager_component_1 = tag_manager_component_1_1;
            },
            function (tag_manager_service_1_1) {
                tag_manager_service_1 = tag_manager_service_1_1;
            }],
        execute: function() {
            AppComponent = (function () {
                function AppComponent() {
                }
                AppComponent.prototype.setFilms = function ($event) {
                    this.films = $event;
                };
                AppComponent.prototype.ngOnInit = function () {
                };
                AppComponent = __decorate([
                    core_1.Component({
                        selector: 'app',
                        templateUrl: 'app/components/app.component.html',
                        directives: [search_component_1.SearchComponent, tag_manager_component_1.TagManagerComponent, films_display_component_1.FilmsDisplayComponent],
                        providers: [tag_manager_service_1.TagManagerService]
                    }), 
                    __metadata('design:paramtypes', [])
                ], AppComponent);
                return AppComponent;
            }());
            exports_1("AppComponent", AppComponent);
        }
    }
});
//# sourceMappingURL=app.component.js.map