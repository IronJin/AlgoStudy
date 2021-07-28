#include <iostream>
#include <algorithm>
#include <queue>

using namespace std;

int main()
{
	int N; cin >> N;

	pair<int, int> time[N];

	int i, j, S, T;
	for(i = 0; i < N; i++)
	{
		cin >> S >> T;
		time[i] = make_pair(S, T);
	}	

	sort(time, time + N);	//	시작시간에 따라 오름차순 정렬

	priority_queue<int> c_end;	//	각 강의실 별 끝나는 시간
	for(i = 0; i < N; i++)
	{
		if(!(c_end.empty()) && -(c_end.top()) <= time[i].first) c_end.pop();	//	제일 빨리 끝나는 강의실의 끝나는 시간 <	현재 탐색중인 강의 시작시간

		c_end.push(-(time[i].second));	
	}

	cout << c_end.size();

	return 0;
}	
