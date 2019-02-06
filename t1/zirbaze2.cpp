#include <bits/stdc++.h>

unsigned short int * b=NULL;

long f(long l, long r)
{
	if(l>r) return 0;
	long sum = 0;
	for(int i =l; i <= r;i++)
		sum+=b[i-1];
	std::cerr << "f(" << l << " , " << r << ") = " << sum << "\n";
	return sum;
}

int main()
{
	int n;
	std::cin>>n;
	//a = new unsigned short int[n];
	int n2 = (n+1)/2;
	b = new unsigned short int[n2];
	for (int i = 0; i < n; i++)
	{
		int t = i;
		int temp;
		if (t>=n2) t = n-i-1;
		std::cin>>temp;
		b[t]+=temp;
	}
	//std::cerr << "input ok\n";
	long sum = 0;
	for (long i = 0; i < n2; i++)
	{
		sum+= (n-i) * (i+1) * b[i];
	//	std::cerr << n-i << "*" << i+1 << "*" << b[i] << '\n';
	}

	std::cout <<sum << "\n";
	return 0;
}
