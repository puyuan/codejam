import java.io.*;
import java.util.*;

/*
  * Merge two sorted array O(n)
 */

class Solution {
  public static void main(String[] args) {
 
    int a[]=new int[20];
    a[0]=7;
    a[1]=12;
    a[2]=45;
    a[3]=65;
    a[4]=78;
 
    int b[]= {1,2,3,4,5};
    
    int i=4, j=b.length-1;
    int k=5+b.length-1;
    
    while(i>=0 && j>=0){
      if(a[i]>b[j]){
        
        a[k]=a[i];
        i--;
       
      }else{
        a[k]=b[j];
        j--;
        
      }
      k--;
      
      
    }
    
    for (; j>=0; j--){
          a[k]=b[j];  
          k--;
    }
    
    
    for( i=0; i<=4+b.length; i++){
      System.out.println(a[i]+"\n");
      
    }
    
    
    
  }
}
