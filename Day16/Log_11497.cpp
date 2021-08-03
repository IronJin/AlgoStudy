#include <iostream>
#include <queue>

using namespace std;


int main()
{
	int T, N, i, input, left, right, diff; 

	cin >> T;
	
	while(T--)
	{
		cin >> N;

		priority_queue<int> pq;

		for(i = 0; i < N; i++)
		{
			cin >> input;
			pq.push(-input);
		}	

		left = pq.top(); pq.pop();
		right = pq.top(); pq.pop();

		diff = left - right;
		for(i = 0; i < (N - 2) - (N - 2) % 2; i++)
		{
			if(left - pq.top() > diff) diff = left - pq.top();
			left = pq.top();
			pq.pop();

			if(right - pq.top() > diff) diff = right - pq.top();
			right = pq.top();
			pq.pop();
		}

		if(pq.empty())
		{
			if(left - right > diff) diff = left - right;
		}

		else 
		{
			if(left - pq.top() > diff) diff = left - pq.top();
			pq.pop();
		}
			

		cout << diff << endl;

		pq.clear();
	}

	return 0;
}
			
			
		
		
	
		


		
