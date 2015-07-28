/*
 * candle.c
 *
 *  Created on: Mar 23, 2015
 *      Author: puyuan
 *      http://www.codechef.com/problems/CANDLE
 */

#include <stdio.h>
#include <string.h>
#include <stdlib.h>

int leastNumber(char * candles){
	int length=10;
	int i=0, min=10000, minIndex=0;
	int leastNum=0;

	int * candlesArr=malloc(sizeof(int)*length);
	//convert string to int array
	for (i=0; i<length; i++){
		candlesArr[i]=candles[2*i]-'0';
	}

	i=0;
	while (min!=0 ){
		if (i==0 && leastNum==0 ){
		    i++;
			continue;
		}
		if(candlesArr[i]<min ){
			min=candlesArr[i];
			minIndex=i;

		}



		if(i==length-1 || min==0){
			leastNum=leastNum*10+minIndex;
			candlesArr[minIndex]--;
			i=0;

		}else{

		i++;
		}



	}
	return leastNum;

}


int main(){

	//leastNumber("1 3 3 3 3 3 3 3 3 1");

	int numProblems;
	char * str;
	scanf("%d\n", &numProblems);
	int i=0;
	for(i=0; i< numProblems; i++){
		int nbytes=100;
		str=malloc(nbytes+1);
		fgets(str, nbytes, stdin);
		int leastNum=leastNumber(str);
		printf("%d\n", leastNum);

	}



}

