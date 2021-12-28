package programmers;

import java.io.*;
import java.util.ArrayList;

public class newskakao {

	public static void main(String[] args) throws IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		String str1 = br.readLine();
		String str2 = br.readLine();
		
		int answer = solution(str1, str2);
		System.out.println(answer);
	}
	//여기까지가 입력
	
	public static int solution(String str1, String str2) {
		double answer = 0;
		//대문자로 다 바꿔줌
		str1 = str1.toUpperCase();
		str2 = str2.toUpperCase();
		
		ArrayList<String> list1 = new ArrayList<>();
		ArrayList<String> list2 = new ArrayList<>();
		
		for(int i = 0 ; i < str1.length()-1 ; i++) {
			if((int)str1.charAt(i) <= 90 && (int)str1.charAt(i)>=65) {
				if((int)str1.charAt(i+1) <= 90 && (int)str1.charAt(i+1) >=65) {
					list1.add(str1.substring(i, i+2));
				}
			}
		}
		for(int i = 0 ; i < str2.length()-1 ; i++) {
			if((int)str2.charAt(i) <= 90 && (int)str2.charAt(i)>=65) {
				if((int)str2.charAt(i+1) <= 90 && (int)str2.charAt(i+1) >=65) {
					list2.add(str2.substring(i, i+2));
				}
			}
		}
		
		boolean check[] = new boolean[list2.size()];
		// 분모
		int bottom = 0;
		//합집합의 개수를 찾아줌
		for(int i = 0 ; i < list1.size() ; i++) {
			for(int j = 0 ; j < list2.size() ; j++) {
				if(list1.get(i).equals(list2.get(j)) && !check[j]) {
					check[j] = true;
					break;
				}
			}
			bottom++;
		}
		for(int i = 0 ; i < list2.size() ; i++) {
			if(!check[i]) {
				bottom++;
			}
		}
		//합집합 구하기 완료'
		
		
		/*for(int i = 0 ; i < list1.size() ; i++) {
			System.out.print(list1.get(i) + " ");
		}
		System.out.println();
		for(int i = 0 ; i < list2.size() ; i++) {
			System.out.print(list2.get(i) + " ");
		}*/
		
		int up = 0;
		
		boolean check1[] = new boolean[list2.size()];
		for(int i = 0 ; i < list1.size() ; i++) {
			for(int j = 0 ; j < list2.size() ; j++) {
				if(list1.get(i).equals(list2.get(j)) && !check1[j]) {
					check1[j] = true;
					up++;
					break;
				}
			}
		}
		answer = ((double)up/(double)bottom) * 65536;
		if(up == 0 && bottom == 0) {
			answer = 65536;
		}
		return (int)answer;
	}

}
