public class HelloWorld{

     public static void main(String []args){
        
        String str="adobecodebanc";
        String t="abc";
        
        int lookup[]=new int[256];
        int found[]=new int[256];
        for(int i=0; i< t.length; i++)
           lookup[t[i]]=1;
        
        int start=0;
        int end=0;
        int count=0;
        int minstart=0;
        int minend=0;
        int minlength=0;
        
        for(int i=0; i< str.length; i++){
            if(lookup[str[i]]==1){
                found[str[i]]++;
                if(found[str[i]]==1)
                   count++;
                
            }
            
            if(count==t.length){
                
                while(count==t.length){
                    if(found[str[start]]==1)
                      count--;
                      
                    if(found[str[start]]>0){
                        found[str[start]]--;
                        if(i-start<minlength){
                        minstart=start;
                        minend=i;
                        }
                    }
                    
                    
                    start++;
                    
                    
                }
                
                
                
            }
            
            
            
            
            
            
            
            
        }
        
     }
}
