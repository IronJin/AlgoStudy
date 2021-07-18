import java.io.*;
import java.util.StringTokenizer;


public class gasstation {

	
	//처음에 int 를 썼으나 부분점수를 받아서 long 을 써줌
	//long 의 경우 21억까지의 자리까지 표현하는 int 보다 훨씬 많은 수를 표현할 수 있음
	//int 형은 32비트 long 은 64비트
	//시간복잡도 n
	public static void main(String[] args) throws NumberFormatException, IOException{

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int n = Integer.parseInt(br.readLine());
		//도시 사이의 거리
		long a[] = new long[n-1];
		//도시의 리터당 가격
		long b[] = new long[n];
		StringTokenizer st = new StringTokenizer(br.readLine());
		int j = 0;
		while(st.hasMoreTokens()) {
			a[j] = Integer.parseInt(st.nextToken());
			j++;
		}
		
		j = 0;
		StringTokenizer st1 = new StringTokenizer(br.readLine());
		while(st1.hasMoreTokens()) {
			b[j] = Integer.parseInt(st1.nextToken());
			j++;
		}
		//맨 처음에 min 은 무조건 처음거리만큼 충전해야하니 min 을 첫번째 도시의 기름값으로 표현
		long min = b[0];
		//가격
		long sum = 0;
		
		for(int i = 0 ; i < a.length ; i++) {
			if(min > b[i]) {
				min = b[i];
				sum += a[i] * min;
			}else {
				sum += a[i] * min;
			}
		}
		System.out.println(sum);
		
	}
}
