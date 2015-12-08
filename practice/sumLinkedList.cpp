#include <iostream>
using namespace std;

// To execute C++, please define "int main()"
int main() {
  auto words = { "Hello, ", "World!", "\n" };
  for (const auto& word : words) {
    cout << word;
  }
  return 0;
}

struct node{
  node *next;
  int x; 
};

node * addlist(node *list1, node * list2){
  
  int carry=0;
  
  node *sumPrev=NULL;
  node * sumHead=NULL;
  
  while(list1 !=NULL && list2 != NULL){
    
    int a=list1 ->x;
    int b=list2 ->x;
    int sum=a+b+carry;
    int digit=(sum)%10;
    
    node * sumCur=new node;
    
    sumCur->x=digit;
    if(sumPrev==NULL){
      sumPrev=sumCur;
      sumHead=sumPrev;
    }
    else 
      sumPrev -> next=sumCur;
    
    sumPrev=sumPrev->next;
    carry=sum/10;
    
    list1=list1->next;
    list2=list2->next;
    
    
  }
  
  node *remain=list1==NULL? list2: list1;
  while(remain!=NULL){
    int sum=remain->x+carry;
    int digit=(sum)%10;
    
    node * sumCur=new node;
    sumCur->x=digit;
    if(sumPrev==NULL)
      sumPrev=sumCur;
    else 
      sumPrev -> next=sumCur;
    
    sumPrev=sumPrev->next;
    carry=sum/10;
    remain=remain->next;
    
    
  }  
  
  return sumHead;
  
  
  
}

