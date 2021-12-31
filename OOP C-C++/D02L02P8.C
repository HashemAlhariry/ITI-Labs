#include<stdio.h>
#include<conio.h>

#define NUM 15

int main()
{


	int magicBox[NUM][NUM];
	int indexOfFirstNumber=NUM/2;


	int row=0;
	int column = indexOfFirstNumber;
	int maximumEdge=NUM-1;
	int minimumEdge=0;
	int i=0;
	int j=0;
	magicBox[0][indexOfFirstNumber]=1;

	clrscr();

	/*
	printf("Please Enter Odd Number: ");
	scanf("%d", &num);

	while(num % 2==0 || num<=2){
	  printf("Please Enter Odd Number: ");
	  scanf("%d", &num);
	}

	*/
	for(i=1;i<NUM*NUM;i++) {


		if(((i)%NUM) != 0){

			if(row == minimumEdge){

				row = maximumEdge;

			}else {

				row -= 1;
			}

			if(column == minimumEdge){

				column = maximumEdge;

			}else{

				column -= 1;

			}

			//	printf("%d .....",i+1);

			//	printf("Row : %d ",row);

			//	printf("Column : %d \n",column);

			 magicBox[row][column]=i+1;
		}

		else{

			if(row == maximumEdge){

				row = minimumEdge;

			}else{

			 row += 1;

			}


		   //	printf("%d .....",i+1);

		   //	printf("Row : %d ",row);

		   //	printf("Column : %d \n",column);

			magicBox[row][column] = i+1 ;

		}
	}



	i = 0;
	j = 0;



	for (i = 0; i < NUM; i++) {




		for (j = 0; j <NUM; j++) {


	
		gotoxy((j+2)*4,(i+1));
		printf("%d",magicBox[i][j]);


		}

		printf("\n");
	}


	getch();

	return 0;
}