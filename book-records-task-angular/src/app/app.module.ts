import { NgModule } from '@angular/core';
import { BrowserModule } from '@angular/platform-browser';

import { HomeComponent } from './component/home/home.component';
import { BookCardComponent } from './component/book-card/book-card.component';
import {AppComponent} from "./component/app-page/app.component";
import {PrimeModuleModule} from "./modules/prime-module";
import {HttpClientModule} from "@angular/common/http";
import { NavBarComponent } from './component/nav-bar/nav-bar.component';
import {RouterModule} from "@angular/router";
import {routes} from "./modules/router-module";
import { FormComponent } from './component/form/form.component';
import {BrowserAnimationsModule} from "@angular/platform-browser/animations";
import {ReactiveFormsModule} from "@angular/forms";

@NgModule({
  declarations: [
    AppComponent,
    HomeComponent,
    BookCardComponent,
    NavBarComponent,
    FormComponent,
  ],
  imports: [
    BrowserModule,
    PrimeModuleModule,
      HttpClientModule,
      RouterModule.forRoot(routes, {relativeLinkResolution: 'legacy'}),
    BrowserAnimationsModule,
    ReactiveFormsModule
  ],
  providers: [],
  bootstrap: [AppComponent]
})
export class AppModule { }
