#include <bits/stdc++.h>

unsigned long long pow2(unsigned long int y)
{
    if(y == 0)
        return 1;
    unsigned long long temp = pow2(y/2);
    if (y%2 == 0)
        return temp*temp;
    else
        return 2*temp*temp;
}

int * scores;
int SIndex = 0;
int *db;
int m,n;

void Sclear()
{
  for (int i = 0; i < m; i++)
    scores[i] = -1;
  SIndex = 0;
  return;
}
void wood()
{
  long long max = 0;
  int cut_count = n-1;
  unsigned long long tt = pow2(cut_count+1);
  for(unsigned long long i = 0; i < tt; i++)
  {
    long long value = 0;
    long t = i;
    int temp = 0;
    while(t>0)
    {
      if (t%2==0)
        temp++;
      if (t%2==1)
      {
        value+=db[temp];
        temp = 0;
      }
      t/=2;
    }
    if (max<value)
    {
      max = value;
      t = i;
      Sclear(); //scores.clear();
      while(t>0)
      {
        if (t%2==0)
          temp++;
        else
        {
          scores[SIndex]=(temp+1);
          SIndex++;
          temp = 0;
        }
        t/=2;
      }
    }
  }
  std::cerr << "maax is ";
  std::cout << max << "\n";
  for (int i = 0; i < m; i++)
    if(scores[i] > -1) std::cout << scores[i] <<" ";

}



int main()
{

  std::cin >> m;
  db = new int[m];
  scores = new int[m];
  for (int i = 0; i < m; i++)
    std::cin >> db[i];
  std::cin >> n;
  wood();

  return 0;
}
