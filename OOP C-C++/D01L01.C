#include <stdio.h>


int main(){




	float floatNumber=100.5;
	int number=5;
	char charac = 'A';
	double doubleNumber=200.10;
	char character;
	int numberToPeresentOctalAndHexal = 14;



	printf("1- character with character specifier %c \n",charac);
	printf("2- character with decimal specifier %d \n",charac);
	printf("3- character with floating specifier %f \n",charac);
	printf("4- character with octal specifier %o \n",charac);
	printf("5- character with address specifier %p \n",charac);
	printf("------------------------------\n\n");

	printf("1- number with character specifier %c \n",number);
	printf("2- number with decimal specifier %d \n",number);
	printf("3- number with floating specifier %f \n",number);
	printf("4- number with octal specifier %o \n",number);
	printf("5- number with address specifier %p \n",number);
	printf("------------------------------\n\n");


	printf("1- floatNumber with character specifier %c \n",floatNumber);
	printf("2- floatNumber with decimal specifier %d \n",floatNumber);
	printf("3- floatNumber with floating specifier %f \n",floatNumber);
	printf("4- floatNumber with octal specifier %o \n",floatNumber);
	printf("5- floatNumber with address specifier %p \n",floatNumber);
	printf("------------------------------\n\n");


	printf("1- doubleNumber with character specifier %c \n",doubleNumber);
	printf("2- doubleNumber with decimal specifier %d \n",doubleNumber);
	printf("3- doubleNumber with floating specifier %f \n",doubleNumber);
	printf("4- doubleNumber with octal specifier %o \n",doubleNumber);
	printf("5- doubleNumber with address specifier %p \n",doubleNumber);
	printf("------------------------------\n\n");


	printf("Enter an character: ");
	scanf("%c", &character);
	printf("Number = %d\n",character);


	printf("Decimal value is: %d \n",numberToPeresentOctalAndHexal);
	printf("Octal value is: %o \n",numberToPeresentOctalAndHexal);
	printf("Hexadecimal value is (Alphabet in small letters): %x \n",numberToPeresentOctalAndHexal);


	getch();

	return 0;
}