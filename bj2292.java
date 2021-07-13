import java.io.*;

public class bj2292 {

	public static void main(String[] args) throws NumberFormatException, IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	
		int a = Integer.parseInt(br.readLine());
		int sum = 1;
		int n = 0;
		
		while(true) {
			sum += 6*n;
			n++;
			if(a<=sum) {
				break;
			}
			
		}
	
		System.out.println(n);
	}

}
