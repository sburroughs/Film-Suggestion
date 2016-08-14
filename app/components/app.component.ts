import {Component, OnInit} from 'angular2/core';
import {FilmsDisplayComponent} from './display/films-display.component';
import {SearchComponent} from './display/search.component';
import {TagManagerComponent} from "./display/tags/tag-manager.component";
import {Film} from './model/film';
import {Tag} from './model/tag';

@Component({
    selector: 'app',
    templateUrl: 'app/components/app.component.html',
    directives: [FilmsDisplayComponent, SearchComponent, TagManagerComponent]
})
export class AppComponent implements OnInit{

    films: Film[];

    selectedTags: Tag[];

    
    setFilms($event){
        this.films = $event;
    }
    
    addTag(tag:Tag){
        this.selectedTags.add(tag);
    }


    ngOnInit(){
        this.selectedTags = new Set();
    }

    

}