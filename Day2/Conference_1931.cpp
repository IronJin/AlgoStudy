#include <iostream>
#include <vector>
#include <algorithm>

using namespace std;

class Conf {
 public :
	int begin;
	int end;
	Conf(int a, int b) { begin = a; end = b; }
};

bool compare(Conf* a, Conf* b)
{
	if(a -> end == b -> end) return (a -> begin < b -> begin); 	// 회의 종료 시간이 같은 경우 -> 일찍 시작하는 회의가 우선순위
	else return (a -> end < b -> end);	// 일찍 끝나는 회의가 우선순위
}



int main(){
	int n; cin >> n;
	vector<Conf *> time_table;


	int input1, input2;
	while(n)
	{
		cin >> input1 >> input2;
		time_table.push_back(new Conf(input1, input2));
		n--;
	}

	sort(time_table.begin(), time_table.end(), compare);	// 회의가 일찍 끝나는 순서대로 정렬

	int sum = 0, end_t = 0;	// 마지막 회의가 끝나는 시간을 end_t로 설정
	vector<Conf *>::iterator it;
	for(it = time_table.begin(); it != time_table.end(); it++)
	{
		if((*it) -> begin >= end_t) // iterator의 회의 시작 시간이 end_t보다 뒤일 경우 
		{
			end_t = (*it) -> end;	// end_t는 iterator의 회의 끝나는 시간
			sum++;	//	 회의가 1개 추가되었으므로 sum +1
		}
	}
	
	cout << sum;

	return 0;
}

	
		
		

	
