#include<stdio.h>
#include<conio.h>

void swap(int *a,int *b){

   int temp= *a;

   *a = *b;

   *b = temp;

}


int main() {


	int firstNumber = 1000;

	int secondNumber = 2000;

	clrscr();

	printf("First Number = %d\n",firstNumber);

	printf("Second Number = %d\n",secondNumber);

	swap(&firstNumber , &secondNumber);

	printf("First Number Updated = %d\n",firstNumber);

	printf("Second Number Updated = %d\n",secondNumber);

	getch();

	return 0;

}