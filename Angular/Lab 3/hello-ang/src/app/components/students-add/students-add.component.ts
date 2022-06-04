import { HttpClient } from '@angular/common/http';
import { Component, OnInit } from '@angular/core';
import { Student } from 'src/app/models/student.model';

@Component({
  selector: 'app-students-add',
  templateUrl: './students-add.component.html',
  styleUrls: ['./students-add.component.css']
})
export class StudentsAddComponent implements OnInit {

  constructor(private _http:HttpClient) { }

  ngOnInit(): void {
  }

  addStudent(firstName:string,lastName:string,mobileNumber:string,email:string,nationalID:string,age:number):void{
    let student  = new Student();
    student.FirstName=firstName;
    student.LastName=lastName;
    student.Mobile=mobileNumber;
    student.Email=email;
    student.NationalID=nationalID;
    student.Age=age;
    console.log(student);

    this._http.post("https://api.mohamed-sadek.com/Student/POST", student).subscribe(
      (response:any)=>{
        alert(response.Message);
      },
      (error:any)=>{
        alert("Error "+error.Message);
      }
    );
  }
}
