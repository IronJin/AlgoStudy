#include <iostream>
#include <vector>

using namespace std;

int main(){
	
	int T; cin >> T;

	if(T > 20) return -1;
	while(T)
	{
		int N; cin >> N;
		int p_list[N], i;	//	지원자의 서류점수가 Index값이고 면접점수가 배열에 데이터로 저장된 p_list[N]
		for(i = 0; i < N; i++)
		{
			int p_rank; cin >> p_rank;
			cin >> p_list[p_rank - 1];
		}

		int cnt = 0;
		int cutline = N + 1;
		for(i = 0; i < N; i++)
		{
			if(p_list[i] < cutline) {cutline = p_list[i]; cnt++;}
		}

		cout << cnt << endl;

		T--;
	}


	return 0;
}
				
				 	
		
