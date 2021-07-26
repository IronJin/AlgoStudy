#include <iostream>

using namespace std;

int main()
{
	int N, M; cin >> N >> M;

	int x = 0, y = 0, cnt;

	if(N == 1) cnt = 1;

	else if(N == 2) cnt = min((M + 1) / 2, 4);
	
	else if(M < 7) cnt = min(M, 4);
	
	else cnt = 5 + (M - 7);

	cout << cnt;

	return 0;
}
		

	
	
