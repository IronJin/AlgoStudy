package programmers;
import java.io.*;
//카카오 블라인드 채용 - 문자열 압축문제
//답을 봄
public class munjayeolapchook {

	public static void main(String[] args) throws IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		String s = br.readLine();
	
		int answer = solution(s);
		System.out.println(answer);
	}

	public static int solution(String s) {
		
		int answer = Integer.MAX_VALUE;
		
		if(s.length()==1) {
			return 1;
		}
		
		for(int i = 1 ; i <= s.length()/2 ; i++) {
			String str = "";
			String now = "";
			int count = 1;
			
			for(int j = 0 ; j < s.length()/i ; j++) {
				if(now.equals(s.substring(j*i, i*(j+1)))) {
					count++;
				}else {
					if(count > 1) {
						str+=count+now;
						count = 1;
					}else {
						str += now;
					}
					now = s.substring(j*i, i*(j+1));
				}
			}
			if(count > 1) {
				str += count + now;
				count = 1;
			}else {
				str += now;
			}
			
			if(s.length()%i != 0) {
				str += s.substring(s.length()- s.length()%i, s.length());
			}
			
			answer = Math.min(answer, str.length());
		}
		
		return answer;
	}
}
