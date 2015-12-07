import java.io.*;
import java.util.*;

/*
A robot has to move in a grid which is in the form of a matrix. It can go to 
1.) A(i,j)--> A(i+j,j) (Down) 
2.) A(i,j)--> A(i,i+j) (Right) 

Given it starts at (1,1) and it has to go to A(m,n), find the minimum number of STEPS it has to take to get to (m,n) and write 
public static int minSteps(int m,int n) 

For instance to go from (1,1) to m=3 and n=2 it has to take (1, 1) -> (1, 2) -> (3, 2) i.e. 2 steps */

class Solution {
  public static void main(String[] args) {
    
    
   System.out.println( minStep( 10, 11));

  }
  
  static int minStep(int m, int n){
     int dp[][]=new int[m][n];
    
    for(int i=0; i< dp.length; i++){
      
      for (int j=0; j< dp[i].length; j++){
        
        dp[i][j]=Integer.MAX_VALUE;
        
      }
      
    }
    dp[0][0]=0;
    
    return minStepHelper( m, n, dp);
    
  }
  
  
  static int  minStepHelper( int m, int n, int [][]dp){
    
    System.out.format("entering steps, m: %d, n: %d\n", m, n);
    
     if(m<1 || n<1)
       return Integer.MAX_VALUE;
    
      if(dp[m-1][n-1]!=Integer.MAX_VALUE)
        return dp[m-1][n-1];
        
      
        int step1=minStepHelper(  m-n,  n, dp );
        int step2=minStepHelper( m, n-m, dp);
        int minStep=step1<step2? step1: step2;
        minStep++;
    
    System.out.println("minSteps found: "+minStep);
        
    dp[m-1][n-1]=minStep;

    return minStep;
    
  }
  
}
