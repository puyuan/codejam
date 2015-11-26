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
    
    int set[]={1,2,3,4,5,6,7};
    int a[]=new int[50];
    findSubSet(a, -1, set);
    
    
    
  }
  
static void findSubSet(int a[], int k, int set[] ){
        
        int [] candidates={0, 1};
            
        if(k==set.length-1){
            printSolution(a, k, set);
             return;   
        }
        k++;
        for(int i=0; i< candidates.length; i++){
            a[set[k]]=candidates[i];
            findSubSet(a, k, set);
            
            
        }
        
        
        
    }

  static void printSolution(int a[], int k, int set[]){
   
      for (int i=0; i<set.length; i++){
       
          if (a[set[i]]==1)
              System.out.print(set[i]+",");
      }
            System.out.println("");
                                
      
  }


 
}
