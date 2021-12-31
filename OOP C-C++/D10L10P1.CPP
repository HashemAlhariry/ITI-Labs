#include <iostream.h>
#include <conio.h>
#include <stdlib.h>


template <class T>
class Stack
{

	private:

		int top;

		int size;

		T *ptr;

		static int counter;


	public:


		int isFull(){

			return(top==size);

		};

		int isEmpty(){

			return (top==0);

		};

		static int getCounter(){

			return counter;

		}

		Stack& operator= (Stack & s);

		Stack(Stack &s);

		Stack()

		{

			top = 0;

			size = 10;

			ptr = new T[size];

			counter ++;

			

		}

		Stack (int n)

		{

			top = 0;

			size = n;

			ptr = new T[size];

			counter ++;


		}

		~Stack()
		{
			delete[] ptr;

			size=0;

			counter --;


		}

		int push(T);

		int pop(T & n);

		friend void viewContent(Stack s);



};


template <class T>
Stack<T>& Stack<T>:: operator= (Stack<T> & s){


		   int i=0;

		   top = s.top;

		   size = s.size;

		   ptr = new T[size];

		   for(i=0;i<size;i++)
		   {
			  ptr[i] = s.ptr[i];

		   }

		   return * this;

		}



template<class T>
Stack<T> :: Stack(Stack<T> & s){


		top = s.top;

		size = s.size;

		ptr = new T [size];

		for(int i=0;i<top;i++)
			{
				ptr[i] = s.ptr[i];
			}

		counter++;




}



template<class T>
int Stack<T>::push(T n)

{

	if(isFull())

		return 0;


	ptr[top]=n;

	top++;

	return 1;


}

template<class T>
int Stack<T>::pop(T & n)

{

	if(isEmpty())

		return 0;

	top--;

	n = ptr[top];

	return 1;


}


template<class T>
int Stack< T > ::counter = 0;


template<class T>
void viewContent (Stack<T> s) {

	for(int i=0; i<s.top; i++)

		cout << "\n Element no (" << i+1 << ") = " << s.ptr[i];
}




int main(){


	clrscr();

	int n;

	Stack<int> s1(5);

	cout<<"\nNo of Int Stacks is:"<<Stack<int>::getCounter();

	s1.push(14);

	s1.push(20);

	s1.push(30);

	s1.pop(n);

	cout<<"\n1st integer: "<<n;

	s1.pop(n);

	cout<<"\n2nd integer: "<<n;

	Stack<char> s2;


	char nc;

	cout<<"\nNo of char Stacks is:"<<Stack<char>::getCounter();

	s2.push('a');

	s2.push('b');

	s2.push('c');

	viewContent(s2);



	getch();

	return 0;

};

