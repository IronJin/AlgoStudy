#include <iostream>
#include <string>

using namespace std;

int main()
{
	int T; cin >> T;

	string input;

	int ps, left, right, l , r;
	while(T--)
	{
		cin >> input;

		left = 0;
		right = input.length() - 1;

		ps = 0;

		while(left <= right)
		{
			if(input[left] != input[right])
			{
				break;
			}

			left++;
			right--;

		}

		if(left <= right)	//	반례 : baaba
		{
			if(1)
			{
				l = left + 1;
				r = right;

				while(l <= r)
				{
					if(input[l] != input[r])
					{
						ps++;
						break;
					}
					l++; r--;
				}
			}


			if(1)
			{
				l = left;
				r = right - 1;

				while(l <= r)
				{
					if(input[l] != input[r])
					{
						ps++;
						break;
					}
					l++; r--;
				}
			}

			if(ps == 0) ps = 1;	//	반례 : sumumuus
		}

		cout << ps << endl;
	}

	return 0;
}
		
		
