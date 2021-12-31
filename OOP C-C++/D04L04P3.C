#include<stdio.h>
#include<conio.h>

#define fixed_size 4

void printArray(int *ptr,int size);

void scanArray(int *ptr,int size);

int main(){



	int fixedArr[fixed_size];

	int sizeNumber;

	int *dynamicArr;

	clrscr();

	scanArray(fixedArr,fixed_size);

	printArray(fixedArr,fixed_size);


	printf("Please Enter array size : ");

	scanf("%d",&sizeNumber);

	dynamicArr = (int*) malloc(sizeNumber*sizeof(int));

	printf("Dynamic array address %d \n",dynamicArr);

	if(sizeNumber >= 1){

		scanArray(dynamicArr,sizeNumber);

		printArray(dynamicArr,sizeNumber);


	}else{

		printf("Please enter correct number for the array.");


	}




	getch();


return 0;

}


void scanArray(int *ptr, int size){

	 int i;

	 printf("enter %d values of array: \n",size);

	 for(i=0;i<size;i++){

		 scanf("%d",&ptr[i]);

	 }
	 


}

void printArray(int *ptr,int size){

 int i;

 printf("The values Of the array: \n");

 for(i=0;i<size;i++){

  printf("%d ",ptr[i]);

 }
 printf("\n");

}