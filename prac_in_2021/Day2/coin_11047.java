import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class coin_11047 {

	public static void main(String[] args) throws IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		StringTokenizer st = new StringTokenizer(br.readLine());
		
		//종류
		int n = Integer.parseInt(st.nextToken());

		//가격
		int k = Integer.parseInt(st.nextToken());
		
		int a[] = new int[n];
		
		//동전 수 count
		int count = 0;
		
		for(int i = 0 ; i < a.length ; i++) {
			a[i] = Integer.parseInt(br.readLine());
		}
		
		int i = 1;
		while(k != 0) {
			
			if(a[a.length-i] <= k) {
				k = k-a[a.length-i];
				count++;

			}else {
				i++;
			}
		}
		System.out.println(count);
	}

}
