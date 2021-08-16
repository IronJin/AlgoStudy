#include <iostream>
#include <string>

using namespace std;

string res;
int main()
{
	int cnt = 0, i;
	bool ps = false;
	char input;
	while(1)
	{
		input = cin.get();
		if(!ps)
		{
			if(input == '.' || input == '\n')
			{
				for(i = 0; i < cnt / 4; i++)
				{
					res += "AAAA";
				}

				cnt = cnt % 4;
				for(i = 0; i < cnt / 2; i++)
				{
					res += "BB";
				} 

				cnt = cnt % 2;
				if(cnt) ps = true;
				else if(input == '.') res += ".";
			}
			else cnt++;
		}

		if(input == '\n') break;

	}

	if(ps)
		cout << "-1";

	else
		cout << res;


	return 0;
}

	
