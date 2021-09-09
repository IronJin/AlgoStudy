package programmers;

public class new_id_kakao {

	public static void main(String[] args) {
	
		String str = solution("a-z-+.^.");
		System.out.println(str);
	}

	public static String solution(String new_id) {
		//1단계
		if(new_id.length() != 0) {
			new_id = new_id.toLowerCase();
		}
		
		//2단계
		new_id = new_id.replaceAll("[^a-z-_.0-9]", ""); // [^xxx] -> x, x, x 를 제외한 모든 문자를 대체해주겠다는 소리

		//3단계
		new_id = new_id.replaceAll("[.]{2,}", "."); // . 이 2개 이상 나오는것을 .으로 대체

		//4단계
		if(new_id.startsWith(".")) {
			new_id = new_id.substring(1,new_id.length()); //서브스트링을 이용해서 맨앞에있는 문자를 삭제함
		}
		if(new_id.endsWith(".")) {
			new_id = new_id.substring(0,new_id.length()-1);
		}
		
		//5단계
		if(new_id.equals("")) {
			new_id = "a";
		}
		
		//6단계
		if(new_id.length() >= 16) {
			new_id = new_id.substring(0,15);
			
			if(new_id.charAt(14) == '.') {
				new_id = new_id.substring(0,14);
			}
		}
		
		//7단계
		if(new_id.length() <= 2) {
			String str = String.valueOf(new_id.charAt(new_id.length()-1));
			while(new_id.length() != 3) {
				new_id += str;
			}
		}
		
		
		String answer = new_id;
		return answer;
	}
}
