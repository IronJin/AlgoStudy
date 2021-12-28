import java.io.*;

public class bj5585 {

	public static void main(String[] args) throws NumberFormatException, IOException{

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		//1000 원에서 지불할 돈을 뺀 거스름 돈이다.
		int k = 1000 - Integer.parseInt(br.readLine());
		int count = 0;
		//잔돈의 종류
		int a[] = new int[6];
		for(int i = 0 ; i < a.length ; i++) {
			if(i == 0) {
				a[i] = 500;
			}else if(i == 1) {
				a[i] = 100;
			}else if(i % 2 == 0) {
				a[i] = a[i-2]/10;
			}else if(i % 2 == 1) {
				a[i] = a[i-2]/10;
			}
		}
		
		//k가 0원이 되면 종료
		int i = 0;
		while(k != 0) {
			if(k >= a[i]) {
				k = k-a[i];
				count ++;
			}else i++;
		}
		System.out.println(count);
	}
}
