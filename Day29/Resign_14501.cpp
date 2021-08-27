#include <iostream>
#include <vector>

using namespace std;

class Counsel {
 public :
	int period;
	int pay;
	Counsel(int a, int b) { period = a; pay = b;}
};

vector<Counsel> v;
int res = 0;

void DFS(int a, int sum)
{
	sum += v[a].pay;	
	if(sum > res) res = sum;

	for(int i = a + v[a].period; i < v.size(); i++)
	{
		if(i + v[i].period > v.size()) continue;
		else DFS(i, sum);
	}
}	
	
int main()
{
	int N; cin >> N;

	int i1, i2;
	while(N--)
	{
		cin >> i1 >> i2;
		v.push_back(Counsel(i1, i2));
	}

	for(int i = 0; i < v.size(); i++)
	{
		if(i + v[i].period <= v.size()) 
			DFS(i, 0);
	}
	

	cout << res << endl;

	return 0;
}
