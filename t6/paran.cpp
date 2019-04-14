#include <bits/stdc++.h>
using namespace std;
std :: string * db;

bool check(int i,int j)
{
	std :: string tot = db[i] + db[j];
	int tp = 0;
	for (int i = 0; i < tot.size(); i++)
	{
		if(tot[i] == '(') tp++;
		if(tot[i] == ')') tp--;		
		if(tp<0) return false;
	}
	return (tp==0);
}

int main()
{
	int n;
	std :: cin >> n;
	db = new std :: string[n];
	
	for(int i = 0; i < n; i++) 
		std :: cin >> db[i];

	int ans = 0;
	for(int i = 0; i < n; i++)
	{
		for(int j=0; j < n; j++)
		{
			ans+=check(i,j);
		}
	}
	std::cout << ans << "\n";
	return 0;
}