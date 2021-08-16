#include <iostream>
#include <queue>
#define MAX 1000

using namespace std;

int main()
{
	int N; cin >> N;

	int i;

	int input1, input2;
	priority_queue<int> p_inputs[MAX + 1];
	
	int max = 0;
	for(i = 0; i < N; i++)
	{
		cin >> input1 >> input2;

		if(max < input1) max = input1;
		p_inputs[input1].push(input2);	//	남은 일수를 index, 점수를 data로 priority queue 배열에 push
	}

	priority_queue<int> res;
	for(i = 1; i <= max; i++)	//	일수가 적게 남은 과제들부터 탐색
	{
		if(!p_inputs[i].empty()) 
		{
			while(!p_inputs[i].empty() && res.size() < i)	//	해당 일수의 과제들을 전부 탐색했거나 res가 꽉 찰때까지 결과값에 push 
			{
				res.push(-p_inputs[i].top());
				p_inputs[i].pop();
			}

			while(!p_inputs[i].empty() && p_inputs[i].top() > -res.top())	//	해당 일수의 과제들을 아직 전부 탐색을 하지 않았다면 -> 결과값들중 최소 점수인 과제와 비교해서 더 점수가 높은 과제들을 swap
			{
				res.pop();
				res.push(-p_inputs[i].top());
				p_inputs[i].pop();
			}
		}
	}

	int sum = 0;
	while(!res.empty())
	{
		sum -= res.top();
		res.pop();
	}

	cout << sum;

	return 0;
}
	

	
	 
		
			
