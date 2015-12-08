import java.io.*;
import java.util.*;

/*
Print a BST such that it looks like a tree (with new lines and indentation, the way we see it in algorithms books).
 */

class Solution {
  public static void main(String[] args) {

  }
  
  
  public class Node {
    Node left;
    Node right;
    int x;
    
  }
  
  public void printTree(Node root){
    
    if(root==null)
      return;
    
    Queue <Node>queue=new Queue<Node>();
    queue.add(root);
    queue.add(null);
    
    while(!queue.isEmpty()){
      
      Node cur=queue.remove();
      
        if(cur==null){
          System.out.println("");
          queue.add(null);
          continue;
          
        }
      
      // add children
      if(cur.left!=null)
        queue.add(cur.left);
      if(cur.right!=null)
        queue.add(cur.right);
      
      // print cur node
      System.out.print(cur.x);
      
    
      
      
    }
    
    
  }
  
}




/* 
Your previous C++ content is preserved below:


 */