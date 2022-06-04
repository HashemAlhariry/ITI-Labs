import { NgModule } from '@angular/core';
import { BrowserModule } from '@angular/platform-browser';

import { AppRoutingModule } from './app-routing.module';
import { AppComponent } from './app.component';
import { TasksComponent } from './components/tasks/tasks.component';
import { AboutComponent } from './components/about/about.component';
import { FormsModule } from '@angular/forms';

import {HttpClientModule} from '@angular/common/http';
import { ContactComponent } from './components/contact/contact.component';
import { HomeComponent } from './components/home/home.component';
import { NotFoundComponent } from './components/not-found/not-found.component';
import { DetailsComponent } from './components/details/details.component';
import { StudentsViewComponent } from './components/students-view/students-view.component';
import { StudentsAddComponent } from './components/students-add/students-add.component';
import { StudentsDetailsComponent } from './components/students-details/students-details.component'


@NgModule({
  declarations: [
    AppComponent,
    TasksComponent,
    AboutComponent,
    ContactComponent,
    HomeComponent,
    NotFoundComponent,
    DetailsComponent,
    StudentsViewComponent,
    StudentsAddComponent,
    StudentsDetailsComponent
  ],
  imports: [
    BrowserModule,
    AppRoutingModule,FormsModule
    ,HttpClientModule
  ],
  providers: [],
  bootstrap: [AppComponent]
})
export class AppModule { }
