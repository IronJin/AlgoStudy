#include <iostream>

using namespace std;

int main(){
	
	int N; cin >> N;
	int i;

	long long distance[N - 1], oil_price[N];
	
	long long total_distance = 0;	//	전체 거리
	for(i = 0; i < N - 1; i++)
	{
		cin >> distance[i];
		total_distance += distance[i];
	}
	
	int cheap_city = 0; //	기름값이 제일 저렴한 도시의 번호 저장
	for(i = 0; i < N - 1; i++)
	{
		cin >> oil_price[i];
		if(oil_price[i] < oil_price[cheap_city]) cheap_city = i;
	}

	cin >> oil_price[N - 1];	//	 마지막 종착지의 기름값은 고려할 필요 없으니 따로 처리

	long long total_price = 0;	//	 전체 기름값
	long long min = oil_price[0];	//	현재까지 온 도시 중 가장 저렴한 기름값
	
	for(i = 0; i < cheap_city; i++)	//	기름값이 가장 저렴한 도시에 도착할 때까지
	{
		if(min > oil_price[i]) min = oil_price[i];

		total_price += min * distance[i];	
		total_distance -= distance[i];	//	남은 거리 total_distance에 저장
	}

	total_price += total_distance * oil_price[cheap_city];	//	남은 거리는 제일 싼 기름값으로 이동

	cout << total_price; 

	return 0;
}
		
		



	
