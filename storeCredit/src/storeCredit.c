/*
 ============================================================================
 Name        : storeCredit.c
 Author      : 
 Version     :
 Copyright   : Your copyright notice
 Description : Hello World in C, Ansi-style
 ============================================================================
 */

#include <stdio.h>
#include <stdlib.h>

struct Pair{
	int item1;
	int item2;
};

struct Pair  buyitem(int credit, int * items, int length ){

	int i, j;

	struct Pair pair;
	for (i=0; i< length; i++){
		for (j=1; j<length; j++){
			if(credit==items[i]+items[j]){

				printf("%d\n", items[i]+items[j]);
				pair.item1=i+1;
				pair.item2=j+1;
				return pair;
			}

		}

	}
	return pair;

}


int main(void) {
	int items[]= {5, 75, 25};
	struct Pair pair;
	pair=buyitem(100, items, 3);
	printf("%d %d", pair.item1, pair.item2);

}
