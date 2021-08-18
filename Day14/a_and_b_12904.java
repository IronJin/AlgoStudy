import java.io.*;

public class a_and_b_12904 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		String str1 = br.readLine();
		StringBuffer str2 = new StringBuffer(br.readLine());
		
		while(true) {
			if(str1.length() == str2.length()) {
				break;
			}
			if(str2.charAt(str2.length()-1) == 'A') {
				str2.deleteCharAt(str2.length()-1);
				continue;
			}
			if(str2.charAt(str2.length()-1) == 'B') {
				str2.deleteCharAt(str2.length()-1);
				str2.reverse().toString();
			}
		}

		
		if(str1.contentEquals(str2)) {
			System.out.println(1);
		}else {
			System.out.println(0);
		}
		
	}

}
