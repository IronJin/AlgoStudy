import java.io.*;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Flyme_1011 {

	
	//max와 distance 간의 규칙을 찾고 count 와의 규칙을 찾을것
	public static void main(String[] args) throws NumberFormatException, IOException{

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int n = Integer.parseInt(br.readLine());

		for(int i = 0 ; i < n ; i ++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			int x = Integer.parseInt(st.nextToken());
			int y = Integer.parseInt(st.nextToken());
			int distance = y-x;
			int max = 0;
			max = (int)Math.sqrt(distance);
			
			if(max == Math.sqrt(distance)) {
				System.out.println(2*max -1);
			}else if(distance <= max*max+max ) {
				System.out.println(2*max);
			}else {
				System.out.println(2*max+1);
			}
		}
	}
}
