/*
 ============================================================================
 Name        : ATOI.c
 Author      : 
 Version     :
 Copyright   : Your copyright notice
 Description : Hello World in C, Ansi-style
 ============================================================================
 */

#include <stdio.h>
#include <stdlib.h>



int convertCharacter(char character){
	return character-'0';
}

int convertStringToInt(char * str){
	int strLength=strlen(str);
	int result=0;
	int i;
	for (i=0; i<strLength; i++){
		result*=10;
		result+=convertCharacter(str[i]);
	}

	return result;

}


int main(void) {
	int result=convertStringToInt("12345012");
	printf("%d\n", result);
	return 0;

}
