#include<stdio.h>
#include<conio.h>


void stringCpy(char * sourceString, char * destinationString, int lenghtOfFirstString);

int stringLength(char * str);

int main(){


	int characterLength=0;

	char firstString[100];

	char * secondString;

	int count=0;

	int lengthOfFirstString = 0;

	clrscr();

	printf("Please Enter First String :\n");

	scanf("%[^\n]",firstString);

	lengthOfFirstString = stringLength(firstString);

	printf("Length of First String : %d\n",lengthOfFirstString);

	secondString = (char *) malloc(lengthOfFirstString);

	stringCpy(firstString, secondString,lengthOfFirstString);

	printf("Second String : \n");

	count=0;

	while(lengthOfFirstString>count){

		printf("%c",secondString[count]);

		count++;

	}



	getch();

	return 0;

};


void stringCpy(char * sourceString, char * destinationString,int lenghtOfFirstString){

	 int i = 0;

	 for(i=0;i < lenghtOfFirstString; i++){

		destinationString[i] = sourceString[i];

	 }


};


int stringLength(char * str){

	int count=0;

	while(str[count]!='\0')
		count++;

	return count;

};


