#include <iostream>

using namespace std;

int main()
{
	int P, G; cin >> G >> P;
	
	int i, gate[G + 1], cnt = 0;
	bool dock[G + 1];

	for(i = 0; i <= G; i++)
	{
		gate[i] = i;
	}
		
	int input;
	bool b = false;
	for(i = 0; i < P; i++)
	{
		cin >> input;
		
		if(!b)
		{
			while(dock[input])
			{
				input--;
			}

			if(input <= 0) b = true; 
			else
			{
				dock[input] = true;
				cnt++;
			}
		}
	}

	cout << cnt;

} 
