#include <iostream>
#include <vector>

#define DIVIDE 9901

using namespace std;

class Zoo {
 public :
	int empty;
	int n_empty;
	Zoo(int e, int n) { empty = e; n_empty = n; }
};

vector<Zoo> v;

void operation(int N)
{
	Zoo temp = Zoo(0, 0);  
	
	temp.empty = (v[N - 1].empty + v[N - 1].n_empty) % DIVIDE;
	temp.n_empty = ((v[N - 1].empty * 2) + v[N - 1].n_empty) % DIVIDE; 

	v.push_back(temp);
}

int main()
{
	int N; cin >> N;

	v.push_back(Zoo(0, 0));
	v.push_back(Zoo(1, 2));

	for(int i = 2; i <= N; i++)
	{
		operation(i);
	}

	cout << ( v[N].empty + v[N].n_empty ) & DIVIDE << endl;

	return 0;
}

	

	

	
