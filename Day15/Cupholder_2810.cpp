#include <iostream>

using namespace std;

int main()
{
	int N; cin >> N;

	int cnt = 0;
	bool right = false;
	char input;

	while(N--)
	{
		cin >> input;
		
		switch(input)
		{
			case 'S' :
				cnt++;
				break;

			case 'L' :
				cin >> input; N--;
				if(right)	cnt++;
				else {cnt += 2; right = true;}
				break;
		}
	}

	cout << cnt;

	return 0;
}
					
				
