#include <iostream>
#include <stack>

using namespace std;

stack<char> S, T;

void reverse()
{
	stack<char> temp;
	
	while(!T.empty())
	{
		temp.push(T.top());
		T.pop();
	}

	T = temp;
}

int main()
{
	char input;
	while(1)
	{
		input = cin.get();
		if(input == '\n') break;

		S.push(input);
	}

	while(1)
	{
		input = cin.get();
		if(input == '\n') break;

		T.push(input);
	}


	while(S.size() < T.size())
	{
		if(T.top() == 'A')
			T.pop();

		else if(T.top() == 'B')
		{
			T.pop();
			reverse();
		}
	}

	while(!S.empty())
	{
		if(S.top() != T.top()) break;

		S.pop();
		T.pop();
	}			

	if(S.empty()) cout << "1";
	else cout << "0";

	return 0;
}

	
		

	
