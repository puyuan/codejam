import java.io.*;
import java.util.*;
import java.util.HashMap;

/*
 * To execute Java, please define "static void main" on a class
 * named Solution.
 *
 * If you need more classes, simply define them inline.
 */

class FindAnagram {
  public static void main(String[] args) {
    
    int []lookup=new int[256];
      String str="manyvotedbushretired";
    for(int i=0; i< str.length(); i++){
      
       lookup[str.charAt(i)]++;
      
    }
    
    findAna("", -1, lookup, true, readDic());

  }
  
    static HashMap<String, Integer> readDic(){
        HashMap <String, Integer> map=new HashMap<String, Integer>(); 
        try{
     
    
   File fin=new File("20k.txt");
	// Construct BufferedReader from FileReader
	BufferedReader br = new BufferedReader(new FileReader(fin));
 
	String line = null;
	while ((line = br.readLine()) != null) {
		map.put(line, 1);
	}
 
	br.close();
            
        } catch(Exception e){
            
            
        }
        
        return map;

        
        
    }
  

  
  
  static void findAna(String a, int k, int[] lookup, boolean space, HashMap<String, Integer> map){
    
    
        int beginword=0;
        int endword=0;
          System.out.println(a);
      String []strArr=a.split(" ");
      for(int i=0; i<strArr.length && a.length()!=0 && strArr.length>1; i++){
       
          if(!map.containsKey(strArr[i]))
             return;
          else
            System.out.println(strArr[i]);
      }

   
    
    
    for (int i=0; i<lookup.length; i++){
      
      if (lookup[i]!=0){
        
        lookup[i]--;
        findAna(a+(char) i, k+1, lookup, false, map);
        lookup[i]++;
        
        
      }
      
      
      
    }
    
    if(space==false)
      findAna(a+" ", k, lookup, true, map);
       
    
  }
}
