import {Routes} from "@angular/router";
import {HomeComponent} from "../component/home/home.component";
import {FormComponent} from "../component/form/form.component";
import {AppComponent} from "../component/app-page/app.component";

export const routes: Routes = [
    {path: 'book', component: HomeComponent},
    {path: 'form', component: FormComponent}
];
