#include <iostream>
#include <algorithm>
#include <deque>
#define MAX 1000

using namespace std;

bool books[MAX + 1];
deque< pair<int, int> > wish_list;
int cnt = 0;

bool compare(pair<int, int>& a, pair<int, int>& b)
{
	if(a.second == b.second) return a.first < b.first;

	return a.second < b.second;
}

void find()
{
	int start = wish_list.front().first;
	int end = wish_list.front().second;

	while(start <= end)
	{
		if(!books[start])
		{
			books[start] = true;
			cnt++;
			break;
		}
	
		start++;
	}

	wish_list.pop_front();
}

int main()
{
	int T, N, M; cin >> T;

	int input1, input2;
	while(T--)
	{
		cin >> N >> M;

		while(M--)
		{
			cin >> input1 >> input2;

			wish_list.push_back( make_pair(input1, input2) );
		}

		sort(wish_list.begin(), wish_list.end(), compare);

		while(!wish_list.empty())
		{
			find();
		}

		cout << cnt << endl;

		while(N)
		{
			books[N--] = false;
		}

		cnt = 0;
	}

	return 0;
}

		
	

		

			

			
	
