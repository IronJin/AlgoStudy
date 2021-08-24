#include <iostream>
#include <vector>
#include <algorithm>

using namespace std;

int main()
{
	int N; cin >> N;
	
	vector<int> v;
	int input;
	while(N--)
	{
		cin >> input;
		v.push_back(input);
	}

	sort(v.begin(), v.end());

	N = v.size();
	if(N % 2 == 0) N--;

	cout << v[N / 2] << endl;

	return 0;
}
