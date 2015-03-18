/*
 * substring.c
 *
 *  Created on: Mar 16, 2015
 *      Author: puyuan
 */

#include <string.h>
#include <stdio.h>
long countSubString(char * str, long max) {
	long numZeros = 0;
	long numOnes = 0;
	char *end = str;
	char *start=str;
	long curCount=0;
	long total=0;

	for( ;start<=end && *start!='\0'; start++){

		for( ;numZeros < max && numOnes < max && *end!='\0'; end++){
			if (*end == '0')
				numZeros++;
			if (*end == '1')
				numOnes++;
			curCount++;
		//	prlongf("%.*s\n",(long)(end-start+1),  start);
		}

		total += curCount;
	//	prlongf("cur count: %d, total: %d\n", curCount, total);
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
    scanf("%d", &numProblems);
    getchar();
    int problemNum;
    for(problemNum=1; problemNum<=numProblems; problemNum++){

        scanf("%d %d %d", &strLength, &max, &numSubProblems);
        getchar();
        char str[strLength+1];
        fgets(str, strLength+1, stdin);
        str[strLength]='\0';
        int subProblemi;
        for (subProblemi=1; subProblemi<=numSubProblems; subProblemi++){
        	long start, end;
        	 scanf("%ld %ld", &start, &end );
        	 getchar();
        	long length=end-start+1;
        	char substring[length+1];
        	strncpy(substring, str+start-1, length);
        	substring[length]='\0';
        	long total=countSubString(substring, max);
        	printf("%ld\n", total);

        }




    }


}


int main() {
	readfile();
	return 0;

}

