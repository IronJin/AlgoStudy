#include <iostream>

using namespace std;

int main()
{
	int N; cin >> N;

	int score[N], i;
	for(i = 0; i < N; i++)
	{
		cin >> score[i];
	}

	int cnt = 0;
	for(i = N - 2; i >= 0; i--)
	{
		if(score[i] >= score[i + 1])
		{
			cnt += (score[i] - score[i + 1] + 1);
			score[i] = score[i + 1] - 1; 
		}
	}

	cout << cnt;

	return 0;
}
		
