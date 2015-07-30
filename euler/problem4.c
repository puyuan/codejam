#include <stdio.h>
#include <string.h>

int palindrome(int num){

  char str[40];
  sprintf(str, "%d", num);
  int len=strlen(str);
  int end=len-1;
  int start=0;

   
  for (start=0; start<end; start++){
    if(str[start]!=str[end])
      return 0;
    end--;
  }

  return 1;
}


int findMaxPalindrome(){

  int firstN=100;
  int secondN=100;
  int max=0;
  for(firstN=100; firstN<1000; firstN++){
    for(secondN=100; secondN<1000; secondN++){
        int sum=firstN*secondN;
        if (palindrome(sum) && sum>max){
          printf("%d x %d = %d \n", firstN, secondN, sum);
          max=sum;
        }

    }
  }
    return max;

}




int main(void) {
	// your code goes here
	
	int result=palindrome(12345);
    printf("%d\n", result);

	result=palindrome(9009);
    printf("%d\n", result);

	result=palindrome(909);
    printf("%d\n", result);

    int max=findMaxPalindrome();
    printf("max palindrome: %d\n", max);




	return 0;
}
