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
    
    int [] coins=new int[4];
    int [] types= {25, 10, 5, 1};
    
    numSum(coins, 0, types, 194);
    
    
  }
  
  static void numSum(int [] coins, int k, int [] types, int target){
    
    int sum=0;
     for (int i=0; i< coins.length; i++){
       
       sum+=types[i]*coins[i];
     }
     
    
    if(sum==target){
       for (int i=0; i< coins.length; i++){
        System.out.format("%d coins: %d, ", types[i], coins[i]);
      
     }
        System.out.println("end");
      
    }
    
    if(sum>=target){
     
      
      return;
    }

    
    
    for(int i=k; i< coins.length; i++){
      
      coins[i]++;
      numSum(coins, i , types, target  );
      coins[i]--;
      
      
      
    }
    
    
    
    
  }

 
}
