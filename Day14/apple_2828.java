import java.io.*;
import java.util.StringTokenizer;

public class apple_2828 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int n = Integer.parseInt(st.nextToken());
		
		int m = Integer.parseInt(st.nextToken());
		
		//����� ����
		int j = Integer.parseInt(br.readLine());
		
		//��ġ
		int ap[] = new int[j];
		
		for(int i = 0 ; i < j ; i ++) {
			ap[i] = Integer.parseInt(br.readLine());
		}

		//������ ��Ÿ���ִ� ����
		int a = 1;
		int b = m;
		
		int sum = 0;
		
		for(int i = 0 ; i < j ; i++) {
			if(ap[i] < a) {
				sum += a-ap[i];
				a= ap[i];
				b= a+m-1;
			}else if(ap[i] > b) {
				sum+= ap[i]-b;
				b=ap[i];
				a= b-m+1;
			}
		}
		
		System.out.println(sum);
	}

}
