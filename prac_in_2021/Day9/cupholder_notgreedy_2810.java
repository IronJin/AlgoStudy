import java.io.*;
import java.util.Stack;

public class cupholder_notgreedy_2810 {

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int n = Integer.parseInt(br.readLine());
		
		String str = br.readLine();
		
		Stack<Character> stack = new Stack<>();

		stack.add('*');
		
		for(int i = 0 ; i < n ; i++) {
			if(stack.size() == n) break;
			if(str.charAt(i) == 'S') {
				stack.add('*');
			}
			if(str.charAt(i) == 'L') {
				i++;
				stack.add('*');
			}
		}
		
		System.out.println(stack.size());
	}

}
