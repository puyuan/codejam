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


   int graph[][] = {{0, 4, 0, 0, 0, 0, 0, 8, 0},
   {4, 0, 8, 0, 0, 0, 0, 11, 0},
   {0, 8, 0, 7, 0, 4, 0, 0, 2},
   {0, 0, 7, 0, 9, 14, 0, 0, 0},
   {0, 0, 0, 9, 0, 10, 0, 0, 0},
   {0, 0, 4, 0, 10, 0, 2, 0, 0},
   {0, 0, 0, 14, 0, 2, 0, 1, 6},
   {8, 11, 0, 0, 0, 0, 1, 0, 7},
   {0, 0, 2, 0, 0, 0, 6, 7, 0}
 };


 shortestPath(graph);


}




static void shortestPath(int [][] graph){

  int numV=graph.length;

  int [][]distance= new int [numV][numV];
  int [] visited= new int[numV];


  for(int i=0; i< numV; i++)
    for (int j=0; j<numV; j++)
      distance[i][j]=Integer.MAX_VALUE;
    
    int v=0;
    
    visited[0]=0;
    distance[0][0]=0;
    
    
    
    int minNode= 0;
    int minDistance=0;
    while(minNode!=-1){


     System.out.format("minNode: %d, minDistance: %d \n", minNode, minDistance);  

      // add reachable nodes
     for (int i=0; i< numV; i++){

      if(visited[i]==0 && graph[minNode][i]!=0)
        distance[minNode][i]= minDistance+graph[minNode][i];


    }

     // System.out.println(Arrays.deepToString(distance));

    visited[minNode]=1;

    minDistance=Integer.MAX_VALUE;
    minNode=-1;
    
    for(int i=0; i< numV; i++){

      for (int j=0; j<numV; j++){

        if(visited[j]==0 &&   distance[i][j] <minDistance){

          minDistance= distance[i][j]; 
          minNode=j; 
        }
        
      }

    }


  }
}
}


