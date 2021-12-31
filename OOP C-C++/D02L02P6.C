#include <stdio.h>
#include <conio.h>


#define SIZE 10
int main (){



	int num[SIZE]={-1000,20,51,2,250,1521,122,412,754,32};

	int i=0;
	

	int maximumNumber=num[0];
	int minimumNumber=num[0];

	clrscr();

	for(i=1;i<SIZE;i++){

		if(num[i]>maximumNumber)
			maximumNumber=num[i];


		if(num[i]<minimumNumber)
			minimumNumber=num[i];



	}

	printf("Maximum number in the Array : %d\n",maximumNumber);
	printf("Minimum number in the Array : %d\n",minimumNumber);
	getch();


	return 0;


}


