#include <iostream>
using namespace std;

struct TreeNode {
  int x;
  TreeNode * left;
  TreeNode * right;
  
};

TreeNode * traverseTree(TreeNode * node, TreeNode * &prev, TreeNode * &head){
  
  if(node==NULL)
    return NULL;
  traverseTree(node -> left, prev, head);
  
  if(prev==NULL){
    head= node;
    
  } else{
    
     prev -> right =node;
    node -> left=  prev;
    
  }
  prev=node;
  printf ("%d\n", node -> x);
  
  traverseTree(node -> right, prev, head);
  
}


// To execute C++, please define "int main()"
int main() {
 
  TreeNode * root=new TreeNode;
  root -> x=5;
  
  TreeNode * leftNode= new TreeNode;
  leftNode-> x=4;
  leftNode-> left=NULL;
  leftNode->right=NULL;
  
  TreeNode * rightNode= new TreeNode;
  rightNode-> x=7;
  rightNode-> left=NULL;
  rightNode->right=NULL;
  
  root -> left=leftNode;
  root -> right=rightNode;
  
  TreeNode * prev;
  TreeNode * head;
  
  
  
  traverseTree(root, prev, head);
  
  
}

