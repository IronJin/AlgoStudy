#include <iostream>
#include <vector>

using namespace std;

long fibonacci(long n1, long n2) 
{
    return n1 + n2; 
}   

int main()
{
    int T; cin >> T;

    int N;
    vector<long> v;  
    vector<long> res;
    while(T--)
    {   
        cin >> N;
    
        v.push_back(0);

        int i = 0;
        long sum = 1;

        while(sum <= N)
        {   
            v.push_back(sum);
            sum = fibonacci(v[i], v[i + 1]);
            i++;
        }   

        while(N)
        {   
            while(v.back() > N)
            {   
                v.pop_back();
            }   

            res.push_back(v.back());
            N -= v.back();
            v.pop_back();
        }   

        while(!res.empty())
        {   
            cout << res.back() << " ";
            res.pop_back();
        }   

        cout << endl;
        v.clear();
    }   

    return 0;
}
