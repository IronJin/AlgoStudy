#include <iostream>
#include <cstdlib> 
#define MAX 20

using namespace std;

int ary[MAX][MAX];
bool visit[MAX];

int N;
int res = 100 * (MAX / 2) * (MAX - 1);

void divide_team(int a, int cnt)
{
	if(cnt == (N / 2))
	{
		int sum = 0;
		for(int i = 0; i < N; i++)
		{
			for(int j = 0; j < N; j++)
			{
				if(visit[i] && visit[j])
					sum -= ary[i][j];	
			
				else if(!visit[i] && !visit[j])
					sum += ary[i][j];
			}
		}

	 	if(abs(sum) < res) res = abs(sum);
	}

	else
	{
		for(int i = a; i < N; i++)
		{
			if(!visit[i])
			{
				visit[i] = true;
				divide_team(i, cnt + 1);
				visit[i] = false;
			}
		}
	}

	visit[a] = false;
}

int main()
{
	cin >> N;
	
	for(int i = 0; i < N; i++)
	{
		for(int j = 0; j < N; j++)
		{
			cin >> ary[i][j];
		}
	}

	divide_team(0, 0);

	cout << res << endl;

	return 0;
}


	

	

		

		
