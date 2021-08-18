#include <iostream>
#include <stack>

using namespace std;

int main()
{
    int T; cin >> T;

    int N;
        
    stack<int> s;
    long long profit, max, cnt;
    while(T--)
    {   
        cin >> N;

        int input;
        while(N--)
        {   
            cin >> input;
            s.push(input);
        }   

        profit = 0;

        max = 0;
        cnt = 0;
        while(!s.empty())
        {   
            if(s.top() > max)
            {   
                profit += (max * cnt);
                max = s.top();
                cnt = 0;
            }   

            else
            {   
                cnt++;
                profit -= s.top();
            }   

            s.pop();
        }   

        profit += (max * cnt);
            
        cout << profit << endl;
    }   

    return 0;
}
