import java.io.*;

//문제풀이시간 10분

public class diablo_2720 {

	public static void main(String[] args) throws NumberFormatException, IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int t = Integer.parseInt(br.readLine());
		
		int a[] = new int[t];

		
		for(int i = 0 ; i < t ; i++) {
			a[i] = Integer.parseInt(br.readLine());
		}
		
		int q = 25;
		int d = 10;
		int n = 5;
		int p = 1;
		
		int i = 0;
		while(a[i] != 0) {
			int q1=0, d1=0, n1 = 0 , p1=0;
			if(a[i] >= q) {
				q1 = a[i]/q;
				a[i] = a[i]%q;
			}
			if(a[i] >= d) {
				d1 = a[i]/d;
				a[i] = a[i]%d;
			}
			if(a[i] >= n) {
				n1 = a[i]/n;
				a[i] = a[i]%n;
			}
			p1 = a[i]/p;
			a[i] = a[i] % p;
			
			System.out.println(q1+" "+d1+" "+n1+" "+p1);
			i++;
			if(i == t) {
				break;
			}
		}//while문의 끝
		
	}
}
