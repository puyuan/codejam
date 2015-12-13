1. The number of valid combinations of a strings for given input array a[], where a=>1, z => 26, and 0 <= a[i] <= 9

{1,1,1} => {aaa, ak, ka} => 3
{1,1,0} => {aj} => 1
  
  // {1,5,6,2}
  
 int [] a= {1, 1, 1};

a,   index,   solution   number             sum
      0          "a"        1
      1          "aa"       1
      2          "aaa"      1
      3                          return 1
      2                                      1   
      1         "ak"
      3                           return 1
  
  

int combinations (int[] a) {
  
  if(a.length==0)
    return 0;
  
  return combinationsHelper(a, 0);
  

}

int combinationsHelper(int [] a, int index){
  
  if(index==a.length){
    //return a solution
    return 1;
    
  }  
      int sum=0;
    // generate candidates
    
    // looking at 1 numbers
      int number=a[i];
  
      if(number>=1 && number <=9 )
         sum+=combinationsHelper( a, index+1);
  
    // looking at 2 numbers
      if(i+1 < a.length){
       number=a[i]*10+a[i+1];
        
       if(number <=26){
         sum+=combinationHelper(a, index+2);
       }   
         
      }


  return sum;
  
}

