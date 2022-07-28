/**
 * 숫자 영단어와 문자열 - 프로그래머스 level 1
 * @author 82105
 *
 */
public class Level1_NumberAndString {

	public static void main(String[] args) {
		
		String s = "one4seveneight";
		int answer = solution(s);
		System.out.println(answer);
	}
	
	public static int solution(String s) {
		int answer = 0;
		
		String[] words = {"zero","one","two","three","four","five","six","seven","eight","nine"};
		
		for(int i = 0 ; i < words.length ; i++) {
			s = s.replace(words[i], String.valueOf(i));
		}
		
		answer = Integer.parseInt(s);
		
		return answer;
	}

}
