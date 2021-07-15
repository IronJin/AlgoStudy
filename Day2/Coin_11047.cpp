#include <iostream>
#include <vector>

using namespace std;

int main(){
	int n, k;
	cin >> n >> k;

	vector<int> coins;
	int input;

	while(n)
	{
		cin >> input;
		coins.push_back(input);
		n--;
	}

	
	int min = 0;
	vector<int>::iterator it = coins.end();	// 액수가 큰 동전부터 순환
	while(k)	// k = 0 일 때까지 반복
	{
		it--;	// 작은 액수의 동전으로 이동 
		min += k/(*it);	
		k = k % (*it);	//	남은 액수를 k에 다시 반환 후 반복
	}

	cout << min;
		
	return 0;
}
