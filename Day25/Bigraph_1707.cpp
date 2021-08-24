#include <iostream>
#include <vector>
#define MAX_V 20001

using namespace std;

vector<int> vertex[MAX_V];
int visit[MAX_V];

void DFS(int a, int c)
{
	visit[a] = c;

	for(int i = 0; i < vertex[a].size(); i++)
	{
		if(visit[vertex[a][i]] == 0)
			DFS(vertex[a][i], 3 - c);
	}
}		
	
int main()
{
    int K;

	cin >> K;

	while(K--)
	{
        int V, E;
		cin >> V >> E;
        
        for(int i=1; i <= V; i++){
            vertex[i].clear();
            visit[i]=0;
        }
        
		while(E--)
		{
            int input1, input2;
			cin >> input1 >> input2;

			vertex[input1].push_back(input2);
            vertex[input2].push_back(input1);
		}
	
	    
        for(int i = 1; i <= V; i++)
        {
            if(visit[i]==0)
            {
                DFS(i, 1);
            }
        }
        
        bool ps = false;
        for(int i=1; i <= V; i++){
            for(int j = 0; j < vertex[i].size(); j++){
                int k = vertex[i][j];
                if(visit[i] == visit[k])
                    ps = true;
            }
        }
        
		if(ps) cout << "NO" << endl;
		else cout << "YES" << endl;

	}

	return 0;
}

