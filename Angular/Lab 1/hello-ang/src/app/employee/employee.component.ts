import { Component, OnInit } from '@angular/core';

@Component({
  selector: 'employee',
  templateUrl: './employee.component.html',
  styleUrls: ['./employee.component.css']
})
export class EmployeeComponent implements OnInit {

  firstName: string = "Hashem";
  lastName  ="Alhariry";
  department="JAVA";

  arrEmployee:EmployeeComponent[];

 
  constructor() { 
    this.arrEmployee=[];
  }

  ngOnInit(): void {
  }

  getFirstName():string{


    return this.firstName;
  }

  setFirstName(firstName:string):void{
      this.firstName=firstName;
  }

  setLastName(lastName:string):void{
    this.lastName=lastName;
  }

  getFullName():string{
    return this.firstName+' '+this.lastName;
  }

  getTotalNumber():number{
    return this.arrEmployee.length;
  }
  
  setDepartment(department:string):void{
    this.department=department;
  }

  
  addEmployee(firstName:string,lastName:string,department:string){
    let employee = new EmployeeComponent();
    employee.setFirstName(firstName);
    employee.setLastName(lastName);
    employee.setDepartment(department);
    this.arrEmployee.push(employee)
  }
}
