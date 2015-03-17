/*
 * substring.c
 *
 *  Created on: Mar 16, 2015
 *      Author: puyuan
 */

#include <string.h>
#include <stdio.h>
int countSubString(char * str, int max) {
	int numZeros = 0;
	int numOnes = 0;
	char *end = str;
	char *start=str;
	int curCount=0;
	int total=0;

	for( ;*start!='\0'; start++){

		for( ;numZeros < max && numOnes < max && *end!='\0'; end++){
			if (*end == '0')
				numZeros++;
			if (*end == '1')
				numOnes++;
			curCount++;
		//	printf("%.*s\n",(int)(end-start+1),  start);
		}

		total += curCount;
	//	printf("cur count: %d, total: %d\n", curCount, total);
		if (*start == '0')
			numZeros--;
		if (*start == '1')
			numOnes--;
		curCount--;


	}

	return total;


}

void readfile(){

    int numProblems, strLength, max, numSubProblems;
    scanf("%d\n", &numProblems);
    int problemNum;
    for(problemNum=1; problemNum<=numProblems; problemNum++){

        scanf("%d %d %d\n", &strLength, &max, &numSubProblems);
        char str[strLength+1];
        fgets(str, strLength+1, stdin);
        str[strLength]='\0';
        int subProblemi;
        for (subProblemi=1; subProblemi<=numSubProblems; subProblemi++){
        	int start, end;
        	 scanf("%d %d\n", &start, &end );
        	int length=end-start+1;
        	char substring[length+1];
        	strncpy(substring, str+start-1, length);
        	substring[length]='\0';
        	int total=countSubString(substring, max);
        	printf("%d\n", total);

        }




    }


}


int main() {
	readfile();
	return 0;

}

