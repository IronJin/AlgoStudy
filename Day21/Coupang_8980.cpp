#include <iostream>
#include <deque>
#define MAX 2000

using namespace std;

class Box {
 public :
	int from;
	int to;
	int ea;
	Box(int a, int b, int c) {from = a; to = b; ea = c;}	
};
	
bool cmp(Box& a, Box& b)
{
	if(a.to == b.to) return a.from < b.from;
	
	return a.to < b.to;
}

deque<Box> d;
int capacity[MAX];	//	마을과 마을 간 차에 실을 수 있는 상자 수
	
int main()
{
	int N, C; cin >> N >> C;
	int M; cin >> M;

	int i, input1, input2, input3;
	for(i = 0; i < M; i++)
	{
		cin >> input1 >> input2 >> input3;
		d.push_back(Box(input1, input2, input3));
	}

	sort(d.begin(), d.end(), cmp);	//	배송지 번호에 따라 오름차순 정렬

	bool ps;
	int res = 0;
	while(!d.empty())
	{
		ps = true;
		int max_c = 0;
		for(i = d.front().from; i < d.front().to; i++)
		{
			if(capacity[i] == C)
			{
				ps = false;
				break;
			}

			max_c = max(max_c, capacity[i]);	
		}

		if(ps)
		{
			int to_add = min(C - max_c, d.front().ea);	
			for(i = d.front().from; i < d.front().to; i++)
			{
				capacity[i] += to_add;
			}
	
			res += to_add;
		}
	
		d.pop_front();
	}
			 
	cout << res;
		
}
		
