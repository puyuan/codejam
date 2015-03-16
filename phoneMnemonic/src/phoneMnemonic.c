/*
 ============================================================================
 Name        : phoneMnemonic.c
 Author      : 
 Version     :
 Copyright   : Your copyright notice
 Description : Hello World in C, Ansi-style
 ============================================================================
 */

#include <stdio.h>
#include <stdlib.h>
#include <string.h>


const char *mnemonic[]={"0", "1", "ABC", "DEF", "GHI", "JKL", "MNO", "PQRS", "TUV", "WXYZ"};


void recurse(char * number, char * result, int pos){

	if(pos==strlen(number)){
        result[pos]='\0';
		puts(result);
		return;
	}
	int index=number[pos]-'0';
	const char *table=mnemonic[index];
	int i=0;
	for(i=0; i< strlen(table); i++){
	   char tmp[50];
	   strcpy(tmp, result);
	   tmp[pos]=table[i];
	   recurse(number, tmp, pos+1);

	}

}


void PrintAllMnemonic(char * number){

	char result[50];
	recurse(number, result, 0);

}




int main(void) {
	PrintAllMnemonic("1237892343456756756756565757567");

	return EXIT_SUCCESS;
}
