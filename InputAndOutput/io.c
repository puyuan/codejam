/*
 * io.c
 *
 *  Created on: Mar 17, 2015
 *      Author: puyuan
 */

#include <stdio.h>
int main(){
	int num;
	while(1){
	scanf("%d", &num );
	if(num==42 && num<100 & num>-100)
		break;

	printf("%d\n", num);
	}

}
