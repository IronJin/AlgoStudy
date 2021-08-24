#include <iostream>
#include <vector>

using namespace std;

class Flower {
	int s_month, s_day;
	int e_month, e_day;
	Date(int sm, int sd, int em, int ed) { s_month = sm; s_day = sd; e_month = em; e_day = ed;}
};

int months[13] = {0, 31, 28, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31};
vector<Flower> v;

int main()
{
	int N; cin >> N;

	int input1, input2, input3, input4;
	while(N--)
	{
		cin >> input1 >> input2 >> input3 >> input4;

		if(input1 <= 2) {input1 = 3, input2 = 1;}
		if(input3 >= 12) {input3 = 11, input4 = months[11];}
		v.push_back(Date(input1, input2, input3, input4));
	}
}

		

