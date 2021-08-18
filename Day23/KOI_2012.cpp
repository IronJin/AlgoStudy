#include <iostream>
#include <cstdlib>
#include <queue>

using namespace std;

priority_queue<int> pq;

int main()
{
	int N; cin >> N;
			
	int input;
	while(N--)
	{
		cin >> input;
		pq.push(input);
	}

	int complain = 0;
	int rank = pq.size();
	
	while(!pq.empty())
	{
		complain += abs(rank - pq.top());
		pq.pop();
		rank--;
	}

	cout << complain << endl;

	return 0;
}
