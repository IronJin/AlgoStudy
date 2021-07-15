import java.io.*;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {


	
	public static void main(String[] args) throws NumberFormatException, IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int n = Integer.parseInt(br.readLine());
		int []a = new int[n];
		int sum = 0;
		StringTokenizer st = new StringTokenizer(br.readLine());
		for(int i = 0 ; i < a.length ; i++) {
			a[i] = Integer.parseInt(st.nextToken());
		}
		Arrays.sort(a);
		for(int i = 0 ; i < a.length ; i++) {
			sum = sum + a[i];
			a[i] = sum;
		}
		sum = 0;
		for(int i = 0 ; i<a.length ; i++) {
			sum = sum+a[i];
		}
		System.out.println(sum);
	}

}
