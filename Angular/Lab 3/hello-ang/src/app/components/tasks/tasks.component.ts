import { Task } from './../../models/task.model';
import { Component, EmbeddedViewRef, OnInit } from '@angular/core';
import { HttpClient } from '@angular/common/http';

@Component({
  selector: 'app-tasks',
  templateUrl: './tasks.component.html',
  styleUrls: ['./tasks.component.css']
})
export class TasksComponent implements OnInit {

  tasks:Task[]=[];
  constructor(private _http:HttpClient) { }

  ngOnInit(): void {
    this._http.get("https://api.mohamed-sadek.com/Task/Get")
    .subscribe(
      (response:any)=>{
       this.tasks=response.Data;
      },
      (error:any)=>{}
    );
    //alert("2");
   
  }

  add(title:string):void
  {
    let task=new Task();
    task.Title=title;
    this._http.post("https://api.mohamed-sadek.com/Task/POST",task)
    .subscribe(
      (response:any)=>{
        task.ID=response.Data;
        this.tasks.push(task);
      },
      (error:any)=>{
        alert("error")
      }
    );
    
  }

  delete(index:number):void
  {
    let task=this.tasks[index];
    this._http.delete(`https://api.mohamed-sadek.com/Task/Delete?id=${task.ID}`)
    .subscribe(
      (response:any)=>{
        if(response.Success)
        {
          this.tasks.splice(index,1);
          alert(response.Message);
        }
      },
      (error:any)=>{
        alert("error")
      }
    );
    
  }

  update(task:Task)
  {
    task.IsDone=!task.IsDone;
    this._http.put("https://api.mohamed-sadek.com/Task/PUT",task)
    .subscribe(
      (response:any)=>{
       
      },
      (error:any)=>{
        alert("error")
      }
    );
  }

  getPendingTasksCount():number
  {
    return this.tasks.filter(task=>!task.IsDone).length;
  }

}
