import java.io.*;

//��ó�� ��Ȧ���� ������ �����ִ°Ŷ� count �� 1�� ����
//LL�� �ϳ��� ���� count ���ְ� count �� n �̵Ǹ� �ݺ��� ����
public class cupholder_2810 {

	public static void main(String[] args) throws NumberFormatException, IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		
		String str = br.readLine();
		
		int count = 1;
		
		for(int i = 0 ; i < n ; i++) {
			if(count == n) break;
			if(str.charAt(i) == 'L') {
				i++;
				count++;
			}
			if(str.charAt(i) == 'S') {
				count++;
			}
		}

		System.out.println(count);
		
	}

}
