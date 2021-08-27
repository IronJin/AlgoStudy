#include <iostream>
#include <vector>
#include <string>

using namespace std;

int N, K;
bool visit[26];
vector<string> v; 

int res = 0;

void DFS(int index, int cnt)
{
	if(cnt == K)
	{

		int t_cnt = 0;

		for(int i = 0; i < v.size(); i++)
		{
			string cur = v[i];
			bool ps = false;
			for(int j = 0; j < cur.length(); j++)
			{
				if(!visit[cur[j] - 'a'])
				{
					ps = true;
					break;
				}
			}
			
			if(!ps) 
				t_cnt++;
		}

		res = max(res, t_cnt);
	}

	else
	{
		for(int i = index; i < 26; i++)
		{
			if(!visit[i])
			{
				visit[i] = true;
				DFS(i, cnt + 1);
				visit[i] = false;
			}
		}
	}
}
			
	

int main()
{
	bool p = false;
	cin >> N >> K;

	if(K < 5) 
	{
		cout << res << endl;
		p = true;
	}

	else if(K == 26)
	{
		cout << N << endl;
		p = true;
	}


	string temp = "antic";
	for(int i = 0; i < temp.length(); i++)
	{
		visit[temp[i] - 'a'] = true;
		K--;
	}

	string input;
	while(N--)
	{
		cin >> input;
		input = input.substr(4, input.length() - 8);

		v.push_back(input);
	}


	if(!p)	DFS(0, 0);		
		
	cout << res << endl;
	return 0;
}

	
		

	
