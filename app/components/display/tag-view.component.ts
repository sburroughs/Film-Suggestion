import {Component, Input, Output, EventEmitter, OnInit} from 'angular2/core';

@Component({
    selector: 'tag-view',
    templateUrl: 'app/components/display/tag-view.component.html',
})
export class TagViewComponent implements OnInit {

    @Input() tags;

    @Output() selectTag = new EventEmitter();

    ngOnInit() {

    }

    submitTag(tag){
        this.selectTag.emit(tag);
    }

}