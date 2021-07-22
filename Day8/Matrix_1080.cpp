#include <iostream>

using namespace std;

int m, n, cnt = 0;
bool matrix[50][50];

// 행렬의 값들을 뒤집는 함수
void swap(int x, int y)
{
	for(int k = 0; k < 9; k++)
	{	
		if(matrix[x + k / 3][y + k % 3]) matrix[x + k / 3][y + k % 3] = false;
		else matrix[x + k / 3][y + k % 3] = true;
	}

	cnt++;
}

// 두 행렬이 같으면 false, 다르면 true 반환
bool check()
{
	for(int i = 0; i < m * n; i++)
	{
		if(matrix[i / n][i % n]) return true;
	}

	return false;
}
	

int main()
{
	cin >> m >> n;

	char input;
	int i;
	
	// 첫번째 행렬 입력
	for(i = 0; i < m * n; i++)
	{	
		cin >> input;

		if(input == '0') matrix[i / n][i % n] = false;
		else if(input == '1') matrix[i / n][i % n] = true;
		else i--; 
	}

	// 두 행렬을 비교했을때 다른 부분을 true로, 같으면 false로 배열에 저장
	for(i = 0; i < m * n; i++)
	{	
		cin >> input;

		if(input == '0') continue;
		else if(input == '1')
		{
			if(matrix[i / n][i % n]) matrix[i / n][i % n] = false;
			else matrix[i / n][i % n] = true;
		}
		else i--; 
	}


	
	//	행렬의 크기가 3 X 3 보다 크면
	if(m >= 3 && n >= 3)
	{
		
		// swap할 수 있는 범위 내에서 탐색
		for(i = 0; i < (m - 2) * (n - 2); i++)
		{
			// 값이 true면 해당값을 좌측 최상단으로 설정해 3 X 3 범위 swap
			if(matrix[i / (n - 2)][i % (n - 2)]) swap(i / (n - 2), i % (n - 2));
		}
	}

	// 크기가 3 X 3 보다 작거나 swap 범위를 전부 탐색한 후 확인
	if(check()) cnt = -1;		

	cout << cnt;


	return 0;
}
