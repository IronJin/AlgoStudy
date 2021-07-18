import java.io.*;
import java.util.Arrays;
import java.util.StringTokenizer;

public class microwave_10162 {

	
	
	public static void main(String[] args) throws NumberFormatException, IOException{

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		//요리시간 입력
		int n = Integer.parseInt(br.readLine());
		
		int button[] = {300,60,10};
		int buttoncount[] = new int[3];
		int i = 0;
		while(n != 0) {
		//10 으로 안나눠 지는 경우가 요리시간을 맞출 수 없는 경우임
			if(n%10 != 0) {
				System.out.println(-1);
				break;
			}
			else if(n >= button[i]) {
				buttoncount[i] = n/button[i];
				n = n%button[i];
				i++;
			}else i++;
		}
		//n 이 0이 되는 경우만 개수 출력
		if(n == 0) {
			for(int j = 0 ; j < 3 ; j ++) {
				System.out.print(buttoncount[j]+" ");
			}
		}
		
	}
}
