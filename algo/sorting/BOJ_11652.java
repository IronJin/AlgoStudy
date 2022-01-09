
import java.io.*;
import java.util.*;

public class BOJ_11652 {

	static int testcase;
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		testcase = Integer.parseInt(br.readLine());
		
		HashMap<Long, Integer> hash = new HashMap<>();

		for(int i = 0 ; i < testcase ; i++) {
			long a = Long.parseLong(br.readLine());
			if(hash.containsKey(a)) {
				int b = hash.get(a);
				hash.put(a, b+1);
			}else {
				hash.put(a, 1);
			}
		}

		long answer = Long.MAX_VALUE;
		int compare = Integer.MIN_VALUE;
		for(long key : hash.keySet()) {
			if(compare < hash.get(key)) {
				compare = hash.get(key);
				answer = key;
			}else if(compare == hash.get(key)) {
				answer = Math.min(answer, key);
			}
		}
		
		System.out.println(answer);
	}

}
