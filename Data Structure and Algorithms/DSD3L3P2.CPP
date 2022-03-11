#include <iostream.h>
#include <conio.h>
#include <string.h>

struct Employee {


	public:
	char name[50];

	int code;

	int salary;

	int deduct;

	int bonus;

};

class Node{

  public:

	Node * next;

	Node * before;

	struct Employee empData;

	Node(){

	 next=before=NULL;



	}

	Node (Employee data){


	strcpy(empData.name,data.name);

	empData.code = data.code;

	empData.salary = data.salary;

	empData.deduct = data.deduct;

	empData.bonus = data.bonus;

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

			delete start;

			delete end;

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



	int menuNumber=0;

	int tempNumber=0;

	int i=0;

	clrscr();

	gotoxy(24 , 12);

	cout<<"WELCOME TO HIGHLIGT MENU NUMBER : "<<endl;

	LinkedList list;

	while(menuNumber != 5){

		clrscr();

		gotoxy(25 , 10);

		cout<<"1-Add new Number";

		gotoxy(25 , 12);

		cout<<"2-Display All Numbers";

		gotoxy(25 , 14);

		cout<<"3-Sort Numbers";

		gotoxy(25 , 16);

		cout<<"4-Search Number";

		gotoxy(25 , 18);

		cout<<"5-Exit ";

		gotoxy(25 , 20);

		cin>>menuNumber;

		if(menuNumber==1){
			 clrscr();
			 struct Employee tempEmp;

			 cout<<"ENTER NAME: "<<" ";
			 cin>>tempEmp.name;
			 cout<<endl;

			 cout<<"ENTER code: "<<" ";
			 cin>>tempEmp.code;
			 cout<<endl;


			 cout<<"ENTER salary: "<<" ";
			 cin>>tempEmp.salary;
			 cout<<endl;

			 cout<<"ENTER deduct: "<< " ";
			 cin>>tempEmp.deduct;
			 cout<<endl;

			 cout<<"ENTER bonus: "<< " ";
			 cin>>tempEmp.bonus;
			 cout<<endl;

			 Node* temp= new Node(tempEmp);


			 list.insertNode(temp);

		}

		if(menuNumber==2){

			 clrscr();
			 list.printList();
			 getch();

		}

		if(menuNumber==3){


		}

		if(menuNumber==4){




			clrscr();
			cout<<"PLEASE ENTER NUMBER TO SEARCH : ";

			cin>>tempNumber;
			Node * temp;

			temp = list.searchOnNode(tempNumber);

			if(temp != NULL){

			  cout<<temp->empData.name;

			}
			getch();

		}





   }


	return 0;


}



void LinkedList:: printList(){


	Node * temp = start;

	if(start==NULL){

		cout<<"0 in List "<<endl;

		return;

	}



	while(temp){


		cout<<temp->empData.name<<" ";

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

			while( !(temp==NULL) && temp->empData.code!=key )
				temp = temp->next;


			return temp;

};


void LinkedList:: insertNode (Node* ins){



		 Node * temp = start;

		 while(temp!=NULL && (temp->empData.code < ins->empData.code)){

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
