import java.util.StringTokenizer;
import java.io.*;

public class camping_4796 {

	public static void main(String[] args) throws IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int i = 1;
		while(true) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			int l = Integer.parseInt(st.nextToken());
			int p = Integer.parseInt(st.nextToken());
			int v = Integer.parseInt(st.nextToken());
			if(l == 0 && p ==0 && v ==0) {
				break;
			}else {
				int sum = 0;
				sum += (v/p)*l;
				v = v%p;
				if(v<l) {
					sum += v;
				}else {
					sum += l;
				}
				System.out.println("Case "+i+": "+sum);
				i++;
			}
		}
	}

}
