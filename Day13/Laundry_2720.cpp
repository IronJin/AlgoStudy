#include <iostream>

using namespace std;

int money[4] = {25, 10, 5, 1};

int main()
{
	int T; cin >> T;

	int C;
	while(T--)
	{
		cin >> C;

		for(int i = 0; i < 4; i++)
		{
			cout << C / money[i] << " ";
			C %= money[i];
		}

		cout << endl;
	}

	return 0;
}

		
		
