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
   
    int [] coins ={5, 10, 25};
    int target=30;
    System.out.println( minCoins(coins, target));
    
  }
  
  
  static int minCoins( int [] coins, int target){
    
    int [] table = new int[target+1];
  
    
    for(int i=0; i< target; i++)
      table[i]=-1;
    
      table[0]=0;
    
    for (int i=0; i<= target; i++){
      
      int min=Integer.MAX_VALUE;
      for(int j=0; j< coins.length; j++){
        
         
        if(i-coins[j]>=0 && table[i-coins[j]] !=-1 ){
          min= min < (1+ table[i-coins[j]]) ? min : (1+  table[i-coins[j]]);
          table[i]=min;
        }
           
   
        System.out.format("target: %d, coin: %d, minCoins: %d\n", i, coins[j], table[i]);
        
      }
      
     
      
    
      
      
    }
    
    return table[target];
    
    
    
    
  }
}
