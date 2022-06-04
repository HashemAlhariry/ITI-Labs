import { HttpClient } from '@angular/common/http';
import { Component, OnInit } from '@angular/core';
import { StudentView } from 'src/app/models/studentView.model';

@Component({
  selector: 'app-students-view',
  templateUrl: './students-view.component.html',
  styleUrls: ['./students-view.component.css']
})
export class StudentsViewComponent implements OnInit {

  constructor(private _http:HttpClient) { }
  students:StudentView[]=[];
  ngOnInit(): void {
    this._http.get("https://api.mohamed-sadek.com/Student/Get")
    .subscribe(
      (response:any)=>{
       this.students=response.Data;
      },
      (error:any)=>{}
    );
  }



}
