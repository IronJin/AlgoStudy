package programmers;

public class new_id_kakao {

	public static void main(String[] args) {
	
		String str = solution("a-z-+.^.");
		System.out.println(str);
	}

	public static String solution(String new_id) {
		//1�ܰ�
		if(new_id.length() != 0) {
			new_id = new_id.toLowerCase();
		}
		
		//2�ܰ�
		new_id = new_id.replaceAll("[^a-z-_.0-9]", ""); // [^xxx] -> x, x, x �� ������ ��� ���ڸ� ��ü���ְڴٴ� �Ҹ�

		//3�ܰ�
		new_id = new_id.replaceAll("[.]{2,}", "."); // . �� 2�� �̻� �����°��� .���� ��ü

		//4�ܰ�
		if(new_id.startsWith(".")) {
			new_id = new_id.substring(1,new_id.length()); //���꽺Ʈ���� �̿��ؼ� �Ǿտ��ִ� ���ڸ� ������
		}
		if(new_id.endsWith(".")) {
			new_id = new_id.substring(0,new_id.length()-1);
		}
		
		//5�ܰ�
		if(new_id.equals("")) {
			new_id = "a";
		}
		
		//6�ܰ�
		if(new_id.length() >= 16) {
			new_id = new_id.substring(0,15);
			
			if(new_id.charAt(14) == '.') {
				new_id = new_id.substring(0,14);
			}
		}
		
		//7�ܰ�
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
