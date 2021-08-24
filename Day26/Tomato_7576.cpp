#include <iostream>
#include <queue>
#define MAX 1001

using namespace std;

class Tomato {
 public :
	int x;
	int y;
	Tomato(int x, int y) { this -> x = x; this -> y = y;}
};

int M, N;
int t_cnt = 0, days = 0;
int box[MAX][MAX];

int x_move[4] = {1, 0, -1, 0};
int y_move[4] = {0, 1, 0, -1};

queue<Tomato> q;

bool inTheScope(int x, int y)
{
	return (x >= 0 && x < M && y >= 0 && y < N);
}

void BFS()
{
	while(!q.empty())
	{
		Tomato curT = q.front();
		q.pop();
		
		for(int i = 0; i < 4; i++)
		{
			int n_x = curT.x + x_move[i];
			int n_y = curT.y + y_move[i];

			if(inTheScope(n_x, n_y) && box[n_y][n_x] == 0)
			{
				q.push(Tomato(n_x, n_y));
				box[n_y][n_x] = box[curT.y][curT.x] + 1;

                t_cnt--;

				if(days < box[n_y][n_x]) days = box[n_y][n_x];
			}
		}
	}
}
	
int main()
{
	cin >> M >> N;

	for(int i = 0; i < N; i++)
	{
		for(int j = 0; j < M; j++)
		{
			cin >> box[i][j];
			
			if(box[i][j] == 0) t_cnt++;
			if(box[i][j] == 1)
				q.push(Tomato(j, i));

		}
	}


	BFS();

	if(days) days--;

	if(t_cnt) cout << "-1";
	else cout << days;
	

	return 0;
}

