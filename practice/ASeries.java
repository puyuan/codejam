import java.io.*;
import java.util.*;

/*
  Topcoder: ASeries
   https://arena.topcoder.com/#/u/practiceCode/1345/1640/1758/1/1345
   
 * To execute Java, please define "static void main" on a class
 * named Solution.
 *
 * If you need more classes, simply define them inline.
 */



import java.util.HashMap;

public class Solution {
  
    public static void main(String[] args) {
      
      int []values={3,8,4,5,6,2,2};
      
   
      
      for(int i=0; i< values.length; i++)
      {
        System.out.println(Arrays.toString(values));
        values=shiftArray(values);
        
        System.out.println(longest(values));
     
      }
      
  }
  
  public static int [] shiftArray(int [] array){
    
     List <Integer> arrList= new ArrayList<Integer>();
    
    for (int i=0; i<array.length; i++)
      arrList.add(array[i]);
    
   
    Integer first=arrList.remove(0);
    arrList.add(first);
    
    int []temp= new int [array.length];
    for (int i=0; i<array.length; i++)
      temp[i]= arrList.get(i);
    
    return temp;
    
  }
 
    
    public static int longest(int[] values){
     
        HashMap <String, Integer> lookup=new HashMap<String, Integer>();
        
        for(int i=0; i< values.length; i++){
         
            for (int j=0; j<=i ; j++ ){
              
              
           
              
                int diff=values[i]-values[j];
                String key=values[j]+","+diff;
                Integer count=lookup.get(key);
                if(count==null )
                    count=0;
                
                // update current table
                key=values[i]+","+diff;
              Integer curCount= lookup.get(key);
                if(curCount==null && diff!=0)
                  curCount=1;
                else if (curCount==null)
                  curCount=0;
              
                count=count > curCount ? count: curCount;
              
             // System.out.println(count);
                lookup.put(key, count+1);
                
            }
          /*
            for (Map.Entry<String, Integer> entry : lookup.entrySet()) {
                System.out.println(entry.getKey()+" : "+entry.getValue());
             }*/
          
        }
          int max=0;
        for(Integer val: lookup.values()){
            if(val==null)
              continue;
             max=max < val? val: max;
            }
        
        return max;
        
      
        
        
    }
    
    
    
}
