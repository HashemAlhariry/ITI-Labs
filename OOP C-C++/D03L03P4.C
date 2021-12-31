#include <stdio.h>
#include <conio.h>

#define size 5

struct Employee {


	char name[50];


	int code;


	float salary;


	float deduct;


	float bonus;


};

struct AllEmployees{


   struct Employee e1 [size];

};



struct AllEmployees readEmployeeData(struct AllEmployees employees);


void printEmployeeData(struct AllEmployees employees);


int main(){

	struct AllEmployees employees;


	clrscr();


	employees = readEmployeeData(employees);


	clrscr();


	printEmployeeData(employees);


	getch();


 return 0;

}


struct AllEmployees readEmployeeData(struct AllEmployees employees){


	int i=0;

	for(i=0 ; i<size ; i++){

		gotoxy(25,7);

		printf("Please Enter Name : ");

		gets(employees.e1[i].name);

		gotoxy(25,10);

		printf("Please Enter the code : ");

		scanf("%d",&employees.e1[i].code);

		gotoxy(25,13);

		printf("Please Enter salary : ");

		scanf("%f",&employees.e1[i].salary);

		gotoxy(25,16);
		printf("Please Enter any bonuses : ");

		scanf("%f",&employees.e1[i].bonus);

		gotoxy(25,19);

		printf("Please Enter a deduction : ");

		scanf("%f",&employees.e1[i].deduct);

		clrscr();

	  }

	return employees;

}


void printEmployeeData(struct AllEmployees employees){


	int i=0;

	for(i=0;i<size;i++){


		gotoxy(25,7);
		printf("Employee Name : %s ",employees.e1[i].name);

		gotoxy(25,10);
		printf("Employee Code : %d ",employees.e1[i].code);

		gotoxy(25,13);
		printf("Employee Net Salary : %f",employees.e1[i].salary+employees.e1[i].bonus-employees.e1[i].deduct);


	}

}
