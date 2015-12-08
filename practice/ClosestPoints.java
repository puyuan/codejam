import java.io.*;
import java.util.*;


/*
Write a function that takes the following inputs and gives the following outputs. 

Input: A list of points in 2-dimensional space, and an integer k 
Output: The k input points closest to (5, 5), using Euclidean distance 


Example: 

Input: {(-2, -4), (0, 0), (10, 15), (5, 6), (7, 8), (-10, -30)}, k = 2 
Output: {(5, 6), (7, 8)}
 */


class PointComparitor implements Comparator<Point>{
    
    @Override
    public int compare(Point a, Point b){
       Point reference=new Point(5, 5);
      double distA=calcDistance(a, reference);
      double distB=calcDistance(b, reference);
      
      return distA < distB? -1: distA > distB? 1: 0;
      
      
    }
  
    static double calcDistance(Point a, Point b){
    
    return Math.sqrt(Math.pow(a.x-b.x, 2)+Math.pow(a.y-b.y, 2));
    
    
    }
    
  }

class Solution {
  public static void main(String[] args) {
  
    ArrayList <Point> points=new ArrayList<Point>();
    points.add(new Point(-2,-4));
    points.add(new Point(0, 0));
    points.add(new Point(10, 15));
    points.add(new Point(5, 6));
    points.add(new Point(7, 8));
    points.add(new Point(-10, -30));
               
    closestPoints(points, 2);
    
    
  }
  
  
  
  static void closestPoints (ArrayList <Point> points, int k){
    
   
    
    double [] distances=new double[points.size()];
    
    int i=0;
  
    
    Collections.sort(points, new PointComparitor());
    

    for( i=0; i<k; i++)
      System.out.println(points.get(i).x);

    
  }
  

  
}


 class Point{
  int x;
  int y;
    
    public Point(int x, int y){
    this.x=x;
    this.y=y;
    
  }
  
  
}

/* 
Your previous Go content is preserved below:


 */