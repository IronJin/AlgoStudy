#include <iostream>
#define MAX_R 10001
#define MAX_C 501

using namespace std;

bool visit[MAX_R][MAX_C] = {false}, b;
int cnt = 0, R, C;
int xpos[3] = { -1, 0, 1}; 

bool find(int x, int y)
{
    if(y == C - 1)
    {   
        cnt++;
        return true;
    }   

    for(int i = 0; i < 3; i++)
    {   
        int next_X = x + xpos[i];
        int next_Y = y + 1;  
            
        if(next_Y < C && next_X >= 0 && next_X < R && visit[next_X][next_Y])
        {   
			b = find(next_X, next_Y);
            visit[next_X][next_Y] = false;
			if(b) return true;
        }    
    }   

    return false;
}

        
int main()
{
    cin >> R >> C;

    char input;
    int i, j;
    for(i = 0; i < R; i++)
    {   
        for(j = 0; j < C; j++)
        {   
            cin >> input;

            if(input == '.') visit[i][j] = true; 
        }   
    }   

    for(i = 0; i < R; i++)
    {   
        j = 0;
            
        find(i, j); 
    }   

    cout << cnt;

    return 0;
}
