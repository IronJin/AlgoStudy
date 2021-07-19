#include <iostream>

using namespace std;

int main(){
	
	int s; cin >> s;

	int sum = 0, cnt = 0;
	while(sum + cnt + 1 <= s)
	{
		cnt++;
		sum += cnt;
	}

	cout << cnt;

	return 0;
}

