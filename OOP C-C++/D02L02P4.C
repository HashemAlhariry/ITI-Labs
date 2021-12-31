#include <stdio.h>
#include <conio.h>

int main(void) {

		int i=0;
		int j=0;
		int firstNumber  =1;
		int secondNumber =1;
		int counterForColumn=10;
		int counterForRow=10;
		int numbersForRows=10;
		int numbersForColumns=10;
		int product=0;
		clrscr();


		for(i=2;i<=11;i++){

			gotoxy(i * 4,1);
			printf("%d",counterForColumn);
			counterForColumn--;

		}



		for(i=2;i<=11;i++){

			gotoxy(1,i * 2);
			printf("%d",counterForRow);
			counterForRow--;


		}


		for(i=2;i<=11;i++){
			gotoxy(i * 4,2);
			printf("*");

		}
		for(i=2;i<=11;i++){
			gotoxy(4,i * 2);
			printf("*");
		}




		for(i=2 ; i<=11 ;i++)
		{

			for(j=2 ; j<=11 ;j++){

				product=numbersForRows*numbersForColumns;
				gotoxy(i*4,j*2);
				numbersForColumns--;
				printf("%d",product);

			}
			numbersForRows--;
            numbersForColumns=10;

		}

		getch();
		return 0;
}