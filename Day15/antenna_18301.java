import java.io.*;
import java.util.Arrays;
import java.util.StringTokenizer;

public class antenna_18301 {

	public static void main(String[] args) throws NumberFormatException, IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int n = Integer.parseInt(br.readLine());
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int a[] = new int[n];
		
		for(int i = 0 ; i < n ; i ++) {
			a[i] = Integer.parseInt(st.nextToken());
		}
		
		
		Arrays.sort(a);
		int answer = 0;
		answer = a[n-1/2];
		
		System.out.println(answer);
	}

}
