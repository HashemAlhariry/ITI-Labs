#include <iostream.h>
#include <conio.h>

class Node{

  public:

	Node * next;

	Node * before;

	int data;

	Node(){

	 next=before=NULL;

	 data = 0;

	}

	Node (int dataNumber){

	 data=dataNumber;

	 next = before = NULL;

	}
};


class LinkedListStack{

	public:

		Node* last;

		int size;

		LinkedListStack(){

		   last = NULL;

		   size=0;

		};



};


class Stack{

		LinkedListStack LLstack;

		int existSize;

	public:

		Stack();

		~Stack();

		Node* getLast();

		void setLast(Node* node);

		int getSize(){

			return LLstack.size;

		}
		void setSize(int size){

			LLstack.size = size;

		}

		int push(Node * node);

		int pop ();

		Node * searchOnNode(int key);

		void freeList();

		int isEmpty();

		void printList();

};

int main(){


   Node *n1 =new Node(1),

		*n2 =new Node(2),

		*n3 =new Node(3),

		*n4 =new Node(4),

		*n5 =new Node(5),

		*n6 =new Node(6);


   int tempNumber=0;

   clrscr();

   Stack stack;

   cout<<"Size of Nodes " <<stack.getSize()<<endl;

   stack.printList();

   stack.push(n3);

   stack.push(n4);

   stack.push(n5);

   stack.push(n2);

   stack.push(n1);

   stack.push(n6);

   cout<<"Size of Nodes " <<stack.getSize()<<endl;

   stack.printList();

   cout<<endl;

   tempNumber=stack.pop();

   cout<<"Last Number poped up: "<<tempNumber<<endl;

   tempNumber = stack.pop();

   cout<<"Last Number poped up: "<<tempNumber<<endl;

   stack.printList();

   getch();

   return 0;


}

Stack::Stack():LLstack(){

	existSize=0;

}

Stack::~Stack(){

	freeList();

}


Node* Stack::getLast(){


	return LLstack.last;

}

void Stack::setLast(Node * node){

	LLstack.last = node;
}

int Stack::push(Node * node) {


   if(getLast()==NULL){

		setLast(node);

   }
   else{

	   Node * temp = getLast();

	   temp->next = node;

	   node->before = temp;

	   setLast(node);

   }


	int sizeOfStack = getSize();

	sizeOfStack++;

	setSize(sizeOfStack);

	return 1;

}



int Stack::pop() {


   Node* temp = getLast();

   if(temp==NULL)
		return NULL;

   setLast(temp->before);

   temp->next =NULL;

   return temp->data;

}


void Stack:: printList(){


	Node * temp = getLast();

	if(getLast()==NULL){

		cout<<"0 in List "<<endl;

		return;

	}

	cout<<"Printed from top to bottom: ";

	temp = getLast();

	while(temp){

		cout<<temp->data<<" ";

		temp = temp->before;

	}


}



Node *Stack:: searchOnNode(int key){


	Node *temp = getLast();

	if(temp == NULL) return NULL;

	while( !(temp==NULL) && temp->data!=key )
		temp = temp->next;

	return temp;

};



void Stack:: freeList(){

	Node *temp=getLast();

	while(temp){

		setLast(temp->next);

		delete temp;

		temp=getLast();
		}

	setLast(NULL);

	setSize(0);

};


int Stack:: isEmpty(){

			return getLast()==NULL;

};
