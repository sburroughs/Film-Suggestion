import {Injectable, DynamicComponentLoader, ApplicationRef, ElementRef, ComponentRef} from 'angular2/core';

import {SpinnerComponent} from './spinner.component';

@Injectable()
export class SpinnerService {
    spinnerComp: ComponentRef;
    constructor(private componentLoader: DynamicComponentLoader, private appRef: ApplicationRef) { }

    public start() {
        let elementRef: ElementRef = this.appRef['_rootComponents'][0].location;

        return this.startInside(elementRef, null);
    }

    public startInside(elementRef: ElementRef, anchorName: string) {
        let spinnerRef = (!anchorName) ?
            this.componentLoader.loadNextToLocation(SpinnerComponent, elementRef) :
            this.componentLoader.loadIntoLocation(SpinnerComponent, elementRef, anchorName);

        spinnerRef.then((compRef:ComponentRef) => {
            this.spinnerComp = compRef;
        });
    }

    public stop() {
        if (this.spinnerComp) {
            this.spinnerComp.dispose();
        }
    }
}