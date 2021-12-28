import java.io.*;
import java.util.Arrays;
import java.util.StringTokenizer;

public class fixer_1449 {

	public static void main(String[] args) throws IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int n = Integer.parseInt(st.nextToken());
		int l = Integer.parseInt(st.nextToken());
		
		int a[] = new int[n];
		st = new StringTokenizer(br.readLine());
		for(int i = 0 ; i < n ; i ++) {
			a[i] = Integer.parseInt(st.nextToken());
		}
		
		Arrays.sort(a);
		int max = l-1;
		int length = 0;
		int count = 0;
		
		if(n == 1) {
			System.out.println(1);
		}else {
			for(int i = 1 ; i < n ; i ++) {
				length += a[i] - a[i-1];
				if(length == max) {
					length = 0;
					count++;
					i++;
					if(i == n-1) {
						count++;
					}
				}else if(length > max) {
					count++;
					length = 0;
					if(i == n-1) {
						count++;
					}
				}
			}
			
			if(length != 0) {
				count++;
				System.out.println(count);
			}else {
				System.out.println(count);
			}
		}
		
		
		
		
		
		
		
		
		

	}

}
