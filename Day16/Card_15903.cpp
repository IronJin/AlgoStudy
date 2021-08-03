#include <iostream>
#include <queue>

using namespace std;
priority_queue<long> pq;

int main()
{
	int n, m;	cin >> n >> m;
		
	int i, input;
	for(i = 0; i < n; i++)
	{
		cin >> input;
		pq.push(-input);
	}

	long sum;
	queue<int>::iterator it;
	for(i = 0; i < m; i++)
	{
		sum = 0;
		sum += pq.top(); pq.pop();
		sum += pq.top(); pq.pop();

		pq.push(sum);
		pq.push(sum);
	}

	sum = 0;
	for(i = 0; i < n; i++)
	{
		sum += pq.top();
		pq.pop();
	}

	cout << -sum;

	return 0;
}

	
	
