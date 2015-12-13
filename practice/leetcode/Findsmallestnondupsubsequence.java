/*
Given a string which contains only lowercase letters, remove duplicate letters so that every letter appear once and only once. You must make sure your result is the smallest in lexicographical order among all possible results.

Example:
Given "bcabc"
Return "abc"

Given "cbacdcbc"
Return "acdb"

*/

public class Solution {
    public String removeDuplicateLetters(String s) {
        
        int [] count=new int[256];
        
        for (int i=0; i< s.length(); i++){
            count[s.charAt(i)]++;
        }
        
        String result="";
    
        
        return findSmallest(count, s, 0, "");
        
    }
    
    public String findSmallest(int [] arr, String s, int strIndex, String solution){
        
        
        
        
         for(int i=0; i< arr.length; i++){
                 
                  // if found
           if(arr[i]>0){
            
              
          
              int j=strIndex;
              for(j=strIndex; j< s.length(); j++){
                 if(s.charAt(j)==(char)i){
                      break;
                }
              
                }
          
             if(j>=s.length())
                return null;
        
             arr[i]=0;
             
             String answer= findSmallest(arr, s, j, solution+ ((char) i));
             arr[i]=1;
          
             if(answer!=null)
                return answer;
             
          
           }
     
                 
                 
        }
        
           return solution;
        
        
    }
    
}

public class Solution {
    public String removeDuplicateLetters(String s) {
        
        if(s.length()==0)
        return "";
        
        ArrayList <String> prevSolutions= new ArrayList<String>();
         String prevBest=String.valueOf(s.charAt(s.length()-1));
         prevSolutions.add(prevBest);
         
        for (int index=0; index<s.length(); i++){
              ArrayList <String> curSolutions= new ArrayList<String>();
              char curChar=s.charAt(index);
              
              if(prevSolutions.get(0).indexOf(curChar)!=-1){
                   for(String solution: prevSolutions){
                   if(solution.indexOf(curChar)!=-1)
                      curSolutions.add(solution);
                   curSolutions.add(addChar(curChar, solution ));
                   
                 }
                  
              }else{
                  String best=prevSolutions.get(0);
                   for(String solution: prevSolutions){
                         if(solution.compareTo( best)<0)
                        best=solution;

                 } 
                 curSolutions.add(curChar+best);
                  
              }
              
             
                   
              prevSolutions=curSolutions;
              System.out.println(Arrays.toString(prevSolutions.toArray()));
              
        }
        
        String bestSolution=prevSolutions.get(0);
        for (String solution: prevSolutions){
            if(solution.compareTo( bestSolution)<0)
              bestSolution=solution;
            
        }
        
        return bestSolution;
        
       
    }
    
    public String addChar(char curChar, String prevSolution){
          
        String result="";
      
                
        result=prevSolution.replace(String.valueOf(curChar), "");
        result=curChar+result;
   
        return result;
        
        
    }

    
   
    
}


public class Solution {
    public String removeDuplicateLetters(String s) {
        int [] count=new int[256];
        int [] deleted= new int [s.length()];
        
      for(int i=0; i< s.length(); i++){
          
          count[s.charAt(i)]++;
      }    
        int i=s.length()-1; 
      while(i>0){
          
          char curChar=s.charAt(i);
          if(count[curChar]>1){
              
              int j;
              for(j=i-1; j>=0; j--){
                  if(deleted[j]==0 && curChar==s.charAt(j) )
                   {
                       int prevIndex= findPrevIndex(s, deleted, j); 
                       int nextIndex= findNextIndex(s, deleted ,j);
                       int nextnextIndex=findNextIndex(s, deleted, nextIndex);
                       
                       if(prevIndex>=0 && nextIndex<s.length() && 
                       s.charAt(j) > s.charAt(nextIndex) && 
                       s.charAt(prevIndex)!=s.charAt(nextIndex)
                       ){
                       
                       deleted[j]=1;
                      break;
                       } else if(   prevIndex>=0 && nextIndex<s.length() && nextnextIndex<s.length() &&
                       s.charAt(prevIndex)==s.charAt(nextIndex)
                           && s.charAt(j)> s.charAt(nextnextIndex)){
                         deleted[j]=1;
                      break;
                           
                       }
                       else if (
                           prevIndex==-1 && nextIndex<s.length() &&
                       s.charAt(j) > s.charAt(nextIndex)
                       ){
                            deleted[j]=1;
                      break;
                           
                       }
                   }
                    
              }
              if(j<0)
                deleted[i]=1;
                
              // System.out.println(Arrays.toString(deleted));
              
              count[curChar]--;
              
          }
          
          if(count[curChar]==1 || deleted[i]==1)
             i--;
      
      }
      String result="";
      for(int j=0; j< s.length(); j++){
          if(deleted[j]==0)
             result+=s.charAt(j);
          
      }
       
       return result;
    }
    
