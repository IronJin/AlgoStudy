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
		pq.push(-input);
	}

	int temp, sum = 0;
	while(pq.size() > 1)
	{
		temp = pq.top();
		pq.pop();

		temp += pq.top();
		pq.pop();
		
		sum -= temp;
		pq.push(temp);
	}

	cout << sum;

	return 0;
}	
		
		
		
