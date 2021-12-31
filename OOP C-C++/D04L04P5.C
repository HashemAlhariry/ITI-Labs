#include <stdio.h>
#include <conio.h>

static void forcefloat(float *p){

	float f = *p;

	forcefloat(&f);

}


struct Employee {

	char name[50];

	int code;

	float salary;

	float deduct;

	float bonus;

};


void addEmployee(struct Employee * employee,int numberAdded);


void printEmployeeData(struct Employee * employee,int i);


int stringCompare(struct Employee * employee1,struct Employee * employee2);


void swap(int i,int j, struct Employee ** employees);


void sort(struct Employee ** employees,int employeesLen);


int main(){


	struct Employee ** employees;

	int numberOfEmployees;

	int menuNumber=0;

	int numberOfEmployeeAdded = 0;

	int employeeID=0;

	int i=0;

	clrscr();

	gotoxy(24 , 12);

	printf("WELCOME ENTER EMPLOYEES NUMBER : ");

	scanf("%d",&numberOfEmployees);

	employees = (struct Employee **) malloc (numberOfEmployees * sizeof(struct Employee * ));

	for(i=0;i<numberOfEmployees;i++)
		employees[i] = (struct Employee*) malloc(sizeof(struct Employee));



	while(menuNumber != 5){

		clrscr();

		gotoxy(25 , 10);

		printf("1-Add new employee");

		gotoxy(25 , 12);

		printf("2-Display new employee");

		gotoxy(25 , 14);

		printf("3-Sort employees");

		gotoxy(25 , 16);

		printf("4-Search employee");

		gotoxy(25 , 18);

		printf("5-Exit ");

		gotoxy(25 , 20);

		scanf("%d",&menuNumber);

		if(menuNumber==1){

			if(numberOfEmployees > numberOfEmployeeAdded){


				addEmployee(employees[numberOfEmployeeAdded],numberOfEmployeeAdded);

				numberOfEmployeeAdded++;


			}else{


				clrscr();

				gotoxy(25 , 12);

				printf("YOU CAN`T ADD MORE ! ");

				getch();


			}

		}

		if(menuNumber==2){


			if(numberOfEmployeeAdded == 0 ){


				clrscr();

				gotoxy(25 , 12);

				printf("PLEASE ADD EMPLOYEE FIRST");

				getch();


			}else{

				clrscr();

				for(i=0;i<numberOfEmployeeAdded;i++){


					printEmployeeData(employees[i],i);

					printf("\n");


				}

				getch();



			}


		}

		if(menuNumber==3){

		if(numberOfEmployeeAdded>=2){


				sort(employees , numberOfEmployeeAdded);

				clrscr();

				gotoxy(25 , 12);

				printf("SORTED :)");

				getch();



			}






		}

		if(menuNumber==4){



			clrscr();

			printf("PLEASE ENTER NUMBER TO SEARCH : ");

			scanf("%d",&employeeID);

			for(i=0;i<numberOfEmployeeAdded;i++){

			  if((*employees[i]).code == employeeID){

				clrscr();

				gotoxy(25 , 12);

				printf("FOUND ONE");

				gotoxy(25 , 14);

				printf("Name : %s   ",(*employees[i]).name);

				gotoxy(25 , 16);

				printf("Code : %d   ",(*employees[i]).code);

				gotoxy(25 , 18);

				printf("Net Salary : %f \n",(*employees[i]).salary+(*employees[i]).bonus-(*employees[i]).deduct);

				getch();

			  }else{

				clrscr();

				gotoxy(25 , 12);

				printf("FOUND NO ONE :(");

				getch();




			  }
			}


		}




	}


	for(i=0;i<numberOfEmployees;i++)
		free(employees[i]);


	free(employees);


	return 0;

}


void sort(struct Employee ** employees,int employeesLen){


 int i=0,j=0;


  for(i=0;i<employeesLen-1;i++){

	for(j=i+1;j<employeesLen;j++){



		if(strcmp((*employees[i]).name,(*employees[j]).name)>0){


			swap(i,j,employees);

		}

	}

  }

}


void swap(int i,int j, struct Employee ** employees){


	struct Employee * ptr = employees[i];
	employees[i] = employees[j];
	employees[j] = ptr;


}

int stringCompare(struct Employee * employee1,struct Employee * employee2){

	return strcmp(employee1->name,employee2->name);

}



void addEmployee(struct Employee * employee,int numberAdded){



		flushall();

		clrscr();

		gotoxy(25,7);

		printf("Please Enter Name : ");

		gets((*employee).name);


		gotoxy(25,10);

		printf("Please Enter the code : ");

		scanf("%d",&(*employee).code);

		gotoxy(25,13);

		printf("Please Enter salary : ");

		flushall();

		scanf("%f",&(*employee).salary);

		gotoxy(25,16);

		printf("Please Enter any bonuses : ");

		scanf("%f",&employee->bonus);

		gotoxy(25,19);

		printf("Please Enter a deduction : ");

		scanf("%f",&employee->deduct);

		clrscr();



}


void printEmployeeData(struct Employee * employee, int i){


		printf("Name : %s   ",(*employee).name);


		printf("Code : %d   ",(*employee).code);


		printf("Net Salary : %f \n",(*employee).salary+(*employee).bonus-(*employee).deduct);

}