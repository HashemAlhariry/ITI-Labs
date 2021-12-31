
#include <stdio.h>
#include <conio.h>

int main(){


	int totalNumber=0;
	int num;

	clrscr();

	while (totalNumber <= 100){

	  printf("Please Enter Number: ");
	  scanf("%d", &num);
	  totalNumber+=num;

	}

    printf("your total number is: %d\n",totalNumber);
	printf("All Done");
	getch();



	return 0;
}