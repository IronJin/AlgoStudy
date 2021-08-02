import java.io.*;
import java.util.StringTokenizer;

public class whatisUCPC_15904 {

	public static void main(String[] args) throws IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		StringBuffer sb = new StringBuffer();
		StringBuffer ans = new StringBuffer();
		while(st.hasMoreTokens()) {
			String s = st.nextToken();
			for(int i = 0 ; i < s.length() ; i++) {
				if(s.charAt(i) >= 65 && s.charAt(i) <= 90) {
					sb.append(s.charAt(i));
				}
			}
		}
		
		char[] s = {'U','C','P','C'};
		int j = 0;
		for(int i = 0 ; i < sb.toString().length() ; i++) {
			if(j ==4) break;
			if(sb.toString().charAt(i) == s[j]) {
				ans.append(sb.toString().charAt(i));
				j++;
			}
		}
		
		if(ans.toString().equals("UCPC")) {
			System.out.println("I love UCPC");
		}else {
			System.out.println("I hate UCPC");
		}

	}

}
