#include <iostream>
#include <algorithm>

using namespace std;

int main()
{
	int N; cin >> N;
	
	int weight[N], i = 0;
	for(i = 0; i < N; i++)
	{
		cin >> weight[i];
	}
	
	sort(weight, weight + N);

	int sum = 0;
	i = 0;
	while(weight[i] < sum + 2 && i < N)
	{
		sum += weight[i++];	
	}

	cout << sum + 1;

	return 0;
}

	
