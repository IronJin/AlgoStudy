import java.io.*;
import java.util.StringTokenizer;

public class a_to_b_16953 {

	public static void main(String[] args) throws IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		StringTokenizer st = new StringTokenizer(br.readLine());

		int a = Integer.parseInt(st.nextToken());
		int b = Integer.parseInt(st.nextToken());
		
		int count = 0;
		
		//b가 a보다 작아지거나 같아지거나 더이상 안나누어질때까지 반복
		while(a<b) {
			count++;
			//마지막 숫자가 1인경우 그것을빼주고 10만큼 나눠준 몫을 b에 저장
			if(b%10 == 1) {
				b = b/10;
			//홀수인경우 빠져나와야함
			}else if(b%2 == 1) {
				break;
			//그냥 나눠지는 경우에는 2를 나눠줌
			}else {
				b= b/2;
			}
		}
		
		//홀수인경우 빠져나와서도 같을수있거나 반복문을 빠져나온 경우
		if(a==b) {
			System.out.println(count+1);
		//홀수인 경우 빠져나오거나 2로 나누어주었는데 그보다 더 낮아지면 도달할수 없는 값
		}else {
			System.out.println(-1);
		}
	}

}
