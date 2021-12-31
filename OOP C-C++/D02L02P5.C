#include<stdio.h>
#include<conio.h>

#define SIZE 5

int main() {



	int numbers[SIZE];
	int i;

	clrscr();

	printf("Reading Array ....\n");

	for(i=0;i<SIZE;i++){

		printf("Enter the number index : %d ", (i+1));
		scanf("%d",&numbers[i]);

	}

	printf("\nPrinting Numbers ....\n");

	for(i=0;i<SIZE;i++){

		printf("the number index : %d  %d\n",i+1,numbers[i]);

	}


    getch();





	return 0;
}