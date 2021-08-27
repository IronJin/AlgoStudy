#include <iostream>
#define MAX 1000001

using namespace std;

int nums[MAX];

void operation(int N)
{
	if(N % 6 == 0)
		nums[N] = 1 + min(nums[N / 3], nums[N / 2]);

	else if(N % 3 == 0)
		nums[N] = 1 + min(nums[N / 3], nums[N - 1]);

	else if(N % 2 == 0)
		nums[N] = 1 + min(nums[N / 2], nums[N - 1]);
			
	else nums[N] = 1 + nums[N - 1];	
}

int main()
{
	int N; 	cin >> N;
	nums[1] = 0;

	for(int i = 2; i <= N; i++)
	{
		operation(i);
	}

	cout << nums[N];

	return 0;
}
	
	
