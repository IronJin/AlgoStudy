#include <iostream>
#include <vector>
#include <string>
#include <sstream>

using namespace std;

int main(){
	string input; getline(cin, input);
	bool flag = false;	// buffer의 숫자를 더할지 뺄지 결정
	string buffer;
	int res = 0;
	
	for(int i = 0; i <= input.size(); i++)
	{
		if(input[i] == '+' || input[i] == '-' || i == input.size())	// 연산자이거나 연산식의 끝일 경우
		{
			if(flag) res -= stoi(buffer);	// flag가 -일 경우 : buffer의 값을 뺌
			else res += stoi(buffer);	// flag가 +일 경우 : buffer의 값을 더함

			buffer = "";

			if(input[i] == '-') flag = true;	// '-' 기호가 오면 flag를 -로
		}

		else	//	 피연산자의 경우
		{
			buffer += input[i];	//	buffer에 추가
		}

	}

	cout << res;

	return 0;
}
			
	
