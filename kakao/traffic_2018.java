package programmers;

import java.io.*;
import java.util.StringTokenizer;

public class traffic_2018 {

	//2시간
	//시간을 초로 바꾸는데 오래걸림
	public static void main(String[] args) throws NumberFormatException, IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int n = Integer.parseInt(br.readLine());
		
		String[] str = new String[n];
		
		for(int i = 0 ; i < n ; i++) {
			str[i] = br.readLine();
		}
		
		int answer = solution(str);
		System.out.println(answer);
	}

	public static int solution(String[] lines) {
		int answer = 0;
		
		int n = lines.length;
		
		int arr[][] = new int[n][2];
		
		for(int i = 0 ; i < n ; i++) {
			StringTokenizer st = new StringTokenizer(lines[i]);
			//맨앞에 줄은 하나 버림
			st.nextToken();
			
			String str1 = st.nextToken();
			int time;
			int a = 0;
			int sec = 3600;
			int count = 1;
			int b = 3;
			int sum = 0;
			
			for(int j = 0 ; j < str1.length() ; j++) {
				if(str1.charAt(j) >= '0' && str1.charAt(j) <= '9') {
					//시간과 분을을 초로
					if(b!=0) {
						if(count == 1) {
							count--;
							sum = (str1.charAt(j)-'0')*10;
						}else {
							sum += str1.charAt(j)-'0';
							a += sum * sec;
							sec = sec/60;
							count = 1;
							b--;
						}
					//초를 초로
					}else if(b == 1) {
						if(count == 1) {
							count --;
							a += (str1.charAt(j) -'0') *10;
						}else {
							b--;
							a += str1.charAt(j) - '0';
						}
					}else {
						a *= 10;
						a += str1.charAt(j) - '0';
					}
				}
			}
			arr[i][1] = a;
			
			str1 = st.nextToken();
			a = 0;
			time = 1000;
			for(int j = 0 ; j < str1.length() ; j++) {
				if(str1.charAt(j) >= '0' && str1.charAt(j) <= '9') {
					a += (str1.charAt(j) - '0') * time;
					time = time /10;
				}
			}
			arr[i][0] = arr[i][1]-a+1;
		}
		
		for(int i = 0 ; i < n ; i++) {
			int count = 0;
			for(int j = i; j < n ; j++) {
				if(arr[i][1]+999 >= arr[j][0]) {
					count++;
				}
			}
			answer = Math.max(answer, count);
		}
		
		return answer;
	}
}
