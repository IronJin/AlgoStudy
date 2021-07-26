#include <iostream>

using namespace std;

int main()
{
	int A, B; cin >> A >> B;
	
	int res = 0;

	while(A < B)
	{	
		if(B % 2 == 0)
		{
			B /= 2;
			res++;	
		}

		else if(B % 10 == 1)
		{
			B /= 10;
			res++;
		}
		
		else break;
	}	

	if(A != B) res = -2;
	cout << res + 1;

	return 0;
}
		
