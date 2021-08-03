#include <iostream>
#include <string>
#include <vector>

using namespace std;


vector<int> nums;
string input; 
int main()
{
	int N, K, i; cin >> N >> K;

	cin >> input;

	i = 0;
	nums.push_back(input[i++] - '0');

	for(; i < N; i++) 
	{
		if(K && input[i] - '0' > nums.back())
		{
			while(K && !nums.empty() && nums.back() < input[i] - '0')
			{
				nums.pop_back();
				K--;
			}
		}

		nums.push_back(input[i] - '0');
	}

	for(i = 0; i < K; i++)
	{
		nums.pop_back();
	}

	for(i = 0; i < nums.size(); i++)
	{
		cout << nums[i];
	}

}

	
