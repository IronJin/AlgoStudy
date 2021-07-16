#include <iostream>
#include <vector>
#include <string>
#include <sstream>

using namespace std;

vector<string> split(string str, char delimiter)
{
	vector<string> res;
	stringstream ss(str);
	string temp;
	
	while(getline(ss, temp, delimiter))
	{
		res.push_back(temp);
	}

	return res;
}
	

int main(){
	string input; getline(cin, input);
	vector<int> s_nums;

	vector<string> minus = split(input, '-');	//	'-' 기호로 연산식을 나눔
	vector<string>::iterator it1;
	for(it1 = minus.begin(); it1 != minus.end(); it1++)	
	{
		int sum = 0;
		vector<string> plus = split(*it1, '+');	//	'-'로 나눠진 각 파트를 '+'로 나눔
		vector<string>::iterator it2;
		for(it2 = plus.begin(); it2 != plus.end(); it2++)
		{
			sum += stoi(*it2);	//	'+'로 나눠진 숫자들을 합함
		}
		s_nums.push_back(sum);
	}

	int res = s_nums[0];	//	첫번째 s_num은 +
	vector<int>::iterator it3;
	for(it3 = s_nums.begin() + 1; it3 != s_nums.end(); it3++)
	{
		res -= (*it3);	//	나머지 s_num은 -
	}

	cout << res;
	
	return 0;
}
	
	
