#include <bits/stdc++.h>
int main()
{
	long m,n,k;
	std:: cin >> n >> m >> k;
	for(int i =0; i < n; i++) std::cin>>k;
	srand(time(0));
	int r = rand()%n+1;
	std:: cout << r << std::endl;
for(int i = 0; i < n; i++)
{
	r = rand()%n+1;
	std:: cout << r << " ";
}
	std:: cout << std::endl;
	return 0;
}
