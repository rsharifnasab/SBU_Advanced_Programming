#include <bits/stdc++.h>
int counter(std::string tot){
	int tp = 0;
	for (long i = 0; i < tot.size(); i++){
		if(tot[i] == '(') tp++;
		if(tot[i] == ')') tp--;		
	}
	return (tp);
}

bool check(std::string tot){
		int tp = 0;
		for (long i = 0; i < tot.size(); i++){
			if(tot[i] == '(') tp++;
			if(tot[i] == ')') tp--;		
			if(tp < 0) return false;
		}
		return (tp==0);
}

int main(){
	int n;
	std :: cin >> n;
	int* cal = new int[n];
	std::string* db = new std::string[n];
	for(int i = 0; i < n; i++){
		std :: cin >> db[i];
		cal[i] = counter(db[i]);
	}
	int ans = 0;
	for(int i = 0; i < n; i++){
		for(int j=0; j < n; j++){
			if ( (cal[i]+cal[j])==0){
				ans+=(check(db[i]+db[j]));
			}
		}
	}
	std::cout << ans << "\n";
	return 0;
}