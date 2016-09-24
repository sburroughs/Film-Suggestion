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
var TagManagerService = (function () {
    function TagManagerService() {
        this.tags = [];
    }
    TagManagerService.prototype.addTag = function (tag) {
        var index = this.tags.findIndex(function (t) { return t.display == tag.display; });
        if (index === -1) {
            this.tags.push(tag);
        }
        console.log(this.tags);
    };
    TagManagerService.prototype.removeTag = function (tag) {
        var idx = this.tags.indexOf(tag);
        if (idx !== -1) {
            this.tags.splice(idx, 1);
        }
    };
    TagManagerService = __decorate([
        core_1.Injectable(), 
        __metadata('design:paramtypes', [])
    ], TagManagerService);
    return TagManagerService;
}());
exports.TagManagerService = TagManagerService;
//# sourceMappingURL=tag-manager.service.js.map