import java.io.*;
import java.util.StringTokenizer;

public class chess_1783 {

	public static void main(String[] args) throws IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int n = Integer.parseInt(st.nextToken());
		int m = Integer.parseInt(st.nextToken());
		int count = 1;
		//세로길이 1이면 못움직임
		if(n == 1) {
		//세로길이 2인경우
		}else if(n == 2) {
			if(m < 3) {
			}else if(m>=3 && m<5) {
				count++;
			}else if(m>=5 && m< 7) {
				count = count+2;
			}else {
				count = count+3;
			}
		//세로길이가 3이상인 경우	
		}else {
			if(m ==1) {
				
			}else if(m ==2) {
				count = count+1;
			}else if(m==3) {
				count = count+2;
			}else if(m>=4 && m<7) {
				count = count + 3;
			//m이 7보다 큰 경우
			}else if(m ==7) {
				count = count +4;
			}else {
				count = count+4;
				count += m-7;
			}
		}

		System.out.println(count);
	}

}
