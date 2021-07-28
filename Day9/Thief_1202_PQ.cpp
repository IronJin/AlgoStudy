#include <iostream>
#include <queue>
#include <algorithm>

using namespace std;

int main()
{
	int N, K, i; cin >> N >> K;

	pair<int, int> MV[N];	
	for(i = 0; i < N; i++)
	{
		cin >> MV[i].first >> MV[i].second;	
	}

	int C[K];
	for(i = 0; i < K; i++)
	{
		cin >> C[i];
	}

	sort(C, C + K);
	sort(MV, MV + N); 

	long money = 0;
	priority_queue<int> pq;

	
	int j = 0;
	for(i = 0; i < K; i++)
	{
		for(; j < N; j++)
		{
			if(C[i] >= MV[j].first)
				pq.push(MV[j].second);

			else break;
		}

		if(!pq.empty())
		{
			money += pq.top();
			pq.pop();
		}

	}

	cout << money;

	return 0;
}	
		
