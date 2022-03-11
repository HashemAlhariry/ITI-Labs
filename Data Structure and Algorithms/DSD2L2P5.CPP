#include <iostream.h>
#include <conio.h>

struct Complex{

	private:
		float real;
		float imag;


	public:

		Complex();
		Complex(float r);
		Complex(float r, float i);

		~Complex();

		void setReal(float r);
		void setImag(float i);

		float getReal();
		float getImag();

		Complex add(Complex c);
		Complex sub(Complex c);

		void print();


		/*
		Complex & operator= (Complex &c){

			real = c.real;

			imag = c.imag;

		//  cout<<"\n THIS IS FROM Assign oprator";

			return *this;


		}
		*/

};


void seqSearch(Complex arr[],int intNumber){

	int i=0;

	for(;i<4;i++){


			  if(arr[i].getReal() == intNumber){

				clrscr();

				gotoxy(25 , 12);

				cout<<"FOUND ONE";

				gotoxy(25 , 14);

				cout<<"Number : " <<arr[i].getReal()<<" Index : "<< i;

			  }
			}


}


int binarySearch(struct Complex arr[4], int startIndex, int endIndex, int element){


   while (startIndex <= endIndex){

	  int middle = startIndex + (endIndex- startIndex )/2;

	  if (arr[middle].getReal() == element)

			return middle;

	  if (arr[middle].getReal() < element)

		 startIndex = middle + 1;

	  else
		 endIndex = middle - 1;

   }
   return -1;
}


void swap(int i,int j, struct Complex * complex){


	struct Complex ptr = *complex;

	complex[i] = complex[j];

	complex[j] = ptr;


}



void sort(struct Complex * complex,int size){


  int i=0,j=0;

  for(i=0;i<size-1;i++){

	for(j=i+1;j<size;j++){

		if(	complex[i].getReal() > complex[j].getReal() ){

			swap(i,j,complex);

			cout<<complex[i].getReal()<<" "<< i <<" " <<complex[j].getReal()<<" "<< j <<endl;

		}

	}

  }



}



int main(){


	clrscr();

	int number=4;

	int indexOfBinary;

	struct Complex compArr[4] = {

		Complex(4,4),
		Complex(5,5),
		Complex(6,6),
		Complex(1,1)

		};


	sort(compArr,4);

	for(int i=0;i<4;i++){

//	   cout<<compArr[i].getReal()<<" ";

	}


   /*
   seqSearch(compArr,number);

   cout<<endl;
   indexOfBinary = binarySearch(compArr,0,3,4);

   gotoxy(25 , 16);
   cout<<"Binary search on complex found at index : "<<indexOfBinary;
   */


   getch();


   return 0;

}



Complex :: Complex(){

	real = imag = 0;

   //	cout<<"\n Default Constructor is calling ";

}


Complex :: Complex(float r ,float i){

	real = r;

	imag = i;

  //	cout <<"\n Constructor with two parameters is calling ";


}

Complex :: Complex(float r){

	 real = imag = r;

  //	 cout<<"\n Constructor with one parameters is calling ";


}

Complex :: ~Complex(){

//	cout<<"\n Destructor is calling ";

}


void Complex :: setReal (float r){

	real = r;
}


void Complex :: setImag (float i){

	imag = i;

}

float Complex :: getReal(){

	return real;

}

float Complex :: getImag(){

	 return imag;

}

Complex Complex :: add (Complex c){


	 Complex temp;

	 temp.real = real + c.real;

	 temp.imag = imag + c.imag;

	 return c;
}


Complex Complex :: sub(Complex c){

	 Complex temp;

	 temp.real = real - c.real;

	 temp.imag = imag - c.imag;

	 return temp;

}


void Complex::print(){

	 if(imag<0){

		cout<<real<<" - " << imag<<"i"<<endl;

	 }
	 else
	 {

		cout<<real<<" + " <<imag<<"i"<<endl;

	 }
}
