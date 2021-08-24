#include <iostream>
#define MAX_V 20001
#define MAX_E 200001

bool vertex[MAX_V][MAX_E];
int visit[MAX_V];

using namespace std;

int K, V, E, input1, input2;
int group = 0;
bool ps = false;

void DFS(int a)
{
	visit[a] = ++group;
	cout << "a : " << a << " group : " << group << endl;
	group %= 2;

	for(int i = 1; i <= V; i++)
	{
		if(visit[i] == 0 && vertex[a][i])
			DFS(i);

		else if(a != 1 && visit[i] > 0)
		{
			if((group + 1) != visit[i])
			{
				ps = true;
				cout << "i : " << i << endl;
			}
		}

		if(ps) break;
	}
}

void init()
{
	for(int i = 0; i < MAX_V; i++)
	{
		visit[i] = false;
	}
}
				
	
int main()
{
	cin >> K;

	while(K--)
	{
		cin >> V >> E;

		while(E--)
		{
			cin >> input1 >> input2;

			vertex[input1][input2] = vertex[input2][input1] = true;
		}
	
		DFS(1);

		if(ps) cout << "NO" << endl;
		else cout << "YES" << endl;

		init();
	}

	return 0;
}

			


