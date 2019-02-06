#include <bits/stdc++.h>
unsigned short int * a=NULL;

long f(long l, long r)
{
	if(l>r) return 0;
	long sum = 0;
	for(int i =l; i <= r;i++)
		sum+=a[i];
	std::cerr << "f(" << l << " , " << r << ") = " << sum << "\n";
	return sum;
}
int main()
{
	int n;
	std::cin>>n;
	a = new unsigned short int[n+1];
	for (int i = 1; i <= n; i++)
	{
		std::cin>>a[i];
	}
	long sum = 0;
	for (long l = 1; l <= n; l++)
	{
		for (long r = l; r <= n; r++) {
	//		printf("l = %ld , r = %ld\n",l,r );
			sum+= f(l,r);
		}
	}
	std::cout <<sum << "\n";
	return 0;
}
