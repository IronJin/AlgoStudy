import java.io.*;
import java.util.Arrays;
import java.util.StringTokenizer;

//�Ҿ���� ��ȣ
public class bj1541 {

	public static void main(String[] args) throws NumberFormatException, IOException{

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int plus1 = 0;
		int minus1 = 0;
		//�� �Է�
		String str = br.readLine();
		//-�� �������� ���� 
		String[] minus = str.split("-");
		
		for(int i = 0 ; i < minus.length ; i++) {
			//�� ó���� �� �͵��� ������ ������� �ϴ°���
			if(i == 0 ) {
				StringTokenizer st = new StringTokenizer(minus[i],"+");
				while(st.hasMoreTokens()) {
					plus1 += Integer.parseInt(st.nextToken());
				}
				//ó�� - ���ĺ��� �����ϴ� ��� + ���� �����ش��� ���� ��
			}else {
				StringTokenizer st = new StringTokenizer(minus[i],"+");
				while(st.hasMoreTokens()) {
					minus1 += Integer.parseInt(st.nextToken());
				}
			}
		}
		System.out.println(plus1 - minus1);
	}
}
