/*Given a random string S and another string T with unique elements, find the minimum consecutive sub-string of S such that it contains all the elements in T. 
example: 
S='adobecodebanc' 
T='abc' 
answer='banc'

- Saghar H 15 days ago in United States | Report Duplicate | Flag */

public class HelloWorld{

     public static void main(String []args){
        String s="adobecodebanc"
        String t="abc";
        int start=0;
        int end=0;
        int minStart=0;
        int minEnd=0;
        
        for(int head=0; head<s.length; head++){
            String temp=t;
            boolean match=false;
            
            for (int tail=head; tail<s.length; tail++){
            // find a match
              for (int j=0; j<temp.length; j++){
                 if(s[head]==temp[j]){
        
                     temp=temp.replace(temp[j], "");
                     match=true;
                     break;
                 }
                
                }
                if(match)
                   break;
                if(temp.length==0){
                    start=i; 
                    end=k;
                    if(end-start < minEnd-minStart )
                       {
                           minStart=start;
                           minEnd=end;
                           
                       }
                    break;
                
                 }
            
            }
      
        }
     }
     
  
}




