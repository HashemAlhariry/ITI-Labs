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


class LinkedListQueue{

	public:

		Node* start;

		int size;

		static int maxSize;

		LinkedListQueue(){

		   start = NULL;

		   size=0;

		};

		int push(Node * node);

		int pop ();

		Node * searchOnNode(int key);

		void freeList();

		int getSize();

		int isEmpty();

		void printList();


		//Node * getFirst();

		//void appendNode(Node *app);

		//void insertNode (Node* ins);

		//int deleteNode(int key);

		//Node * getLast();




};




int main(){


   Node *n1 = new Node(1) ,

		*n2 =new Node(2),

		*n3 =new Node(3),

		*n4 =new Node(4),

		*n5 =new Node(5),

		*n6 =new Node(6);


   int tempNumber=0;

   clrscr();

   LinkedListQueue list;

   cout<<"Size of Nodes " <<list.getSize()<<endl;

   list.printList();

   list.push(n6);

   list.push(n5);

   list.push(n2);

   list.push(n1);

   list.push(n3);

   list.push(n4);

   cout<<"Size of Nodes "<<list.getSize()<<endl;

   list.printList();

   cout<<endl;

   tempNumber = list.pop();

   cout<<"Last Number poped up: "<<tempNumber<<endl;

   tempNumber = list.pop();

   cout<<"Last Number poped up: "<<tempNumber<<endl;

   list.printList();



   /*

   cout<<endl<<"--------"<<endl;

   cout<<"Deleteing element: 2"<<endl;

   list.deleteNode(2);

   list.printList();

   cout<<"\nDeleteing element: 4"<<endl;

   list.deleteNode(4);

   list.printList();

   cout<<endl;

   Node *n7 = list.getFirst();

   cout<<"Getting First element:  " <<n7->data;

   list.freeList();


   */




   getch();

   return 0;


}


int LinkedListQueue::push(Node * node) {


   if(start==NULL){

		start=node;


   }else{


	   start->before = node;

	   node->next=start;

	   start = node;

   }


	size++;

	return 1;

}



int LinkedListQueue::pop() {

   Node* temp = start;

   if(temp==NULL)
		return NULL;


   start=start->next;

   start->before = NULL;

   return temp->data;

}


void LinkedListQueue:: printList(){


	Node * temp = start;

	if(start==NULL){

		cout<<"0 in List "<<endl;

		return;

	}

	cout<<"Printed from bottom to top: ";

	while(temp){



		cout<<temp->data<<" ";

		temp = temp->next;

	}

}



Node * LinkedListQueue:: searchOnNode(int key){


	Node *temp = start;

	if(start == NULL) return NULL;

	while( !(temp==NULL) && temp->data!=key )
		temp = temp->next;

	return temp;

};



void LinkedListQueue:: freeList(){



			Node *temp = start;

			while(temp){

				start = start->next;

				delete temp;

				temp=start;
			}

			start=NULL;

			size=0;

};


int LinkedListQueue:: getSize(){


			return size;

};

int LinkedListQueue:: isEmpty(){


			return start==NULL;

};



/*
Node *LinkedListStack:: getLast(){

			if(isEmpty()) return NULL;

			Node * temp = end;

			end = end->before;

			if(end)  end->next = NULL;

			else	 start = NULL;

			temp->before = temp->next = NULL;

			size--;

			return temp;



}

*/


/*
void LinkedList:: appendNode(Node *app){


	if(start==NULL){

		start=end=app;

	}
	else{

		app->before=end;

		end->next=app;

		end=app;

	}

	size++ ;


}

*/
/*
Node *LinkedList:: getFirst(){



			if(isEmpty())  return NULL;

			Node *temp = start;

			start= start->next;

			if(start)   start->before=NULL;

			else  		end=NULL;

			temp->before = temp->next =NULL;

			size--;

			return temp;
};
*/


/*
void LinkedList:: insertNode (Node* ins){



		 Node * temp = start;

		 while(temp!=NULL && (temp->data < ins->data)){

			temp= temp->next;

		 }

		 if(!temp)
		 {

			appendNode(ins);

		 }else{


			 if(temp==start)

			 {
				start->before = ins;

				ins->next=start;

				start = ins;

			 }
			 else{

				temp->before->next = ins;

				ins->before=temp->before;

				ins->next = temp;

				temp->before = ins;

			 }
			 size++;

		   }


};
*/
/*
int LinkedList:: deleteNode(int key){


			Node * temp;

			if(start==NULL) return 0;

			temp=searchOnNode(key);

			if(temp==NULL) return 0;

			if(start ==temp && end ==temp){

				start = end = NULL;

				delete temp;

			}
			else{

			  if(start == temp){

					start = start->next;

					start->before=NULL;

					delete temp;


			 }else if(end==temp){

					end=end->before;

					end->next=NULL;

					delete temp;

			   }
			  else{

				temp->before->next=temp->next;

				temp->next->before = temp->before;

				delete temp;


				}


			}

			size--;

			return 1;


};

*/

