import java.io.*;
import java.util.*;

/*
 word wrap problems,  split line so that endings spaces are evenly distributed
 */

class Solution {
  public static void main(String[] args) {

    String words="Lorem ipsum dolor sit amet, consectetur adipiscing elit. Maecenas et vestibulum mi. Ut non elit sit amet odio varius pulvinar. Duis sed nunc risus. Class aptent taciti sociosqu ad litora torquent per conubia nostra, per inceptos himenaeos. Nunc malesuada turpis lectus, at aliquam augue bibendum et. Nunc interdum posuere magna sit amet sagittis. Quisque cursus congue mauris. Nulla ultrices sollicitudin augue nec ultrices. Etiam vitae efficitur nisi. Ut placerat fringilla augue in mattis. Nulla facilisi. Maecenas ut dolor luctus magna dignissim cursus eu ut augue. Donec venenatis ligula ac diam feugiat semper.Etiam a elementum nibh. Suspendisse potenti. Pellentesque sed rutrum metus. Cras aliquam nisi id tellus faucibus fringilla ut vel est. Nam id metus vitae eros fermentum viverra ut non lacus. Curabitur nec auctor odio, ac viverra justo. Nulla mattis pellentesque blandit. Aliquam eget tempor libero. Nulla at turpis ullamcorper, vestibulum nulla id, gravida enim. Vivamus magna velit, lobortis a neque vitae, malesuada mollis purus. Nunc non lectus facilisis, posuere mauris quis, venenatis turpis.In vel leo pretium, suscipit tortor eu, mollis metus. Mauris et lorem quis lacus interdum consectetur. Nulla ac sollicitudin velit. Mauris ultricies nibh sit amet eros euismod fermentum. Proin sollicitudin elit at accumsan auctor. Vestibulum ex libero, molestie vitae dolor vel, interdum commodo turpis. Donec nec mauris dolor. Integer pretium nulla felis, nec maximus purus pretium at. Suspendisse fermentum, mi ut gravida faucibus, dui magna efficitur sem, ac cursus diam lorem quis tellus. Mauris a magna vitae metus sollicitudin dignissim eu et elit. Aenean sit amet faucibus dui. Pellentesque a viverra leo. Proin arcu enim, sodales vitae vestibulum sagittis, pretium vitae elit. Mauris congue finibus sapien non cursus. Vivamus diam augue, semper imperdiet risus et, varius tincidunt quam. Sed sed velit ipsum. Pellentesque nec pharetra mauris. Nullam sit amet neque ac enim venenatis ornare. Sed id bibendum orci. Pellentesque in leo metus. Phasellus mollis hendrerit rutrum. Nam sed ipsum at risus molestie imperdiet. In tincidunt orci accumsan neque laoreet eleifend id ut mi. Donec erat turpis, placerat quis fringilla at, tincidunt eget magna. Donec faucibus felis sollicitudin maximus porta. Suspendisse id diam luctus, efficitur justo ut, bibendum augue. Vestibulum vehicula neque in felis congue interdum. Etiam eu elit fringilla, finibus ex ut, sollicitudin ipsum. Cras mauris orci, convallis in nulla non, posuere elementum tellus. Proin in congue elit. Praesent nisl magna, dignissim sed vestibulum in, vestibulum vel nunc. Morbi fringilla augue vel dui tempor, et laoreet magna bibendum. Nulla eleifend leo feugiat orci ornare porttitor. Praesent vel rhoncus enim. In hac habitasse platea dictumst. Suspendisse malesuada metus ut lorem accumsan, eu molestie diam scelerisque. Nunc auctor pellentesque massa nec efficitur. Ut pulvinar aliquam vestibulum. Pellentesque viverra, enim eu convallis aliquam, eros eros ullamcorper justo, vel molestie ante ante id leo. Sed nec efficitur risus, sed sollicitudin lorem. Morbi suscipit pretium massa eu sagittis. Sed et volutpat lectus. Suspendisse convallis arcu accumsan ipsum viverra fermentum in nec velit. Cras tempor leo turpis, eget hendrerit augue vestibulum id. Duis et convallis diam, ut molestie arcu. Phasellus et neque commodo nulla porttitor luctus. Proin pellentesque sed ipsum id cursus. In diam nunc, pretium ut lorem vitae, tempus suscipit nisl. Fusce cursus bibendum erat. Etiam sed tortor sit amet ante auctor facilisis sit amet id arcu. Nullam mattis feugiat nisl eu porta. Cras sodales lorem augue, sed lacinia nisi vestibulum sit amet. Aliquam sit amet consectetur nunc. Suspendisse laoreet, leo vitae imperdiet sagittis, lorem ipsum dapibus sapien, ac fringilla massa mi at ex. Cras ut neque dolor. Mauris dictum laoreet urna eget commodo.";
    
    int lineWidth=40;
    
    int segments[]=wordWrap(words, lineWidth);
    
    printSolution(words, segments);
    
  }
  
  
  static void printSolution(String words, int [] segments){
    
    
    String [] wordArr=words.split(" ");
    
    int i=0;
    
    while(i<segments.length){
      
      for(int j=i; j< segments[i]; j++)
        System.out.print(wordArr[j]+" ");
      System.out.println("");
      
      i=segments[i];
      
      
    }
    
    
    
    
  }
  
  public static int [][] computeCostTable(String [] wordArr, int lineWidth){
    
    int numWords=wordArr.length;
    int [][]costTable= new int[numWords][numWords];
    
      for(int i=0; i<numWords; i++){
      
      int curChars=0;
      
      for (int j=i; j< numWords; j++){
        
        
        curChars+=wordArr[j].length();
        
      
        if(lineWidth< curChars)
          costTable[i][j]=Integer.MAX_VALUE;
        else
          costTable[i][j]= (int) Math.pow(Double.valueOf(lineWidth - curChars), 3.0);
        curChars++;
       
      }
      
    }
  //     System.out.println(Arrays.deepToString(costTable));   
   
    return costTable;
    
    
  }
  
  
  public static int [] wordWrap(String words, int lineWidth){
    
    String [] wordArr=words.split(" ");
    
    int numWords=wordArr.length;
    
    
    int [] minCost=new int[wordArr.length];
    int [] segment=new int[wordArr.length];
    int [][] costTable= computeCostTable(wordArr, lineWidth);
    
   /* for (int i=0; i< minCost.length; i++)
      minCost[i]=Integer.MAX_VALUE;
    */
    
    for (int i= numWords-1; i >=0; i--){
      
      int curMinCost=Integer.MAX_VALUE;
      for (int j= numWords -1; j>=i; j--){
        
        if(costTable[i][j]==Integer.MAX_VALUE)
          continue;
        int cost;
        if(j+1>= numWords)
           cost=costTable[i][j];
        else
           cost= costTable[i][j] + minCost[j+1];
        
    
        
        if(cost < curMinCost){
           curMinCost=  cost;
           segment[i]=j+1;
          
        }
                
      }
      
      minCost[i]=curMinCost;
      
     // System.out.println(Arrays.toString(minCost));
   //  System.out.println(Arrays.toString(segment));
      
    }
    
    
    return segment;
    
  }
  
  
}


