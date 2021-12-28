package programmers;
import java.io.*;
import java.util.*;
public class bracketkakao {

	static int pos;
	
	public static void main(String[] args) throws IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		String s = br.readLine();
		
		String answer = solution(s);
		System.out.println(answer);
	}
	
	public static boolean isCorrect(String s) {
		boolean ret = true;
		int left = 0;
		int right = 0;
		Stack<Character> stack = new Stack<>();
		
		for(int i = 0 ; i < s.length() ; i++) {
			if(s.charAt(i) == '(') {
				left++;
				stack.push('(');
			}else {
				right++;
				if(stack.isEmpty()) {
					ret = false;
				}else {
					stack.pop();
				}
			}
			
			if(left == right) {
				pos = i+1;
				return ret;
			}
		}
		return ret;
	}
	
	public static String solution(String s) {
		
		if(s.isEmpty()) {
			return s;
		}
		
		boolean correct = isCorrect(s);
		String u = s.substring(0,pos);
		String v = s.substring(pos,s.length());
		
		if(correct) {
			return u + solution(v);
		}
		
		String answer = "(" + solution(v) + ")";
		for(int i = 1 ; i < u.length()-1; i++) {
			if(u.charAt(i) == '(') {
				answer += ")";
			}else {
				answer+="(";
			}
		}
		return answer;
	}

}
