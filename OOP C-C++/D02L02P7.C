#include <stdio.h>
#include <conio.h>

#define row 3
#define column 4

int main(){



	int sumOfRows [row];

	int averageOfColumns [column]={0};

	int dimensionArray[row][column];

	int i=0;

	int j=0;

	int tempofColumns=0;

	int tempOfRows=0;

	clrscr();

	for(i=0;i<row;i++){


		for(j=0;j<column;j++){

        
			scanf("%d",&dimensionArray[i][j]);

			tempOfRows+=dimensionArray[i][j];

			averageOfColumns[j]+=dimensionArray[i][j];


		}

		sumOfRows[i]=tempOfRows;

		tempOfRows=0;

	}

	/*

	for(i=0;i<row;i++){


		for(j=0;j<column;j++){


			printf("%d  ",dimensionArray[i][j]);


		}

		printf("\n");
	}
	*/



	for(j=0;j<column;j++){


		averageOfColumns[j]=averageOfColumns[j]/3;


	}

	printf("Average of columns\n");

	for(j=0;j<column;j++){

		if(j==0)
			  gotoxy(1,5);
		else
			gotoxy((j+1)*2,5);

		printf("%d  ",averageOfColumns[j]);


	}

	printf("\n");



	for(j=0;j<row;j++){

		gotoxy(13,(j+1));
		printf("Sum of rows:r %d  ",sumOfRows[j]);


	}



	getch();


	return 0;



}