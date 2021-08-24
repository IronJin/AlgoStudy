#include <iostream>
#include <queue>
#include <deque>
#include <algorithm>

using namespace std;

class Lecture {
 public :
	int deadline;
	int pay;
	Lecture(int p, int d) { deadline = d; pay = p; }
};

deque<Lecture> d;

bool cmp(Lecture& a, Lecture& b)
{
	if(a.deadline == b.deadline) return a.pay > b.pay;

	return a.deadline > b.deadline;
}

int main()
{
	int n; cin >> n;

	int input1, input2;
	
	while(n--)
	{
		cin >> input1 >> input2;
		d.push_back( Lecture(input1, input2) );
	}

	sort(d.begin(), d.end(), cmp);

	int sum = 0;
	priority_queue<int> pq;
	for(int i = d.front().deadline; i > 0; i--)
	{
		while(d.front().deadline == i)
		{
			pq.push(d.front().pay);
			d.pop_front();
		}

		if(!pq.empty())
		{
			sum += pq.top();
			pq.pop();
		}
	}

	cout << sum << endl;

	return 0;
}
		
	


