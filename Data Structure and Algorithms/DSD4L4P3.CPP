#include <iostream.h>
#include <conio.h>
#include <stdlib.h>

class Stack
{

	private:

		static int counter;

	public:

		int top;

		int size;

		int *ptr;

		int isFull();

		int isEmpty();

		static int getCounter(){

			return counter;

		}

		Stack& operator= (Stack &s){



		   int i=0;

		   top = s.top;

		   size = s.size;

		   ptr = new int [size];

		   for(i=0;i<size;i++)
		   {
			  ptr[i] = s.ptr[i];

		   }
		  //cout<<"This is from the assign constructor"<<endl;


		}

		Stack()

		{
			top = 0;

			size = 10;

			ptr = new int[size];

			counter ++;


		}

		Stack (int n)

		{

			top = 0;

			size = n;

			ptr = new int [size];

			counter ++;

		}

		~Stack()
		{
			delete[] ptr;

			size=0;

			counter --;


		}

		int push(int n);

		int pop(int & n);

		friend void viewContent(Stack s);


};




int Stack::isFull()
{

	return(top==size);

}



int Stack::isEmpty()

{


	return (top==0);

}



int Stack::push(int n)

{

	if(isFull())


		return 0;


	ptr[top]=n;

	top++;

	return 1;


}

int Stack::pop(int & n)

{

	if(isEmpty())

		return 0;

	top--;

	n = ptr[top];

	return 1;


}

int Stack::counter = 0;


void viewContent (Stack s) {


	for(int i=0; i<s.top; i++)

		cout << "\n Element no (" << i+1 << ") = " << s.ptr[i];
}




int main(){


	clrscr();

	int num;


	Stack s1;

	s1.push(12);

	s1.push(2);

	s1.push(16);

	s1.push(3);

	s1.push(4);

	s1.push(11);

	viewContent(s1);

	cout<<endl;

	cout<<"Last element poped up: ";

	s1.pop(num);

	cout<<num<<endl;

	cout<<"Last element poped up: ";

	s1.pop(num);

	cout<<num<<endl;

	viewContent(s1);

	getch();

	return 0;

};

