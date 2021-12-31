#include<stdio.h>
#include<conio.h>

int main(){


	int i,j ,lenOfBigArr,sizeOfStrings;

	int * arrOfStringsSizes;

	char ** arrOfStrings;

	clrscr();

	printf("PLEASE ENTER THE BIG ARRAY SIZE : ");

	scanf("%d",&lenOfBigArr);

	arrOfStringsSizes = (int *) malloc (lenOfBigArr*sizeof(int));

	arrOfStrings =(char **) malloc (lenOfBigArr * sizeof(char*));

	printf("PLEASE ENTER STRINGS SIZES : \n");

	for(i=0;i<lenOfBigArr;i++)
		 scanf("%d",&arrOfStringsSizes[i]);


	printf("----------------\n");


	for(i=0;i<lenOfBigArr;i++)
		arrOfStrings[i]= (char *) malloc(arrOfStringsSizes[i]);




	for(i=0;i<lenOfBigArr;i++){

		printf("PLEASE ENTER ONLY %d CHAR : \n",arrOfStringsSizes[i]);

		flushall();

		for(j=0;j<arrOfStringsSizes[i];j++)
			scanf("%c",&arrOfStrings[i][j]);


	}

	printf("\n\n");

	printf("PRINTING ...\n\n");

	for(i=0;i<lenOfBigArr;i++){

		if(arrOfStringsSizes[i]>0){


			for(j=0;j<arrOfStringsSizes[i]; j++)
				printf("%c",arrOfStrings[i][j]);



		}

		if(i!=lenOfBigArr)

		 printf("\n-------------------\n");

	}


	getch();



}