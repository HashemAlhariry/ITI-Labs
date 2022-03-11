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


		Complex(Complex &c){

			real = c.real;

			imag = c.imag;


	 //		cout<<"\n This is from the copy constructor"<<endl;
		};


		Complex & operator= (Complex &c){

			real = c.real;

			imag = c.imag;

	//		cout<<"\n THIS IS FROM Assign oprator";

			return *this;


		}


};


void seqSearch(Complex arr[],int intNumber){

	int i=0;

	for(;i<4;i++){


			  if(arr[i].getReal() == intNumber){

				clrscr();

				gotoxy(25 , 12);


				cout<<"FOUND ONE";

				gotoxy(25 , 14);

				cout<<"Number : " <<arr[i].getReal();

				getch();

			  }
			}


}
int main(){

	clrscr();


	int number=4;

	struct Complex compArr[4] = {

		Complex(1,1),
		Complex(2,2),
		Complex(3,3),
		Complex(4,4)

		};



	seqSearch(compArr,number);

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
