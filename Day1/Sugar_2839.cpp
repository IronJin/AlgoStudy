#include <iostream>

using namespace std;

int main(){
	
	int n;	 cin >> n;
	
	int min = 0;	// 출력할 봉지의 개수
	int k = n / 5;	// 5kg 봉지 최대값
	
	while(k >= 0)
	{
		if((n - k * 5) % 3 == 0) break; // 전체 무게에서 5kg 봉지들의 무게를 뺏을때 3kg 봉지들로 나눌 수 있는지
		else k--; // 불가능하면 5kg 봉지의 수를 -1
	}

	if(k < 0) min = -1; // 불가능하면 -1 출력
	else min = k + (n - k * 5) / 3; // 가능하면 최솟값 출력

	cout << min << endl;

	return 0;
}
