#include <iostream>
#include <algorithm>
#include <string>

using namespace std;

int main(){
	
	int N; cin >> N;
	
	int ABC[26] = {0}; //	알파벳 26개
	
	int i;

	
	while(N)
	{
		string input; cin >> input;

		int m = 1;
		for(i = input.length() - 1; i >= 0; i--)
		{
			ABC[input[i] - 'A'] += m;
			m *= 10; 
		}
	
		N--;

	}

	sort(ABC, ABC + 26);
	
	int res = 0;
	i = 25;
	while(ABC[i])
	{
		res += ABC[i] * (i - 16);
		i--;
	}

	cout << res;

	return 0;
}
			

	
