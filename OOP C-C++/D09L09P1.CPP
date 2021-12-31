#include <iostream.h>
#include <stdio.h>
#include <conio.h>

class Base{


	protected:

		int a;

		int b;

	public:

		Base(){ a=b=0; };

		Base(int n){

			a=b=n;

		}

		Base(int x,int y){

			a=x; b=y;

		}

		void setA(int x){

			a=x;
		}
		void setB(int y){

			b=y;
		}

		int getA(){

			return a;
		}

		int getB(){

			return b;

		}

		int calculateSum(){

			return a+b;
		}
};

class Derived : public Base{

	 private:

		int c;

	 public:

		Derived(): Base(){

			c=0;

		}

		Derived(int n): Base(n){

			c=n;

		}

		Derived(int x,int y ,int z) : Base(x,y){

			c=z;

		}

		void setC(int z){

			c=z;
		}

		int getC(){

			return c;
		}

		int calculateSum(){

			return Base::calculateSum()+c;

		}
};

int main(){

   clrscr();

   Base b(9,10);

   cout<<b.calculateSum()<<endl;

   Derived obj1(5);

   cout<<obj1.calculateSum()<<endl;

   getch();

   return 0;

}