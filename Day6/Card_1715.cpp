#include <iostream>
#include <algorithm>
#define MAX 1000000

using namespace std;

int cards[MAX];


int main(){

	int N;	
	cin >> N;
	
	int i;
	for(i = 0; i < N; i++)
	{
		cin >> cards[i];
	}


	sort(cards, cards + N);

	int temp, index, sum = 0;
	for(i = 0; i < N - 1; i++)
	{
		cards[i + 1] += cards[i];

		temp = cards[i + 1], index = i + 1;
		while(index + 1 < N && temp > cards[index + 1])
		{
			cards[index] = cards[index + 1];
			index++;	
		}

		sum += temp;
		cards[index] = temp;
			 
	}

	cout << sum;
	
	return 0;
}
		
