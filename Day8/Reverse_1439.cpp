#include <iostream>

using namespace std;

int main()
{
	char first; cin >> first;	//	최초 입력값

	char input;
	int cnt = 0;

	cin.get(input);	//	다음 값 입력
	while(input != '\n')	//	문자열이 끝날 때까지
	{
		if(input != first)	//	입력값이 이전값과 다를 경우
		{
			cnt++;	//	카운트+ 1
			first = input;	//	이전값 변경	
		}

		cin.get(input);
	}

	cout << (cnt / 2) + (cnt % 2);	//	cnt가 중복추가 되었으므로 최종처리

	return 0;
}
		
