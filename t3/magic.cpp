#include <bits/stdc++.h>
int main()
{
  std::string s;
  int n =0 ;
  std::cin >> n >> s;
  int* arr = new int[n];
  int sum = 0;
  for (int i = 0; i < n; i++){
    arr[i] = s[i]-'0' ;
    sum+=arr[i];
  }


  int ok = false;

  for (int had =sum-1; had > 0; had--){
    int tSum = 0;
    for(int i = 0; i < n ; i++){
      tSum += arr[i];
      if(tSum > had) break;
      if(tSum == had) tSum = 0;
    }
    if(tSum == had || tSum == 0) ok = true;
  }
  std::cout << (ok?"Yes":"No") << std::endl;
  return 0;
}
