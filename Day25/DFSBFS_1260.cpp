#include <iostream>
#include <queue>
#define MAX_N 1001
#define MAX_M 10001

using namespace std;

int N, M, V;
bool vertex[MAX_N][MAX_M];
bool visit[MAX_N];

void DFS(int a)
{
	visit[a] = true;
	cout << a << " ";

	for(int i = 1; i <= N; i++)
	{
		if(!visit[i] && vertex[a][i])
			DFS(i);
	} 
}

queue<int> q;
void BFS(int a)
{
	visit[a] = true;
	q.push(a);

	while(!q.empty())
	{
		cout << q.front() << " ";
		
		for(int i = 1; i <= N; i++)
		{
			if(!visit[i] && vertex[q.front()][i])
			{
				q.push(i);
				visit[i] = true;
			}
		}
	
		q.pop();
	}
}

void init()
{
	for(int i = 0; i < MAX_N; i++)
	{
		visit[i] = false;
	}
}
	

int main()
{
	cin >> N >> M >> V;

	int input1, input2;
	while(M--)
	{
		cin >> input1 >> input2;

		vertex[input1][input2] = true;
		vertex[input2][input1] = true;
	} 

	DFS(V);

	cout << endl;
	init();

	BFS(V);

	return 0;
}
		
		
		

	
