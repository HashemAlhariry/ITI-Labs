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

	 this->data=dataNumber;

	 next = before = NULL;

	}


};


class LinkedList{

	public:

		Node *start;

		Node *end;

		int size;

		LinkedList(){

		   start=end=NULL;

		   size=0;

		};

		~LinkedList(){

		   //	delete start;

		   //	delete end;


		}

		Node * getFirst();

		Node * searchOnNode(int key);

		void appendNode(Node *app);

		void insertNode (Node* ins);

		int deleteNode(int key);

		void freeList();

		int getSize();

		int isEmpty();

		Node * getLast();

		void printList();

};




int main(){


   Node *n1 = new Node(1) ,

		*n2 =new Node(2),

		*n3 =new Node(3),

		*n4 =new Node(4),

		*n5 =new Node(5),

		*n6 =new Node(6);


   clrscr();

   LinkedList list;

   cout<<"Size of Nodes " <<list.getSize()<<endl;

   list.printList();

   list.insertNode(n5);

   list.insertNode(n2);

   list.insertNode(n1);

   list.insertNode(n3);

   list.insertNode(n4);

   list.appendNode(n6);

   cout<<"Size of Nodes "<<list.getSize()<<endl;

   list.printList();

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

   /*

   list.insertNode(n2);

   list.insertNode(n3);

   cout<<"Size of Nodes " <<list.getSize()<<endl;

   cout<<"Priniting nodes ";
   w

   int nodesSize=list.getSize();

   list.printList();

   */


   getch();

   return 0;



}


void LinkedList:: printList(){


	Node * temp = start;

	if(start==NULL){

		cout<<"0 in List "<<endl;

		return;

	}



	while(temp){


		cout<<temp->data<<" ";

		temp = temp->next;


	}

}



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


Node * LinkedList:: searchOnNode(int key){



			Node *temp = start;

			if(start == NULL) return NULL;

			while( !(temp==NULL) && temp->data!=key )
				temp = temp->next;


			return temp;

};


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



void LinkedList:: freeList(){


			Node *temp=start;

			while(temp){

				start = start->next;

				delete temp;

				temp=start;

			}

			end=NULL;

			size=0;


};


int LinkedList:: getSize(){


			return size;

};

int LinkedList:: isEmpty(){


			return start==NULL;

};


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


Node *LinkedList:: getLast(){

			if(isEmpty()) return NULL;

			Node * temp = end;

			end = end->before;

			if(end)  end->next = NULL;

			else	 start = NULL;

			temp->before = temp->next = NULL;

			size--;

			return temp;



}


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
                 