#include <bits/stdc++.h>
int main()
{
	long n;
	std:: cin >> n;
	int m;
	for(int i = 0; i < n; i++) std:: cin >> m;
	srand(time(0));
	int r = rand()%n;
	std:: cout << r << std::endl;
	return 0;
}
