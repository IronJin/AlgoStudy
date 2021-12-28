import java.io.*;
import java.util.StringTokenizer;

public class turn_over_1439 {

	public static void main(String[] args) throws IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		String str = br.readLine();
		StringTokenizer st = new StringTokenizer(str,"0");
		int a = 0;
		while(st.hasMoreTokens()) {
			st.nextToken();
			a++;
		}

		st = new StringTokenizer(str, "1");
		int b = 0;
		while(st.hasMoreTokens()) {
			st.nextToken();
			b++;
		}
		
		if(a>b) {
			System.out.println(b);
		}else {
			System.out.println(a);
		}
	}

}
