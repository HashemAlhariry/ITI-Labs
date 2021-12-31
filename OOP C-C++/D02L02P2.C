#include <stdio.h>
#include <conio.h>

int main(){



	int num = 0;

	clrscr();

	gotoxy(30,10);

	printf("(1) NEW\n");

	gotoxy(30, 12);

	printf("(2) Display\n");

	gotoxy(30,14);

	printf("(3) Exit\n");

	gotoxy(30,16);

	scanf("%d", &num);

	clrscr();

	if(num == 1){

	 gotoxy(30,12);

	 printf("New");

	}

	if(num==2){

	 gotoxy(30,12);

	 printf("Display");

	}


	if(num==3){

	 gotoxy(30,12);

	 printf("Exit");


	}


	/*

	gotoxy(30,10);

	printf("(1) NEW\n");

	gotoxy(30, 12);

	printf("(2) Display\n");

	gotoxy(30,14);

	printf("(3) Exit\n");

	gotoxy(30,16);

	scanf("%d", &num);

	*/


	getch();

	return 0;
}