#include <iostream>
#include <string>

using namespace std;

char UCPC[4] = {'U', 'C', 'P', 'C'};

bool pos(string s)
{
	int index = 0;
	for(int i = 0; i < s.length(); i++)
	{
		if(s[i] == UCPC[index])
		{
			index++;
		}

		if(index == 4) break;
	}

	if(index == 4) return true;
	else return false; 
}

int main()
{
	string input;
	getline(cin, input);

	if(pos(input)) cout << "I love UCPC";
	else cout << "I hate UCPC";

	return 0;
}

	

