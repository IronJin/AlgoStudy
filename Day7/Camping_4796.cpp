#include <iostream>

using namespace std;

int main()
{
	int L, P, V, res, i = 1;

	while(1)
	{
		cin >> L >> P >> V;
	
		if(!(L + P + V)) break;

		res = 0;
		res += (V / P) * L;
	
		if(L >= V % P) res += (V % P);
		else res += L; 

		cout << "Case " << i++ << ": " << res << endl;
	}

	return 0;
} 

		

		
