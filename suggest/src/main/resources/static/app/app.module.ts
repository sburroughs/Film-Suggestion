import {NgModule}      from '@angular/core';
import {BrowserModule} from '@angular/platform-browser';
import {AppComponent}   from './components/app.component';
import {TagViewComponent} from "./components/display/tag-view.component";
import {FilmViewComponent} from "./components/display/film-view.component";
import {FilmsDisplayComponent} from "./components/display/films-display.component";
import {TagManagerComponent} from "./components/display/tags/tag-manager.component";
import {SearchComponent} from "./components/display/search.component";
import {FormsModule} from "@angular/forms";
import {HttpModule} from "@angular/http";
import {Ng2CompleterModule} from "ng2-completer";
@NgModule({
    imports: [BrowserModule, FormsModule, HttpModule, Ng2CompleterModule],
    declarations: [
        AppComponent,
        TagViewComponent,
        FilmViewComponent,
        SearchComponent,
        TagManagerComponent,
        FilmsDisplayComponent,
    ],
    bootstrap: [AppComponent]
})
export class AppModule {
}