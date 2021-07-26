#include <iostream>
#include <algorithm>

using namespace std;

int main()
{
	int N, L; cin >> N >> L;

	int i, leak[N];
	for(i = 0; i < N; i++)
	{
		cin >> leak[i];
	}

	sort(leak, leak + N);

	int count = 0, start = -L;
	
	for(i = 0; i < N; i++)
	{
		if(start + L - 1 >= leak[i])
		{
			continue;
		}

		else 
		{
			start = leak[i];
			count++;
		}
	}

	cout << count;

	return 0;
}
				
		
		
		
			 
