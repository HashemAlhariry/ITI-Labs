import { DetailsComponent } from './components/details/details.component';
import { NotFoundComponent } from './components/not-found/not-found.component';
import { AboutComponent } from './components/about/about.component';
import { ContactComponent } from './components/contact/contact.component';
import { HomeComponent } from './components/home/home.component';
import {StudentsViewComponent} from './components/students-view/students-view.component'
import {StudentsAddComponent} from './components/students-add/students-add.component'
import {StudentsDetailsComponent} from './components/students-details/students-details.component'
import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';

const routes: Routes = [
  {path:'home',component:HomeComponent},
  {path:'contact',component:ContactComponent},
  {path:'tasks/details/:id',component:DetailsComponent},

  {path:'addStudents',component:StudentsAddComponent},
  {path:'viewStudents',component:StudentsViewComponent},
  {path:'viewStudents/details/:id',component:StudentsDetailsComponent},
  
  {path:'about',component:AboutComponent},
  {path:'',component:HomeComponent},
  {path:'**',component:NotFoundComponent}
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
