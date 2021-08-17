#include <iostream>
#include <queue>

using namespace std;


int main()
{
	int N; cin >> N;
	priority_queue<int> pq;

	int input;
	while(N--)
	{
		cin >> input;
		pq.push(input);
	}

	int day = 1;
	int res = 0;
	while(!pq.empty())
	{
		res = max(pq.top() + day, res);
		pq.pop();
		day++;
	}
		
	cout << ++res;

	return 0;
}	
