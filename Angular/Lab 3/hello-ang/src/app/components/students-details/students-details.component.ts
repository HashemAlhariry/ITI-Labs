import { HttpClient } from '@angular/common/http';
import { Component, OnInit } from '@angular/core';
import { ActivatedRoute } from '@angular/router';
import { Student } from 'src/app/models/student.model';
import { StudentView } from 'src/app/models/studentView.model';

@Component({
  selector: 'app-students-details',
  templateUrl: './students-details.component.html',
  styleUrls: ['./students-details.component.css']
})
export class StudentsDetailsComponent implements OnInit {
   student = new StudentView();
  constructor(private _activatedRoute:ActivatedRoute,private _http:HttpClient) { }

  ngOnInit() : void {
    this._activatedRoute.paramMap
    .subscribe(
      parms=>{
        let id=parms.get('id');
        this.getDetails(id);
      }
    );
  }

  getDetails(id:string):void
  {
    this._http.get(`https://api.mohamed-sadek.com/Student/GetByID?id=${id}`)
    .subscribe(
      (response:any)=>{
        this.student=response.Data;
      }
      ,(error:any)=>{
      }
    );
  }

}
