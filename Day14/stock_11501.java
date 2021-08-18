import java.io.*;
import java.util.StringTokenizer;
public class stock_11501 {

	public static void main(String[] args) throws NumberFormatException, IOException {
		// TODO Auto-generated method stub

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int t = Integer.parseInt(br.readLine());
		
		//테스트 케이스 for문
		for(int z = 0 ; z < t ; z++) {
			//주식배열의 크기 입력
			int n = Integer.parseInt(br.readLine());
			long sto[] = new long[n];
			
			StringTokenizer st = new StringTokenizer(br.readLine());
			for(int i = 0 ; i < n ; i++) {
				sto[i] = Integer.parseInt(st.nextToken());
			}
			
			//앞에서 검사했을때 가장 큰 값이 나오기전까지는 무조건 주식을 모두 사야함
			//따라서 뒤에서부터 검사해야함
			
			//뒤에서 검사했을때 최대가 계산된 후의 최대값을 찾는것이므로 뒤에서부터 검사하는게 맞음
			//초기값을 배열의 맨뒷값이 제일 큰값이라고 가정하고 감
			long max = sto[n-1];
			long answer = 0;
			for(int i = n-2 ; i >= 0 ; i--) {
				//max 값보다 큰 값이 나오는 경우 그냥 바로 max 변수를 바꿔줌
				if(sto[i] > max) {
					max = sto[i];
				//max 가 더 큰경우 max에서 주식가격을 뺀값이 차익임
				}else if(sto[i] < max) {
					answer += max - sto[i];
				}
			}
			
			System.out.println(answer);
			
			
		}//테스트 케이스 하나 끝
		
		
		
	}

}
