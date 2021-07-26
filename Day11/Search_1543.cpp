#include <iostream>
#include <string>

using namespace std;

int main()
{
	string doc; getline(cin, doc);
	string word; getline(cin, word);

	int cnt = 0;
	if(doc.length() >= word.length())
	{
		int check = 0, i;
		for(i = 0; i < doc.length(); i++)
		{
			if(doc[i] == word[check])
			{
				check++;
				if(check == word.length()) {cnt++; check = 0;}
			}
	
			else 
			{
				if(check) {i -= check; check = 0;}
			}
		}
	}

	cout << cnt;

	return 0;
}
