#include <stdio.h>
#include <conio.h>

int main(void) {


		int i=0;
		int j=0;

		int firstNumber  =1;
		int secondNumber =1;

		clrscr();

		for(i=2;i<=11;i++){

			gotoxy(i * 3,2);

			printf("%d",i-1);

		}

		for(i=2;i<=11;i++){

			gotoxy(1,i * 2);

			printf("%d",i-1);
		}

f
		for(i=2;i<=11;i++){

			gotoxy(i * 3,3);

			printf("*");

		}

		for(i=2;i<=11;i++){

			gotoxy(4,i * 2);

			printf("*");
		}

		for(i=2 ; i<=11 ;i++){

			for(j=2 ;j<=11 ;j++){

				int product=(i-1) * (j-1);

				gotoxy(i*3,j*2);

				printf("%d",product);

			}

		}

		getch();
		return 0;
}