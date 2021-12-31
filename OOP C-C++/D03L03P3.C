#include <stdio.h>
#include <conio.h>


struct Employee {


	char name[50];

	int code;

	float salary;

	float deduct;

	float bonus;


};

struct Employee readEmployeeData(struct Employee e1);

void printEmployeeData(struct Employee e1);

int main(){

	struct Employee e1;

	clrscr();


	e1 = readEmployeeData(e1);


	clrscr();


	printEmployeeData(e1);


	getch();


 return 0;

}


struct Employee readEmployeeData(struct Employee e1){


	gotoxy(25,7);


	printf("Please Enter Name : ");

	gets(e1.name);


	gotoxy(25,10);


	printf("Please Enter the code : ");

	scanf("%d",&e1.code);


	gotoxy(25,13);


	printf("Please Enter salary : ");
	scanf("%f",&e1.salary);

	gotoxy(25,16);


	printf("Please Enter any bonuses : ");
	scanf("%f",&e1.bonus);


	gotoxy(25,19);


	printf("Please Enter a deduction : ");
	scanf("%f",&e1.deduct);

	clrscr();

	return e1;

}


void printEmployeeData(struct Employee e1){



	gotoxy(25,7);
	printf("Employee Name : %s ",e1.name);

	gotoxy(25,10);
	printf("Employee Code : %d ",e1.code);

	gotoxy(25,13);
	printf("Employee Net Salary : %f",e1.salary+e1.bonus-e1.deduct);



}
