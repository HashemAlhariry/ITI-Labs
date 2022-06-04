import { HttpClient } from '@angular/common/http';
import { Task } from './../../models/task.model';
import { Component, OnInit } from '@angular/core';
import { ActivatedRoute } from '@angular/router';

@Component({
  selector: 'app-details',
  templateUrl: './details.component.html',
  styleUrls: ['./details.component.css']
})
export class DetailsComponent implements OnInit {

  task:Task=new Task();
  constructor(private _activatedRoute:ActivatedRoute,private _http:HttpClient) { }

  ngOnInit(): void {
    this._activatedRoute.paramMap
    .subscribe(
      parms=>{
        let id=parms.get('id');
        //alert(id);
        this.getDetails(id);
      }
    );

  }

  getDetails(id:string):void
  {
    this._http.get(`https://api.mohamed-sadek.com/Task/GetByID?id=${id}`)
    .subscribe(
      (response:any)=>{
        this.task=response.Data;
      }
      ,(error:any)=>{

      }
    );
  }

}
