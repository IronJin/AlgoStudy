#include <iostream>
#include <vector>
#include <queue>
#include <algorithm>

using namespace std;

int main()
{
	int N, K; cin >> N >> K;

	if(K >= N)	//	집중국 개수 > 센서의 개수 이면 답은 0
	{
		cout << 0;

		return 0;
	}

	priority_queue<int> pq;
	vector<int> v;

	int input;
	while(N--)
	{
		cin >> input;
		v.push_back(input);
	}

	sort(v.begin(), v.end());	//	센서들을 거리순으로 정렬
	
	int dist = v.back() - v.front();	//	첫번쨰 센서 - 마지막 센서까지 거리

	for(int i = 0; i < v.size() - 1; i++)
	{
		pq.push(v[i + 1] - v[i]);	//	센서 간의 거리를 내림차순으로 정렬
	}

	while(--K)
	{
		dist -= pq.top();	//	센서 간 거리가 가장 먼 부분을 K - 1개 dist에서 뺴줌 
		pq.pop();
	}

	cout << dist;

	return 0;
}

			
