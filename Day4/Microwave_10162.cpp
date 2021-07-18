#include <iostream>

using namespace std;

int main()
{
	
	int time[3] = {300, 60, 10};	//	A B C  각 버튼별로 지정된 시간
	int cnt[3] = {0};	//	A B C 각 버튼별로 눌러야 되는 횟수
	
	int t; cin >> t;

	int i = 0;
	while(t && i < 3)
	{
		cnt[i] = (t/time[i]);
		t %= time[i];
		i++;
	}

	if(t) cout << "-1";
	else
	{
		i = 0;
		while(3 - i) cout << cnt[i++] << " ";
	}
	
	return 0;
}

