/*
 ============================================================================
 Name        : DutchNationalFlag.c
 Author      : 
 Version     :
 Copyright   : Your copyright notice
 Description : Hello World in C, Ansi-style
 ============================================================================
 */

#include <stdio.h>
#include <stdlib.h>

// move i and j both forward

void partition(char * str, char pivot){

	int length=strlen(str);
	int i=0;
	int j=1;
	for(i=0; i<=length; i++){


		if(str[i] < pivot){
			j++;
			continue;
		}

		printf("i=%d, j=%d\n", i, j);

		for (; j<=length; j++){
			if(str[j]<=pivot)
				break;
		}
		if (j==length)
			break;
		swap(str, i , j );
		j++;

	}

}

void swap(char * str, int i, int j){

	char temp=str[j];
	str[j]=str[i];
	str[i]=temp;

}

int main(void) {

	char str[]="12345678901234567890";

    partition(str, '4');
	puts("!!!Hello World!!!"); /* prints !!!Hello World!!! */
	printf("%s\n", str);
	return EXIT_SUCCESS;
}
