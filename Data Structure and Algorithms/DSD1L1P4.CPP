#include <iostream.h>
#include <conio.h>
#include <stdio.h>
#include <string.h>


void binarySearch(char arr[][20],int size,char key[20]){


	 int i,low,high,mid,check=1;

	 low=0;

	 high=size-1;

	 mid = (low+high)/2;

	 while(high>=low)
	 {

		 mid=(low+high)/2;

		 if(strcmp(key,arr[mid])<0)
		 {
			high=mid-1;
		 }

		 else if(strcmp(key,arr[mid])>0)
		 {
			low=mid+1;
		 }
		 else
		 {

			cout<<"key found at the position %d\n"<<mid+1;

			check=0;

			low+=high;

		}

	}

	if(check){

		cout<<"name not found\n";

	}

}



int main()
{

	 int i,n;

	 char key[20],arr[][20]={"a","b","c","d","e","f"};

	 clrscr();

	 printf("\n");

	 printf("enter the name to be searched\n");

	 scanf("%s",&key);

	 binarySearch(arr,6,key);

	 getch();


	return 0;


  }





