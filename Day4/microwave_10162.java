import java.io.*;
import java.util.Arrays;
import java.util.StringTokenizer;

public class microwave_10162 {

	
	
	public static void main(String[] args) throws NumberFormatException, IOException{

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		//�丮�ð� �Է�
		int n = Integer.parseInt(br.readLine());
		
		int button[] = {300,60,10};
		int buttoncount[] = new int[3];
		int i = 0;
		while(n != 0) {
		//10 ���� �ȳ��� ���� ��찡 �丮�ð��� ���� �� ���� �����
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
		//n �� 0�� �Ǵ� ��츸 ���� ���
		if(n == 0) {
			for(int j = 0 ; j < 3 ; j ++) {
				System.out.print(buttoncount[j]+" ");
			}
		}
		
	}
}