    public int findPrevIndex(String s, int [] deleted, int i){
        
        if (i<=0)
           return -1;
        
        for(int j=i-1; j>=0; j--){
            if(deleted[j]==0)
              return j;
            
        }
        return -1;
        
        
    }
    
    public int findNextIndex(String s, int [] deleted, int i){
        
        
        for(int j=i+1; j<s.length(); j++){
            if(deleted[j]==0)
              return j;
            
        }
        return s.length();
        
        
    }
    
  
 
    
   
    
}


public class Solution {
    public String removeDuplicateLetters(String s) {
        
        
    int []count=new int[256];
    for(int i=0; i< s.length(); i++)
      count[s.charAt(i)]++;
     
     String bestSolution="";
     for(int i=0; i<s.length(); i++){
         
         char curChar=s.charAt(i);
         count[curChar]--;
         if(bestSolution.indexOf(curChar)!=-1){
             String prevSol=bestSolution;
             String nextSol=prevSol.replace(String.valueOf(curChar), "")+curChar;
             
            System.out.format("index : %d  char: %s  count %d prevSol: %s, nextsol: %s \n", i, curChar, count[curChar], prevSol, nextSol);
            
                    
            
            int k;
            char peek=' ';
            for(k=0; k<prevSol.length(); k++){
                
                if (prevSol.charAt(k)!=nextSol.charAt(k)){
                   peek=nextSol.charAt(k);
                   break;
                }
                
            }
            
            System.out.println(count[peek]);
            
            if(count[peek]>0 && nextSol.charAt(k+1)< prevSol.charAt(k)){
                
                bestSolution=nextSol;
                
            }    
             else if(nextSol.compareTo (prevSol) <0 ){
               bestSolution=nextSol;
               
         }
         }else{
             
             bestSolution=bestSolution+curChar;
         }
         
         
        
            
            
            
             /*
             char peek=nextSol.charAt(0);
             if(count[peek]>0 && nextSol.length()>1){
                 
                 String replacedPrevious=prevSol.replace(String.valueOf(peek), "");
                 String replacedNext=nextSol.replace(String.valueOf(peek), "");
                 
                 if(replacedPrevious.equals(replacedNext)){
                     if(nextSol.compareTo (prevSol) <0 )
                       bestSolution=nextSol;
           
                 }else if (replacedNext.compareTo(replacedPrevious) < 0 && replacedNext.compareTo(prevSol) <0 
                 && replacedNext.compareTo(nextSol)<0){
                     
                     bestSolution=nextSol;
                     
                     
                     
                 }else if (replacedPrevious.compareTo(replacedNext) < 0 && replacedPrevious.compareTo(prevSol) <0 
                 && replacedPrevious.compareTo(nextSol)<0){
                     
                    bestSolution=prevSol;                     
                     
                 }
                 else if(nextSol.compareTo (prevSol) <0){
                     
                     bestSolution=nextSol;
                 }
                 
           
               
    
                 
             }*/
         
     
         
         
    //    System.out.println("best solution: "+bestSolution);
         
   
     }
     
     return bestSolution;
     
    }

    
}


