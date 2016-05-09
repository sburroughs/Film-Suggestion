import {Component} from 'angular2/core';
import {RouteConfig, ROUTER_DIRECTIVES, ROUTER_PROVIDERS} from 'angular2/router';

@Component({
    selector: 'portfolio',
    template: `
    
        <h1>Film Suggestion</h1>
        
    
    
    `,
    directives: [ROUTER_DIRECTIVES],
    providers: [
        ROUTER_PROVIDERS,
    ]
})
@RouteConfig([
    // {
    //     path: '/overview',
    //     name: 'Overview',
    //     component: OverviewComponent,
    //     useAsDefault: true
    // },
    // {
    //     path: '/skill/:name',
    //     name: 'SkillDetail',
    //     component: SkillDetailComponent
    // },
    // {
    //     path: '/skills',
    //     name: 'Skills',
    //     component: SkillsComponent
    // },
    // {
    //     path: '/experience',
    //     name: 'Experience',
    //     component: ExperienceComponent
    // },
    // {
    //     path: '/personal',
    //     name: 'Personal',
    //     component: PersonalComponent
    // },

])
export class AppComponent {

}