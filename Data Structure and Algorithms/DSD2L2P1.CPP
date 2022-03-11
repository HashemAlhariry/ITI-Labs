#include <iostream.h>
#include <conio.h>
#include <stdio.h>
#include <string.h>


void selectionSortInt(int *arr,int size){

	int i=0;
	int j=0;

	int temp;
	int minimumValue=-1;

	for(i=0;i<size;i++){


	  minimumValue=i;

	  for(j=i+1;j<size;j++){

		 if(arr[minimumValue]>arr[j]){

		   minimumValue = j;

		 }

	  }


	  temp=arr[i];

	  arr[i]=arr[minimumValue];

	  arr[minimumValue]=temp;


	}



}


void selectionSortChar(char arr[][20] , int size){

	int i=0;

	int j=0;

	char temp[100];

	int minimumValue=-1;

	for(i=0;i<size;i++){


	  minimumValue=i;


	  for(j=i+1;j<size;j++){

		 if( strcmp(arr[minimumValue],arr[j]) <0 ){

		   minimumValue = j;

		 }

	  }


	  strcpy(temp,arr[i]);     

	  strcpy(arr[i],arr[minimumValue]);

	  strcpy(arr[minimumValue],temp);


	}



}



void printArr(int *arr,int size){

	int i;
	for(i=0;i<size;i++){

	   cout<<arr[i]<<" ";

	}


}

int main(){

	int i;
	int intArr[] = {14,33,27,10,35,19,42,44};

	selectionSortInt(intArr,8);

	char charArr[4][20] = {"a","b","c","d"};

	selectionSortChar(charArr ,4);



	clrscr();



	printArr(intArr,8);

	cout<<endl;

	for(i=0;i<4;i++){

	   cout<<charArr[i]<<" ";

	}

	getch();


	return 0;

}