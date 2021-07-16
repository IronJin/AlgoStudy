#include <iostream>
#include <vector>
#include <algorithm>

using namespace std;

int main(){
	int n; cin >> n;

	vector<int> ropes;
	for(int i = 0; i < n; i++)
	{
		int input; cin >> input;
		ropes.push_back(input);
	}

	sort(ropes.begin(), ropes.end());	//	 rope의 중량을 오름차순으로 정렬
	
	int max = 0;
	
	vector<int>::iterator it;
	for(it = ropes.begin(); it != ropes.end(); it++)
	{
		if(max < n * (*it)) max = n * (*it);	//	제일 작은 중량 X 줄의 개수
		n--;
	} 

	cout << max;

	return 0;
}
