#include <stdio.h>

#include <conio.h>

int fibbonacciRec(int n);

int factorialRec(int n);

int powerRec(int total,int n,int power);

int factorialIter(int n);

int fibbonacciIter(int n);

int powerIter(int n,int power);

int main() {

   int n = 5;
   int power=3;
   int i;

   clrscr();

   printf("Factorial of %d with recursion : %d\n" , n , factorialRec(n));

   printf("Fibbonacci of %d with recursion : " , n);

   for(i = 0;i<n;i++) {

	  printf("%d ",fibbonacciRec(i));

   }

   printf("\n");

   printf("Power of %d with recursion : %d \n",n,powerRec(1,n,power ));

   printf("Factorial of %d with iteration : %d \n" , n , factorialIter(n));

   printf("Fibbonacci of %d with iteration : " , n);

   for(i = 0;i<n;i++) {

	  printf("%d ",fibbonacciIter(i));

   }

   printf("\nPower of %d with iteration : %d \n",n,powerIter(n,power ));


   getch();

   return 0;
}

int powerIter(int n,int power){

   int i=0;

   int totalNumber=1;

   for(i;i<power;i++){

	  totalNumber*=n;

   }

   return totalNumber;


}


int fibbonacciIter(int n){

   int firstNumber=1;

   int secondNumber=1;

   int totalNumber=0;

   int i;

   for( i =2;i<=n;i++){

	  totalNumber = firstNumber+secondNumber;

	  firstNumber = secondNumber;

	  secondNumber = totalNumber;

   }

   return secondNumber;


}


int factorialIter(int n){

	int total=1;

	int i=1;

	for(i=2;i<=n;i++){

	total*=i;

	}

	return total;

}







int fibbonacciRec(int n) {

  if(n == 1 || n==0) {

	  return 1;

   } else {

	  return (fibbonacciRec(n-1) + fibbonacciRec(n-2));

   }
}

int factorialRec(int n) {

   if(n == 0) {

		return 1;

	 } else {

		return n * factorialRec(n-1);

	}

}

int powerRec(int total ,int n,int power){


	if(power==0){

		return total;

	}else{

		total*=n;

		return powerRec(total,n,power-1);

	}


}




