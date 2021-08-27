#include <iostream>
#include <vector>

#define HOW_M 6

using namespace std;

vector<int> nums;
vector<int> temp;

int k, input;

void print()
{
	for(int i = 0; i < temp.size(); i++)
	{
		cout << temp[i] << " ";
	}

	cout << endl;
}
	

void DFS(int index)
{
	if(temp.size() == HOW_M)
		print();

	else
	{
		for(int i = index; i < nums.size(); i++)
		{
			temp.push_back(nums[i]);
			DFS(i + 1);
			temp.pop_back();
		}
	}
}
		
	
int main()
{

	while(1)
	{
		nums.clear();

		cin >> k;
		if(k == 0) break;

		int input;
		for(int i = 0; i < k; i++)
		{
			cin >> input;
			nums.push_back(input);
		}

		DFS(0);

		cout << endl;
	}
}

			
			

		
		
	
