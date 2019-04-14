#include <bits/stdc++.h>

std :: string * db;

bool check(int i,int j)
{
	std :: string tot = db[i] + db[j];
	return true;
}

int main()
{
	int n;
	std :: cin >> n;
	db = new std :: string[n];
	int ans = 0;
	for(int i = 0; i < n; i++) 
		std :: cin >> db[n];
	for(int i = 0; i < n; i++)
	{
		for(int j=0; j < n; j++)
		{
			ans+=check(i,j);
		}
	}
	return 0;
}