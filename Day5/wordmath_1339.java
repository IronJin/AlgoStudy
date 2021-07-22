import java.io.*;
import java.util.Arrays;
import java.util.Collections;

public class wordmath_1339 {

	public static void main(String[] args) throws NumberFormatException, IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		//테스트 케이스
		int t = Integer.parseInt(br.readLine());
		String str[] = new String[t];
		int[] a = new int[26];
		int sum = 0;
		//입력
		for(int i = 0 ; i < t ; i++) {
			str[i] = br.readLine(); 
		}
		
		//각 알파벳에 해당하는 길이의 10의 제곱근을 넣어줌
		//ex) AAAAA 인 경우 5자리이므로 10000 , 1000, 100 이런식으로 낮춰가면서 A에 해당하는 a배열에 값을 계속 추가
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
