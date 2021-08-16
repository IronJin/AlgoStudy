#include <iostream>
#include <list>
#include <algorithm>

using namespace std;

bool desc(int a, int b)
{
	return a > b;
}

int main()
{
	int N; cin >> N;

	int crains[N];
	list<int> box;

	int i;
	for(i = 0; i < N; i++)
	{
		cin >> crains[i];
	}

	sort(crains, crains + N, desc);

	int M; cin >> M;

	while(M--)
	{
		cin >> i;
		box.push_back(i);
	}

	box.sort(desc);

	if(crains[0] < box.front())
	{
		cout << "-1";
		
		return 0;
	}


	int cnt = 0;
	list<int>::iterator it;
	while(!box.empty())
	{
		it = box.begin();
		cnt++;	

		for(i = 0; i < N; i++)
		{
			if(crains[i] >= *it)
			{
				it = box.erase(it);
	
				if(box.empty()) break;
			}
		}
	}

	cout << cnt;
}
