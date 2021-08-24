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

int x_move[4] = {0, 1, 0, -1};
int y_move[4] = {-1, 0, 1, 0};

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
		t_cnt--;

		cout << "Tomato count : " << t_cnt << endl;
		for(int i = 0; i < 4; i++)
		{
			int n_x = curT.x + x_move[i];
			int n_y = curT.y + y_move[i];

			if(inTheScope(n_x, n_y) && box[n_x][n_y] == 0)
			{
				q.push(Tomato(n_x, n_y));
				box[n_x][n_y] = box[curT.x][curT.y] + 1;

				if(days < box[n_x][n_y]) days = box[n_x][n_y];
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
			
			if(box[i][j] >= 0) t_cnt++;
			if(box[i][j])
				q.push(Tomato(j, i));

		}
	}


	BFS();

	cout << t_cnt << endl;
	if(t_cnt) cout << "-1";
	else cout << days;

	return 0;
}

	

	
