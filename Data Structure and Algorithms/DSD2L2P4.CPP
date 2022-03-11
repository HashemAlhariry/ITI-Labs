#include <iostream.h>
#include <conio.h>
#include <stdio.h>
#include <string.h>





void merge (int *a,int *l ,int 	leftCount,int *r,int rightCount){

	int i,j,k;


	i=0; j=0; k=0;


	while(i<leftCount && j<rightCount){

		if(l[i] < r[j]) a[k++] = l[i++];

		else a[k++] = r[j++];


	}

	while (i<leftCount) a[k++] = l[i++];

	while (j<rightCount) a[k++] = r[j++];



}

void mergeSort (int *a ,int n){

	int mid ,i ,*l ,*r;

	if(n<2) return;

	mid = n/2;

	l = new int [mid];

	r = new int [n-mid];


	for(i=0;i<mid ;i++) l[i] = a[i];

	for(i=mid;i<n ;i++) r[i-mid] = a[i];

	mergeSort(l,mid);

	mergeSort(r,n-mid);

	merge(a,l,mid,r,n-mid);







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

	mergeSort(arr,9);

	print(arr,9);


	getch();


	return 0;

}