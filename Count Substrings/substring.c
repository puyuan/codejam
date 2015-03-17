/*
 * substring.c
 *
 *  Created on: Mar 16, 2015
 *      Author: puyuan
 */

#include <string.h>
int countSubString(char * str, int max) {
	int length = strlen(str);
	int numZeros = 0;
	int numOnes = 0;
	char *end = str;
	char *start=str;
	int curCount=0;
	int total=0;

	while (*end != '\0' && *start != '\0') {

		if (numZeros < max && numOnes < max) {
			if (*end == '0')
				numZeros++;
			if (*end == '1')
				numOnes++;
			printf("%.*s\n",(int)(end-start+1),  start);
			curCount++;

			end++;
			continue;
		}


		total+=curCount;
		printf("cur count: %d, total: %d\n", curCount, total);
		if (*start == '0')
			numZeros--;
		if (*start == '1')
			numOnes--;
		curCount--;
		start++;


	}

}

int main() {
	countSubString("00110011000",  5);
	return 0;

}

