#include <iostream>
#include <vector>
#include <algorithm>

using namespace std;

int main(){
	int n; cin >> n;
	int sum = 0;
	
	vector<int> people;
	int input;

	for(int i = 0; i < n; i++) 
	{
		cin >> input;
		people.push_back(input);
	}

	sort(people.begin(), people.end());

	vector<int>::iterator it;
	for(it = people.begin(); it != people.end(); it++)	sum += ((n--) * (*it));

	cout << sum << endl;

	return 0;
}
