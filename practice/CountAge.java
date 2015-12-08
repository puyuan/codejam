import java.io.*;
import java.util.*;

/*
 Given an array of ages (integers) sorted lowest to highest, output the number of occurrences for each age. 
For instance: 
[8,8,8,9,9,11,15,16,16,16] 
should output something like: 
8: 3 
9: 2 
11: 1 
15: 1 
16: 3 

This should be done in less than O(n).
 */

class Solution {
  public static void main(String[] args) {
    
    int [] arr={8,8,8,9,9,11,15,16,16,16};
    
    countAge(arr);

  }
  
  static void countAge(int [] arr){
    
    int [] counter=new int[250];
    
    // java array initalized to 0
    
    
    for(int i=0; i< arr.length; i++){
      
      counter[arr[i]]++;      
    }
    
    for (int i=0; i< counter.length; i++){
      
      if(counter[i]!=0)
        System.out.format("Age: %d,  count: %d\n", i, counter[i]);
      
    }
    
    
  }
  
  

  
}




/* 
Your previous C++ content is preserved below:


 */