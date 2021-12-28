import java.io.*;

public class bj2839 {

	public static void main(String[] args) throws NumberFormatException, IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	
		int  a = Integer.parseInt(br.readLine());
		
		//해당 숫자에서 5킬로그램 설탕 봉지를 최대한 많이 가져갈때의 값
		int n = a/5;
		// 봉지의 개수를 더해서 넣어줄 변수 설정
		int count = 0;
		//최대부터 0개까지 반복문을 돌림
		for(int i = n ; i >= 0 ; i--) {
			//주어진 설탕을 반복할때마다 사용해줘야 하기때문에 y에 값을 넣음
			int y = a;
			//주어진 설탕에서 5킬로 설탕 봉지 개수만큼 빼주고 남은것을 3으로 나눠서 안나눠지면 -1 할당
			y = y - 5*i;
			if(y%3 != 0) {
				count = -1;
				//나누어지면 그게 5킬로그램 최대 봉지를 가질 수 있는 개수이므로 그때의 봉지개수인 i와
				//3으로 나누었을때의 몫(봉지 개수)를 더해주면 됨
			}else {
				count = i+y/3;
				//for문 조건을 만족하지 못하도록 하여 for문 탈출
				i = -1;
			}
		}
		
		System.out.println(count);
		
	}

}
