import {Component, OnInit} from '@angular/core';
import {SearchService} from './search.service';
import {Film} from './model/film';

@Component({
    selector: 'app',
    templateUrl: 'app/components/app.component.html',
    providers: [SearchService]

})
export class AppComponent implements OnInit {

    title:string;
    year:string;
    search:string;

    constructor(private service: SearchService) {
    }

    addTitle() {

        console.log("Add Title");
        this.service.titleImport(this.title).subscribe((films)=> {
            console.log("Title Added");
            console.log(films);
        });


    }

    searchTitle() {

        console.log("Search Title");
        this.service.search(this.search).subscribe((film)=> {
            console.log("Film Found");
            console.log(film);
        });

        console.log("Update Title");
    }

    ngOnInit() {

    }

}