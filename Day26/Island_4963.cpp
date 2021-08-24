#include <iostream>
#define MAX 51

using namespace std;

int w, h, cnt = 0;
int map[MAX][MAX];
int x_move[3] = {-1, 1, 0};
int y_move[3] = {-1, 1, 0};

void DFS(int x, int y)
{
	if(!map[y][x]) return;

	map[y][x] = 0;
	for(int i = 0; i < 3; i++)
	{
		if((y_move[i] + y) >= 0 && (y_move[i] + y < h))
		{
			for(int j = 0; j < 3; j++)
			{
				if(i * j == 4) break;
			
				if((x_move[j] + x) >= 0 && (x_move[j] + x) < w)
				{
					if(map[y_move[i] + y][x_move[j] + x])
						DFS(x_move[j] + x, y_move[i] + y);
				}
			}
		}
	}
}

		
				
		
	
void init()
{
	for(int i = 0; i < MAX; i++)
	{
		for(int j = 0; j < MAX; j++)
		{
			map[i][j] = 0;
		}
	}

	cnt = 0;
}

int main()
{
	int i, j;

	while(1)
	{
		cin >> w >> h;

		if(w + h == 0)
			break;

		for(i = 0; i < h; i++)
		{
			for(j = 0; j < w; j++)
			{
				cin >> map[i][j];
			}
		}


		for(i = 0; i < h; i++)
		{
			for(j = 0; j < w; j++)
			{
				if(map[i][j])
				{
					DFS(j, i);
					cnt++;
				}
			}
		}

		cout << cnt << endl;
		
		init();
	}

	return 0;
}
				
				

			
			

		
		
