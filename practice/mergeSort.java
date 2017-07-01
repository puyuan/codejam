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
    
    int [] arr={5,6,2,3,8,9, 200, -1, 300, 400, 34,1,17,8,9,10,24,57,89,12};
    
    mergeSort(arr, 0, arr.length-1);
   
  }
  
  public static void mergeSort(int [] arr, int min, int high){
    int mid=(min+high)/2;
    System.out.println(Arrays.toString(arr));
    System.out.println("Min: "+ min+" mid: "+mid+ " high: "+high );
    if(min==high)
      return;
    mergeSort(arr, min, mid);
    mergeSort(arr, mid+1, high);
    System.out.println("Merging: ");
    mergeStep(arr, min, mid, high);    
    System.out.println("Min: "+ min+" mid: "+mid+ " high: "+high );
    System.out.println(Arrays.toString(arr));
  }
  
  
  public static void mergeStep(int [] arr, int min, int mid, int high){
    int i=min;
    int j=mid+1;
    int k=0;
    int [] temp=new int[high-min+1];
    while(i<=mid && j <=high){
      
      if(arr[i]<arr[j]){
        temp[k]=arr[i];
        i++;
      }
      else{
        temp[k]=arr[j];
       j++; 
      }
      k++;
           
    }
    
    if(i<=mid){
      
      while(i<=mid){
        temp[k]=arr[i];
        i++;
        k++;
        
      }}
    
    else{
        
        while(j<=high){
          temp[k]=arr[j];
          j++;
          k++;  
        }       
        
      }
      
    for(int l=0; l<temp.length; l++){
      
      arr[l+min]=temp[l];
      
    }
  
    
  }
}
