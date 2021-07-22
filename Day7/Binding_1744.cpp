#include <iostream>
#include <algorithm>

using namespace std;

int main()
{
	int N; cin >> N;
	
	int sequence[N];
	for(int i = 0; i < N; i++)
	{
		cin >> sequence[i];
	}

	sort(sequence, sequence + N);

	int sum = 0, start = 0;
	while(sequence[start + 1] <= 0)	//	음수끼리 곱하면 양수가 되므로 최대한 음수끼리 곱해서 더해주기
	{
		sum += (sequence[start] * sequence[start + 1]);
		start += 2;
	}

	
	int end = N - 1;
	while(sequence[end - 1] > 1)	//	1이 아닌 양수끼리 곱해서 더해주기
	{
		sum += (sequence[end] * sequence[end - 1]);
		end -= 2;
	}

	while(start <= end)	//	남은 0이나 1 더해주면서 마무리
	{
		sum += sequence[start++];
	}

	cout << sum;

	return 0;
}
			
		
		 

	
		
