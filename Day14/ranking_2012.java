import java.io.*;
import java.util.Arrays;


//5�и��� Ǭ ����
//���� ������� ���� ��ư� �������� ����
public class ranking_2012 {

	public static void main(String[] args) throws NumberFormatException, IOException {
		// TODO Auto-generated method stub
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int n = Integer.parseInt(br.readLine());
		
		int r[] = new int[n+1];
		
		
		for(int i = 1 ; i <=n ; i++) {
			r[i] = Integer.parseInt(br.readLine());
		}
		//-------------�Է¿��� ��
		
		Arrays.sort(r);
		
		long sum = 0;
		
		for(int i = 1 ; i <= n ; i++) {
			sum += Math.abs(i-r[i]);
		}
		System.out.println(sum);
		
	}

}
