#include <stdio.h>
#include <conio.h>

struct Employee {

	char name[50];

	int code;

	float salary;

	float deduct;

	float bonus;

} employee;



int main(){

	struct Employee employee;



	clrscr();


	gotoxy(25,7);


	printf("Please Enter Name : ");

	gets(employee.name);


	gotoxy(25,10);


	printf("Please Enter the code : ");

	scanf("%d",&employee.code);


	gotoxy(25,13);


	printf("Please Enter salary : ");
	scanf("%f",&employee.salary);

	gotoxy(25,16);


	printf("Please Enter any bonuses : ");
	scanf("%f",&employee.bonus);


	gotoxy(25,19);


	printf("Please Enter a deduction : ");
	scanf("%f",&employee.deduct);



	clrscr();

	gotoxy(25,7);
	printf("Employee Name : %s ",employee.name);

	gotoxy(25,10);
	printf("Employee Code : %d ",employee.code);

	gotoxy(25,13);
	printf("Employee Net Salary : %f",employee.salary+employee.bonus-employee.deduct);

	getch();


 return 0;

}