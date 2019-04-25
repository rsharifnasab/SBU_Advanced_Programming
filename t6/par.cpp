#include <bits/stdc++.h>
int counter(std::string tot){
	int tp = 0;
	for (long i = 0; i < (long)tot.size(); i++){
		if(tot[i] == '(') tp++;
		if(tot[i] == ')') tp--;		
	}
	return (tp);
}
bool isValidFirst(std::string sub){   // ((((((())((
	int tp = 0;
	for(int i = 0; i < (int)sub.size(); i++){
		if (sub[i] == '(') tp++;
		if (sub[i] == ')') tp--;
		if (tp < 0) return false;
	}
	return true;
}
bool isValidLast(std::string sub){ // ))))(())))
	int tp = 0;
	for(int i = 0; i < (int) sub.size(); i++){
		if (sub[i] == '(') tp++;
		if (sub[i] == ')') tp--;
		if (tp > 0) return false;
	}
	return true;
}

const int max = 3e5;
int main(){
	int n;
	std :: cin >> n;

	std::string* db = new std::string[n];

	int* cal = new int[2*max +1];
	for(int i = 0 ; i < 2*max+1; i++) cal[i] = 0;
	cal -= max;

	for(int i = 0; i < n; i++){
		std :: string s;
		std :: cin >> s;
		int t = counter(s);
		if(t ==0) cal[0]++;
		else if (t > 0  && isValidFirst(s) ) cal[t]++;
		else if (t < 0  && isValidLast(s)  ) cal[t]++;
	}
	int ans = 0;

	std::cout << ans << "\n";
	return 0;
}