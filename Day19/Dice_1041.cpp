#include <iostream>
#include <cmath>
#define MAX 51

using namespace std;

int dice[6];
int main()
{
	int N; cin >> N;

	int i, min1 = MAX, m_index;
	for(i = 0; i < 6; i++)
	{
		cin >> dice[i];
		
		if(min1 > dice[i]) 
		{
			min1 = dice[i];
			m_index = i;
		}
	}

	long long sum = 0;

	if(N == 1)
	{
		int max = 0;
		for(i = 0; i < 6; i++)
		{
			sum += dice[i];
			if(max < dice[i]) max = dice[i];
		}
	
		cout << sum - max;

		return 0;
	}
				
	dice[m_index] = 0;
	dice[5 - m_index] = 0;

	int min2 = MAX, m2_index;
	for(i = 0; i < 6; i++)
	{
		if(i != m_index && i + m_index != 5)
		{
			if(min2 > dice[i])
			{
				min2 = dice[i]; 
				m2_index = i;
			}
		}
	}	

	dice[m2_index] = 0;
	dice[5 - m2_index] = 0;

	int min3 = MAX;
	for(i = 0; i < 6; i++)
	{
		if(dice[i])
		{
			if(dice[i] < min3) min3 = dice[i];
		}
	}
			

//		sum += min1 * (pow(N, 3) - pow(N - 2, 2) * (N - 1));  -> 처음 코드

	sum += min1 * (5 * pow(N, 2) - 8 * N + 4);	//	최소 한 면이 밖으로 들어난 큐브의 개수 X min1

	sum += min2 * (N - 1) * 8;	//	최소 두 면이 밖으로 들어난 큐브의 개수 X min2 

	sum += min3 * 4;	//	세 면이 밖으로 들어난 큐븡의 개수 X min3

	cout << sum;

	return 0;
}
