#include <iostream.h>
#include <conio.h>
#include <stdio.h>
#include <string.h>





void bubbleSort(int *arr ,int size){


	int i,j,temp;
	for(i =0 ;i<size;i++){

	  for(j=0;j<size-i-1;j++){

		if(arr[j]>arr[j+1]){

		  temp = arr[j];

		  arr[j]=arr[j+1];

		  arr[j+1]=temp;

		}

	  }


	}



}

void print (int *arr,int size){

	int i=0;

	for(;i<size;i++){

		cout<<arr[i]<<" ";

	}



}

int main(){


	int arr[]={1,12,8,17,28,15,18,11,55,6};

	clrscr();

	bubbleSort(arr,9);

	print(arr,9);


	getch();


	return 0;

}