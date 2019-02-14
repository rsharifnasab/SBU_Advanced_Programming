#include <bits/stdc++.h>
struct W
{
  int index;
  double value;
};

bool compare2a(W a,W b)
{
  return a.value>b.value;
}

int main()
{
  int m,n;
  int *db;
  std::cin >> m;
  db = new int[m];
  W * db2 = new W[m];
  for (int i = 0; i < m; i++)
  {
    std::cin >> db[i];
    db2[i].value = (double) (db[i] / (i+1.0));
    db2[i].index = i;
  }
  std::cin >> n;
  //for (int i = 0; i < m; i++)
  //  std::cerr << db2[i].index << " " << db2[i].value << "\n";
  std::cerr << " - - - - -  \n \n";
  std::sort(db2,db2+m,compare2a);
  for (int i = 0; i < m; i++)
    std::cerr << "tool:"<<db2[i].index+1 << " v:" << db2[i].value << "\n";
  long int ans = 0;
  int here = 0;
  while (n>0)
  {
    W t = db2[here];
    int index= t.index;
    long int value= db[index];
    int tool = index+1;
    if (n >= tool)
    {
      n-= tool;
      std::cout << tool << " ";
      ans+=value;
    }
    else
    {
      std::cerr << tool <<" passed\n";
      here++;
    }
  }
  std::cout << "\n" << ans << "\n";

  return 0;
}
