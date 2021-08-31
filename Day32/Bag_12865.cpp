#include <iostream>
#include <vector>

#define MAX_N 101
#define MAX_W 100001

using namespace std;

int N, K;

class Luggage {
 public :
	int weight;
	int price;
	Luggage(int w, int p) {weight = w; price = p;}
};

vector<Luggage> v;
int dp[MAX_N][MAX_W];

void operation(int N)
{
	for(int i = 1; i <= K; i++)
	{
		if(i - v[N].weight >= 0)
			dp[N][i] = max(dp[N - 1][i], dp[N - 1][i - v[N].weight] + v[N].price);
		
		else
			dp[N][i] = dp[N - 1][i];
	}
}
			
int main()
{
	cin >> N >> K;

	int i_w, i_p;
	
	v.push_back(Luggage(0, 0));
	
	for(int i = 1; i <= N; i++)
	{
		cin >> i_w >> i_p;

		v.push_back(Luggage(i_w, i_p));
	}

	for(int i = 1; i <= N; i++)
	{
		operation(i);
	}

	cout << dp[N][K] << endl;

	return 0;
}