public class Solution {
    public String removeDuplicateLetters(String s) {
        
        
    int []count=new int[256];
    int [] deleted=new int [s.length()];
    for(int i=0; i< s.length(); i++)
      count[s.charAt(i)]++;
     
     String bestSolution="";
    
    int start=0; 
    while (start<s.length()){
        
        int end=start;
        for(; end<s.length(); end++){
            
            System.out.format("Processing character: %s with count %d\n", s.charAt(end), count[s.charAt(end)]);
            
            if(count[s.charAt(end)]==0){
                
                System.out.format("deleting character: %s\n", s.charAt(end));
               deleted[end]=1;
            }
            else if(count[s.charAt(end)]==1){
                // check duplicate
                
                int peek=start;
                boolean found=false;
                for(; peek<=end; peek++){
                    if(s.charAt(peek)==s.charAt(end)){
                        if(s.charAt(peek)<= s.charAt(peek+1)){
                            // delete end
                            found=true;
                            
                        }else if (s.charAt(peek)> s.charAt(peek+1)){
                            deleted[peek]=1;
                            
                        }
                        
                        else if(found){
                            
                            deleted[peek]=1;
                        }

                    }
                    
                }
               
                
                if(peek>end){
                       count[s.charAt(end)]=0;
                         break;
                    
                }else{
                   
                      count[s.charAt(end)]=0;
                
                }
                
            }else{
                
              count[s.charAt(end)]--;  
                
            }
    }
    
    
            
        
        if(end<s.length()){
            
            System.out.format("start: %d, end: %s, endchar: %s\n", start, end, s.charAt(end));
            
            int included=end;
            for(int i=end-1; i>=start; i-- ){
                if(s.charAt(i)< s.charAt(included) && deleted[i]==0){
                 count[s.charAt(i)]=0;
                 deleted[i]=0; 
                 included=i;
                    System.out.format("delete: %s count: %d\n", s.charAt(i), count[s.charAt(i)]);
                }else
                
                    deleted[i]=1;
            }
          
                System.out.println(s.substring(0, end+1));
        System.out.println(Arrays.toString(deleted));
              
           
 
        }
      
        
        start=end+1;
        

    }
    for(int i=0; i< s.length(); i++){
        if(deleted[i]==0){
            
            bestSolution+=s.charAt(i);
            
        }
        
        
    }
    
    
     return bestSolution;
     
    }

    
}

public class Solution {
    public String removeDuplicateLetters(String s) {
        
     int [] count=new int [256];
     int [] consumed=new int[256];
     int [] deleted=new int[s.length()];
     for(int i=0; i< s.length(); i++){
         
         count[s.charAt(i)]++;
         consumed[s.charAt(i)]++;
     }
     
     int start=0;
     String answer="";
    
     for(int i=0; i<s.length(); i++){
         
         
         
         // single character
         if(consumed[s.charAt(i)]==1){
             int end=i;
             /*if(count[s.charAt(i)]>1)
               end=i+1;
             */
             String substring="";
             
             for(int j=start; j<end; j++){
                 if(consumed[s.charAt(j)]>0){
                    
                        substring+=s.charAt(j);
                    
                 }
                 
             }
              
              char[] chars = substring.toCharArray();
              Arrays.sort(chars);
              substring = new String(chars);
              
              System.out.format("i: %d, char: %s start: %d\n", i, s.charAt(i), start);
              System.out.println(substring);
              
              char cur='1';
              for(int j=0; j<substring.length(); j++){
                  if(/*count[s.charAt(i)]==1 &&*/ substring.charAt(j)<s.charAt(end)&& s.charAt(j)!=cur){
                     
                      
                      System.out.print(substring.charAt(j));
                      consumed[substring.charAt(j)]=0;
                      answer+=substring.charAt(j);
                      
                  }
                  
                   cur=s.charAt(j);
                   
                  
              }
              
              
              System.out.println("consume end");
              System.out.println("consuming "+s.charAt(end));
              answer+=s.charAt(end);
              start=i+1;
         }
         
         
           consumed[s.charAt(i)]--;
          
         
         
     }
     
     return answer;
     
     
     
     
        
        
    }
  

    
}