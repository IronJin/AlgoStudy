#include <iostream>

using namespace std;

int main(){
	int m_list[] = {500, 100, 50, 10, 5, 1};	// 거스름돈 리스트
	int price; cin >> price;

	if(price < 1000)
	{
		int cnt = 0;
		int change = 1000 - price;

		for(int i = 0; i < 6; i++)
		{
			cnt += (change / m_list[i]);	//	m_list[i] 화폐로 거스러줄수 있는 갯수 count 
			change %= m_list[i];	// m_list[i] 화폐로 거슬러주고 남은 금액을 change에 반환
		}

		cout << cnt;
	}

	return 0;
}
			
			
		
		
		
