#include <iostream>

using namespace std;

int main(){
	int T; cin >> T;
	
	int x, y;
	while(T)
	{
		cin >> x >> y;
		int k = y - x;	//	x와 y 사이의 거리
		
		int sum = 0;


		/* 모든 숫자는 1 2 3 4 5 4 3 2 1 이나 1 2 3 4 5 5 4 3 2 1이나 1 2 3 4 5 5 5 4 3 2 1 같이 대칭 형태로 표현할 수 있음
			
			이런 대칭을 정렬해서 표현하면 1 1 2 2 3 3 + 4 4 + 5 , 1 1 2 2 3 3 4 4 + 5 5, 1 1 2 2 3 3 4 4 + 5 5 + 5 와 같이 표현됨.

		*/

		int i = 1;
		while(k / i > 1)
		{
			sum += 2;
			k -= 2 * i;
			i++;
		}

		if(k / i == 1)
		{
			sum++;
			k -= i;
		}

		if(k) sum++;

		
		cout << sum << endl;
		
		T--;
	}

	return 0;
}
			
