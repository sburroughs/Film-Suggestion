import {Component, Input, OnInit} from 'angular2/core';

@Component({
    selector: 'tag-view',
    templateUrl: 'app/components/display/tag-view.component.html',
})
export class TagViewComponent implements OnInit {

    @Input() tags;

    ngOnInit() {

    }

}