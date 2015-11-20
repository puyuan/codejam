/*
Given an array of positive integers (excluding zero) and a target number. Detect whether there is a set of consecutive elements in the array that add up to the target. 

Example: a = {1, 3, 5, 7, 9} 
target = 8 

output = true ({3, 5}) 

or target = 15 
output = true : {3, 5, 8} 

but if target = 6, output would be false. since 1 and 5 are not next to each other.

*/

public class HelloWorld{

     public static void main(String []args){
        int arr[]={1,3,5,7,9};
        int target=8;
        int sum=0;
        
        int k=0;
        for (int i=0; i<arr.length; i++){
            
            while(sum<target){
                sum+=arr[k];
                
                k++;
                
                
            }
            
            if(sum==target){
                System.out.println("true");
                 return ;   
            }
            
            if(sum>target)
               sum-=arr[i];
            
            
        }
        
        System.out.println("false");
        
     }
}


