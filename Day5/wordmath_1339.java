import java.io.*;
import java.util.Arrays;
import java.util.Collections;

public class wordmath_1339 {

	public static void main(String[] args) throws NumberFormatException, IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		//�׽�Ʈ ���̽�
		int t = Integer.parseInt(br.readLine());
		String str[] = new String[t];
		int[] a = new int[26];
		int sum = 0;
		//�Է�
		for(int i = 0 ; i < t ; i++) {
			str[i] = br.readLine(); 
		}
		
		//�� ���ĺ��� �ش��ϴ� ������ 10�� �������� �־���
		//ex) AAAAA �� ��� 5�ڸ��̹Ƿ� 10000 , 1000, 100 �̷������� ���簡�鼭 A�� �ش��ϴ� a�迭�� ���� ��� �߰�
		for(int i = 0 ; i < t ; i ++) 
			for(int j = 0 ; j < str[i].length() ; j++) {
				a[str[i].charAt(j)-65] += Math.pow(10, str[i].length()-j-1);
		}
		Arrays.sort(a);
		int index = 9;
		for(int i = a.length-1 ; i>= 0 ; i--) {
			if(a[i] != 0) {
				sum += a[i] * index;
				index --;
			}
		}
		
		
		
		System.out.println(sum);
	}
}
