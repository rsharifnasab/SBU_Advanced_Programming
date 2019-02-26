#include <bits/stdc++.h>
int main()
{
  std::string s;
  int size =0 ;
  std::cin >> size >> s;
  int* arr = new int[size];
  for (int i = 0; i < size; i++)
    arr[i] = s[i]-'0' ;

  int max = size -1;
  int ok = false;
  for (int i = max; i > 0; i--)
  {
    for

  }
  std::cout << ok?"Yes":"No" << std::endl;
  return 0;
}
