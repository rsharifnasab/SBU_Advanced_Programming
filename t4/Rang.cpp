#include <bits/stdc++.h>
int main()
{
	long m,n,k;
	std:: cin >> n >> m >> k;

	srand(time(0));
	int r = rand()%n*m;
	std:: cout << r << std::endl;
	return 0;
}
