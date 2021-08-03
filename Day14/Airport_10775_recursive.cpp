#include <iostream>
#define MAX 100000

using namespace std;

int gate[MAX + 1];
bool dock[MAX + 1];

int find(int& a)
{
	if(a != gate[a]) gate[a] = find(gate[a]); 

	return gate[a];
}

int main()
{
	int P, G; cin >> G >> P;

	int input, cnt = 0, i, k;

	for(i = 0; i <= G; i++)
	{
		gate[i] = i;
	}

	bool b = true;
	for(i = 0; i < P; i++)
	{
		cin >> input;

		if(b)
		{
			k = find(input);
			if(k)
			{
				cnt++;
				gate[k] = k - 1;
			}

			else
				b = false;
		}
	}

	cout << cnt;

	return 0;
}

