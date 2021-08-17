#include <iostream>
#include <deque>

using namespace std;

int main()
{
	int N, M; cin >> N >> M;
	int J; cin >> J;

	int input;
	deque<int> d;
	while(J--)
	{
		cin >> input;
		d.push_back(input);
	}

	int move;
	int res = 0;
	int pos = 0; 
	while(!d.empty())
	{
		if(d.front() > pos + M)
		{
			move = d.front() - (pos + M);
			res += move;
			pos += move;
		}

		else if(d.front() <= pos)
		{
			move = (pos - d.front() + 1);
			res += move;
			pos -= move;
		}

		d.pop_front();
	}
			
	cout << res;

	return 0;
}
