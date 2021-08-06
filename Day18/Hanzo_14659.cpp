#include <iostream>
#include <queue>

using namespace std;

int main()
{
	int N; cin >> N;
	queue<int> q;
	
	int input;
	while(N--)
	{
		cin >> input;
		q.push(input);
	}

	int start = q.front();
	q.pop();

	int ans = 0, kill = 0;
	while(!q.empty())
	{
		if(start < q.front())
		{
			ans = max(ans, kill);

			kill = 0;
			start = q.front();
		}

		else
		{
			kill++;
		}

		q.pop();

		if(q.empty()) ans = max(ans, kill);
	}

	cout << ans;

	return 0;
}

		
			

		
		
		
		
