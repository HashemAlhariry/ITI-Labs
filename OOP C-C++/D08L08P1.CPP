#include <iostream.h>
#include <stdio.h>
#include <conio.h>
class Point
{
private:

	int x ;

	int y ;

public:

	Point()
	{
		x = y = 0 ;
		cout<<"Point default constructor is callingâ"<<endl;

	}

	Point(int m)
	{

		x = y = m ;

		cout<<"Point 1 parameter constructor is callingâ"<<endl;

	}

	Point(int m, int n)
	{
		x = m ;

		y = n ;

		cout<<"Point 2 parameter constructor is calling"<<endl;
	}

	~Point()
	{

		cout<<"Point destructor is calling"<<endl;

	}

	void setX(int m)

	{

		x = m ;

	}

	void setY(int n)

	{

		y = n ;

	}

	void setXY(int m, int n)
	{

		x=m;

		y=n;

	}

	int getX()
	{

		return x ;

	}

	int getY()
	{


		return y ;

	}

	void print()
	{

		cout<<"Point Data: x="<<x<<" y="<<y<<endl;}
	};



class Line
{

	private:

		Point start;

		Point end;

	public:

		Line()

		{
			start.setXY(0,0);

			end.setXY(0,0);

			cout<<"Line default constructor is calling"<<endl;

		}

		Line(int x1, int y1, int x2, int y2)
		{

			start.setXY(x1,y1); end.setXY(x2,y2);

			cout<<"Line with 4 parameter constructor is calling"<<endl;

		}

		~Line()
		{

			cout<<"Line destructor is calling"<<endl;

		}

		void print()
		{

			cout<<"\nStart:";

			start.print();

			cout<<"\nEnd:";

			end.print();
		}
};

class Circle
{

	private:

		Point center;

		int rad;

	public:

		Circle() : center() , rad(0)

		{

			cout<<"Circle default constructor is calling"<<endl;

		}


		Circle(int x1, int y1, int r) : center(x1, y1), rad(r)

		{

			cout<<"Circle constructor with 3 parameters is calling"<<endl;


		}

		~Circle(){cout<<"Circle destructor is calling"<<endl;}

		void print()

		{

			cout<<"\ncenter:";

			center.print();

			cout<<"\nRadius = "<<rad<<endl;

		}

};

class Rect
{

	private:

		Point UL;

		Point LR;

	public:

		Rect() : UL() , LR()

		{

			cout<<"Rect default constructor is calling"<<endl;

		}

		Rect(int x1, int y1, int x2, int y2) : UL(x1, y1), LR(x2, y2)

		{

			cout<<"Rect constructor with 4 parameter is calling"<<endl;

		}

		~Rect()

		{


			cout<<"Rect destructor is calling"<<endl;


		}

		void print()

		{

			cout<<"\nUpper Left:";

			UL.print();

			cout<<"\nLower Right:";

			LR.print();

		}
};

int main()
{
	clrscr();

	Circle c1(250,150,100) ;

	Rect r1(10,100,90,350) ;

	Line l1(30,100, 350, 400) ;

	c1.print() ;

	r1.print() ;

	l1.print() ;


	getch();
	return 0 ;
}