#include <iostream.h>
#include <conio.h>


class Complex{

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

		friend Complex operator +(float f, Complex& C);

		friend istream& operator>>(istream& in ,Complex &c);

		friend ostream& operator<<(ostream& out ,Complex &c);

		Complex operator - (Complex & c){

			Complex temp(real - c.real, imag - c.imag);

			return temp;

		}

		Complex operator + (Complex & c){

			Complex temp(real+c.real,imag+c.imag);

			return temp;

		};

		Complex operator + (float f){

			Complex temp(real+f,imag);

			return temp;

		}

		Complex operator * (Complex & c){

			Complex temp(real * c.real, imag+c.imag);

			return temp;

		}

		Complex operator / (Complex & c){

			Complex temp(real/c.real, imag/c.imag);

			return temp;

		}


		Complex operator ++(){

			real++;

			imag++;

			return *this;
		}
		Complex operator ++(int dummy){

			Complex temp(*this);

			real++;

			imag++;

			return temp;
		}

		Complex & operator= (Complex &c){

			real = c.real;

			imag = c.imag;

			return *this;
		}

		Complex & operator+= (Complex &c){

			real += c.real;

			imag += c.imag;

			return *this;
		}
		Complex & operator -= (Complex &c){

			real -= c.real;

			imag -= c.imag;

			return *this;
		}
		Complex & operator *= (Complex &c){

			real *= c.real;

			imag *= c.imag;

			return *this;
		}
		Complex & operator /= (Complex &c){

			real /= c.real;

			imag += c.imag;

			return *this;
		}


		int operator == (Complex &c){

		  if((real == c.real) && (imag == c.imag))
				return 1;

			return 0;
		}





};



int main(){


	clrscr();


	Complex c1(12,7),c2(10,-5),c3;

	cout<<c1<<endl;

	cout<<c2<<endl;

	cin>>c3;

	cout<<c3;


	c3 = ++c1;

	cout<<c3;


	c3 = c2++;

	cout<<c3;

	c3 += c1;

	cout<<c3;

	getch();

	return 0;


}


istream& operator >> (istream& in ,Complex &c){


		cout<<"\nEnter real part: ";

		in>>c.real;

		cout<<"\nEnter imag part: ";

		in>>c.imag;

		return in;


}


ostream& operator << (ostream& out ,Complex &c){


	if(c.getImag()<0)

		out<<c.getReal()<<" - "<<c.getImag()<<"i"<<endl;

	else
		out<<c.getReal()<<" + "<<c.getImag()<<"i"<<endl;


	return out;


}



Complex operator +(float f,Complex &c) {

	Complex temp(f+c.real,c.imag);

	return temp;

}

Complex :: Complex(){

	real = imag = 0;

	cout<<"\nDefault Constructor is calling ";

}


Complex :: Complex(float r ,float i){

	real = r;

	imag = i;

	cout <<"\nConstructor with two parameters is calling ";


}

Complex :: Complex(float r){

	 real = imag = r;

	 cout<<"\nConstructor with one parameters is calling ";


}

Complex :: ~Complex(){

	cout<<"\nDestructor is calling \n";

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