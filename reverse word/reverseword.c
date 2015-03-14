/*
 * reverseword.c
 *
 *  Created on: Mar 14, 2015
 *      Author: puyuan
 */

#include <stdio.h>
#include <string.h>

void reverseWord(char * string);
void reverseString(char * string, int start, int end);
void swap(char * string, int i, int j);
void readfile();

int main(){

	char str[]="this is a long length string and should be reversed";

	readfile();

	return 0;
}

void readfile(){

	int numProblems;
	scanf("%d\n", &numProblems);
	int problemNum;
	for(problemNum=1; problemNum<=numProblems; problemNum++){
		char str[1000];
		fgets(str, 1000, stdin);
		str[strlen(str)-1]='\0';
		reverseWord(str);
		printf("Case #%d: %s\n", problemNum, str);



	}


}

void reverseWord(char * string){

	//first iteration, reverse entire string
	reverseString(string, 0, strlen(string)-1);

	// find word'
	int i;
	int length=strlen(string);
	int startWordIndex=0;
	for (i=0; i<length+1; i++){
		if(string[i]==' ' || string[i]=='\0'){
			reverseString(string, startWordIndex, i-1);
			startWordIndex=i+1;
		}

	}


}

void reverseString(char * string, int start, int end){


	int i;

	for (i=start; i< start+(end-start+1)/2; i++){
		int swapindex=end-i+start;
		if(i>swapindex)
			return;
		swap(string, i, swapindex);
	}


}

void swap(char * str, int i, int j){
	char temp=str[i];
	str[i]=str[j];
	str[j]=temp;


}
