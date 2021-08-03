#include <iostream>
#include <vector>
#include <queue>

using namespace std;

int N, K, cnt = 0;
vector<int> plug;
priority_queue<int, vector<int>, greater<int> > pq[101];

bool check(int obj)	//	obj에 해당되는 전기용품이 plug에 꽂혀있으면 true 반환
{
	for(int i = 0; i < plug.size(); i++)
	{
		if(plug[i] == obj) return true;
	}

	return false;
}

int find()	//	뽑아야할 전기용품의 번호 반환
{
	int max = 0, res;
	for(int i = 1; i < K + 1; i++)
	{
		if(check(i))
		{
			if(pq[i].empty())
			{
				return i;
			}

			if(!pq[i].empty() && pq[i].top() > max)
			{
				max = pq[i].top();
				res = i; 
			}
		}
	}

	return res;
}

int index(int obj)	//	obj이 꽃혀있는 plug index를 반환
{
	for(int i = 0; i < plug.size(); i++)
	{
		if(plug[i] == obj) return i;
	}

	return -1;
} 
	

int main()
{
	cin >> N >> K;

	int input[K], i;
	for(i = 0; i < K; i++)
	{
		cin >> input[i];
		pq[input[i]].push(i);
	}

	for(i = 0; i < K; i++)
	{
		if(!check(input[i]))
		{
			if(plug.size() == N) 
			{
				plug.erase(plug.begin() + index(find()));
				cnt++;
			}

			plug.push_back(input[i]); 
			pq[input[i]].pop();
		}

	}

	cout << cnt;

	return 0;
}

				
				
			
		 
		
			
	
