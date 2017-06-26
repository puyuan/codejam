#include <stdio.h>
#include <math.h>
#include <string.h>

int convert2Base10(char * source, int sourceBase){
  int length=strlen(source);
  int sum=0;
  int digit;
  for (digit=0; digit<length; digit++){
       int exponent=(length-1)-digit;
       int base=source[digit]-'0';
       if(base>9)
         base=source[digit]-'7';
       sum+=base*pow(sourceBase, exponent);
    
  }
  printf("%d\n", sum);

  return sum;

}

char * convertBaseTen2Target(int baseTenNumber, int targetBase){
  baseTenNumber/targetBase

}

char * helper

int main(){

   printf("%d\n", convert2Base10("123123", 3));
}
