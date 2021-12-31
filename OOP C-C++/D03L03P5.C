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



struct Employee readEmployeeData(struct Employee employee);


void printEmployeeData(struct Employee employee);


int main(){



	struct Employee employee;

	struct Employee employees[size];

	int i=0;

	int chooseNumber=0;

	int checkIfAdded=0;


	while(chooseNumber != 3){


		clrscr();

		gotoxy(25 , 12);

		printf("Please Choose Number");

		gotoxy(25 , 14);

		printf("1-Add Employees");

		gotoxy(25 , 16);

		printf("2-Display Employees");

		gotoxy(25 , 18);

		printf("3-Exit");

		gotoxy(25 , 20);

		flushall();

		scanf("%d",&chooseNumber);



		if(chooseNumber == 2){


			clrscr();

			if(checkIfAdded==1){


				for(i=0;i<size;i++){


					gotoxy(1, (i+1)*3);

					printEmployeeData(employees[i]);


				}

			}else{

				gotoxy(20, 10);


				printf("Please Add Employees First");


			}

			getch();


		}



		if(chooseNumber == 1){


			clrscr();

			checkIfAdded=1;

			for(i=0;i<size;i++){


				flushall();

				employees[i] = readEmployeeData(employee);

			}

		}




	}




 return 0;

}


struct Employee readEmployeeData(struct Employee employee){



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


	return employee;

}


void printEmployeeData(struct Employee employee){





		printf("Name : %s   ",employee.name);


		printf("Code : %d   ",employee.code);


		printf("Net Salary : %f \n",employee.salary+employee.bonus-employee.deduct);



}
