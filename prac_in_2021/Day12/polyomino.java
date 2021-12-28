import java.io.*;
import java.util.StringTokenizer;

public class polyomino {

	public static void main(String[] args) throws IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		boolean aa = true;
		String stb = br.readLine();

		StringTokenizer st = new StringTokenizer(stb, ".");
		
		while(st.hasMoreTokens()) {
			String str = st.nextToken();
			int a = str.length();
			if(a%4 != 0 && a%2 != 0) {
				aa = false;
				System.out.println(-1);
				break;
			}
		}
		if(aa) {
			if(stb.contains("XXXX")) {
				stb = stb.replaceAll("XXXX", "AAAA");
			}
			if(stb.contains("XX")) {
				stb = stb.replaceAll("XX", "BB");
			}
			System.out.println(stb);
		}
		
		
	}

}
