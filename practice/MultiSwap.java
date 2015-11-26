/**
We have an array of objects A and an array of indexes B. Reorder objects in array A with given indexes in array B. Do not change array A's length. 

example:


var A = [C, D, E, F, G];
var B = [3, 0, 4, 1, 2];

sort(A, B);

**/



public class HelloWorld{

     public static void main(String []args){
        char A[]= {'C', 'D', 'E', 'F', 'G'};
        int B[]={3,0,4,1,2};
        
        for (int i=0; i< A.length; i++){
            
            while(B[i]!=i){
                swap(B, i, B[i]);
                swap(A, i, B[i]);
                
            }
            
            
        }
        
     }
     
     static void sort(Object [] arr, int a, int b){
         
         Object temp=arr[a];
         arr[a]=arr[b];
         arr[b]=temp;
         
     }
}
