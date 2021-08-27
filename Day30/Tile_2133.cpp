#include <iostream>
#define MAX 31

using namespace std;

int ary[MAX];

void operation(int N)
{
	if(N >= 2)
		ary[N] += (ary[N - 2] * ary[2]);

	for(int i = 0; i <= N - 4; i += 2)
	{
		ary[N] += ary[i] * 2;
	}
}
	 
int main()
{
	int N; cin >> N;

	ary[0] = 1;
	ary[2] = 3;

	for(int i = 3; i <= N; i++)
	{
		if(i % 2 == 0) operation(i);
	}

	cout << ary[N] << endl;

	return 0;
} 
		

