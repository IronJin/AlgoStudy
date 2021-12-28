import java.io.*;
import java.util.Arrays;


//5분만에 푼 문제
//문제 정답률을 보고 어렵게 생각하지 말자
public class ranking_2012 {

	public static void main(String[] args) throws NumberFormatException, IOException {
		// TODO Auto-generated method stub
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int n = Integer.parseInt(br.readLine());
		
		int r[] = new int[n+1];
		
		
		for(int i = 1 ; i <=n ; i++) {
			r[i] = Integer.parseInt(br.readLine());
		}
		//-------------입력예제 끝
		
		Arrays.sort(r);
		
		long sum = 0;
		
		for(int i = 1 ; i <= n ; i++) {
			sum += Math.abs(i-r[i]);
		}
		System.out.println(sum);
		
	}

}
