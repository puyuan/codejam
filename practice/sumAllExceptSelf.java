

import java.util.*;
import java.lang.*;
import java.io.*;

/* Name of the class has to be "Main" only if the class is public. */
class Ideone
{
	public static void main (String[] args) throws java.lang.Exception
	{
		// your code goes here
		int [] sourceArr={1,2,3,4,5};
		int dest[]=new int[5];
		int multiplier=1;
		dest[0]=1;
		for (int i=1; i< sourceArr.length; i++){
			multiplier*=sourceArr[i-1];
			dest[i]=multiplier;
			
		}
		multiplier=1;
		for (int i=sourceArr.length-2; i>=0; i--){
			multiplier*=sourceArr[i+1];
			dest[i]*=multiplier;
		}
		for (int i=0; i<dest.length; i++)
		  System.out.println(String.valueOf(dest[i])+'\n');
	}
}