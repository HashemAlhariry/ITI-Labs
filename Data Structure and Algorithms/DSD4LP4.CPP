#include <iostream.h>
#include <conio.h>
#include <stdlib.h>

class Queue
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

	

		Queue()

		{
			top = 0;

			size = 10;

			ptr = new int[size];

			counter ++;


		}

		Queue (int n)

		{

			top = 0;

			size = n;

			ptr = new int [size];

			counter ++;

		}

		~Queue()
		{
			delete[] ptr;

			size=0;

			counter --;


		}

		int push(int n);

		int pop(int & n);

		friend void viewContent(Queue s);


};




int Queue::isFull()
{

	return(top==size);

}



int Queue::isEmpty()

{


	return (top==0);

}



int Queue::push(int n)

{

	if(isFull())

		return 0;


	ptr[top]=n;

	top++;

	return 1;


}

int Queue::pop(int & n)

{

	if(isEmpty())

		return 0;



	n = ptr[0];

	for(int i=0;i<top-1;i++){

		ptr[i]=ptr[i+1];

	}

	top--;

	return 1;


}

int Queue::counter = 0;


void viewContent (Queue s) {


	for(int i=0; i<s.top; i++)

		cout << "\n Element no (" << i+1 << ") = " << s.ptr[i];
}




int main(){


	clrscr();

	int num;


	Queue queue;

	queue.push(12);

	queue.push(2);

	queue.push(5);

	queue.push(8);

	queue.push(4);

	queue.push(1);

	queue.push(0);

	queue.push(90);

	viewContent(queue);



	cout<<endl;

	cout<<"Last element poped up: ";

	queue.pop(num);

	cout<<num<<endl;

	cout<<"Last element poped up: ";

	queue.pop(num);

	cout<<num<<endl;

	viewContent(queue);


	getch();



	return 0;

};

