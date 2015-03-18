int main(){

	int withdrawal;
	double balance;
	scanf("%d %lf", &withdrawal, &balance);
	getchar();

	if(withdrawal%5!=0 || withdrawal+0.5>balance)
		printf("%.2lf\n", balance);
	else{
		printf("%.2lf\n", balance-withdrawal-0.5);

	}

	return 0;


}
