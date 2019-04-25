#include <bits/stdc++.h>
int counter(std::string tot){
	int tp = 0;
	for (long i = 0; i < (long)tot.size(); i++){
		if(tot[i] == '(') tp++;
		if(tot[i] == ')') tp--;		
	}
	return (tp);
}

bool zeroCheck(std::string tot){
	int tp = 0;
	for (long i = 0; i < (long)tot.size(); i++){
		if(tot[i] == '(') tp++;
		if(tot[i] == ')') tp--;		
		if(tp < 0) return false;
	}
	return true;
}

void eraseAllSubStr(std::string & mainStr, const std::string & toErase)
{
	size_t pos = std::string::npos;
	// Search for the substring in string in a loop untill nothing is found
	while ((pos  = mainStr.find(toErase) )!= std::string::npos)
	{
		// If found then erase it from string
		mainStr.erase(pos, toErase.length());
	}
}

std::string cleaner(std::string inp){
	std::string ans = "";
	ans = inp;
	eraseAllSubStr(ans,"()");
//	std::cerr << inp << " claned to: " << ans << std::endl;
	return ans;
}

bool isValidFirst(std::string sub){   // ))(((((((((
	for(int i = 0; i < (int)sub.size(); i++){
		if (sub[i] == ')') return false;
	}
//	std::cerr << sub << " is valif for first\n"; 
	return true;
}

bool isValidLast(std::string sub){ // )))))))      // )
	for(int i = 0; i < (int) sub.size(); i++){
		if (sub[i] == '(') return false;
	}
//	std::cerr << sub << " is valif for last\n"; 
	return true;
}

const int max = 3e5 + 20;
int main(){
	int n;
	std :: cin >> n;
	int* cal = new int[2*max +1];
	for(int i = 0 ; i < 2*max+1; i++) 
		cal[i] = 0;
	cal += max;

	for(int i = 0; i < n; i++){
		std :: string s;
		std :: cin >> s;
		std :: string old;
		s = cleaner(s);
		int t = counter(s);
		if(t ==0 && zeroCheck(s)) cal[0]++;
		else if (isValidFirst(s)) cal[t]++;
		else if (isValidLast(s)) cal[t]++;
	}
	int ans = 0;
	for(int i = 0; i < max; i++){
//		if(cal[i] !=0 || cal[-i] != 0) std::cerr<< " i :" << i << " cal[i]:" << cal[i] << " cal[-i]: " << cal[-i] << std::endl;
		ans+=(cal[i]*cal[-1*i]);
	}
	std::cout << ans << "\n";
	return 0;
}