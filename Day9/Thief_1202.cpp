#include <iostream>
#include <algorithm>
#define MAX 100000000	

using namespace std;

bool desc(pair<int, int> a, pair<int, int> b)
{
	return a.first > b.first;
} 
	
int main()
{
	int N, K, i; cin >> N >> K;

	pair<int, int> MV[N];	
	for(i = 0; i < N; i++)
	{
		cin >> MV[i].second >> MV[i].first;	//	pair<가격, 무게>
	}

	int C[K];
	for(i = 0; i < K; i++)
	{
		cin >> C[i];
	}

	sort(C, C + K);
	sort(MV, MV + N, desc); 

	int bag = 0;
	long money = 0;
	for(i = 0; bag < K; i++)
	{
		if(MV[i].second <= C[bag])
		{
			bag++;
			money += MV[i].first;
			MV[i].second = MAX;
			i = -1;
		}
	}

	cout << money;

	return 0;
}	
		
