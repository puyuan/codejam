import java.io.*;
import java.util.*;

/*
 * To execute Java, please define "static void main" on a class
 * named Solution.
 *
 * If you need more classes, simply define them inline.
 */

class Solution {
  public static void main(String[] args) {
    
    char board[][]= {{'s', 'm', 'e', 'f'}, {'r', 'a', 't', 'd'}, {'l', 'o', 'n', 'i'}, {'k', 'a','f','b'}};
    String word="sand";
    char []charword=word.toCharArray();
    boolean result=findWord(board, charword);
    
    
    System.out.println(result);
    
    
  }
  
  public static boolean findWord(char [][] board, char [] word){
    
    char firstChar=word[0];
    
    boolean found[][]=new boolean[board.length][board.length];
    
    boolean result=false;
    
    for(int i=0; i< board.length; i++){
      
      for (int j=0; j< board[i].length; j++){
        
        if(board[i][j]==firstChar){
          
         System.out.format("index[%d][%d] = %s \n", i, j, board[i][j]);
         
         result = result || findAdjacent(board, i , j, found, word, 1);
         
       }    
       
       
     }
     
     
   }
   
   return result;
   
   
   
 }
 
 
 public static boolean findAdjacent(char [][]board, int i, int j, boolean [][] found, char [] word, int depth){
  
  
  if(depth==word.length)
    return true;
  
  
  boolean result=false;
  
  for(int k=i-1; k <= (i+1); k++){
    
    if (k<0 || k>=board.length)
      continue;
    
    
    for(int l=j-1; l<=(j+1); l++){
      
      if(!(l>=0 && l< board[k].length))
        continue;
      
        //System.out.format("index[%d][%d] = %s \n", k, l, board[k][l]);
      if(word[depth]== board[k][l] && !(k==i && l==j) && found[k][l]==false){
        
       System.out.format("index[%d][%d] = %s \n", k, l, board[k][l]);
       found[k][l]=true;
       result= result || findAdjacent(board, k, l, found, word, depth+1);
       found[k][l]=false;
       
       
     }
     
     
   }
   
   
   
 }
 
 return result;
 
 
 
 
 
}


}
