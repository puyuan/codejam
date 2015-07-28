/*
 * doubleString.c
 *
 *  Created on: Mar 19, 2015
 *      Author: puyuan
 *      http://www.codechef.com/problems/DOUBLE
 */

int main() {

	int numProblems;
	scanf("%d", &numProblems);
	getchar();
	int i;
	for (i = 1; i <= numProblems; i++) {
		long answer;
		scanf("%ld", &answer);
		getchar();
		if(answer%2==1)
			answer--;
		printf("%ld\n", answer);
	}

	return 0;
}
