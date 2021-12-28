import java.io.*;
import java.util.ArrayList;
import java.util.StringTokenizer;
public class abcde_13023 {

	
	
	static ArrayList<Integer> arr[];
	static boolean check[];
	static int ans = 0;
	
	public static void main(String[] args) throws IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int n = Integer.parseInt(st.nextToken());
		
		int m = Integer.parseInt(st.nextToken());
		
		arr = new ArrayList[n];
		check = new boolean[n];
		
		for(int i = 0 ; i < n ; i ++) {
			arr[i] = new ArrayList<>();
		}
		
		
		for(int i = 0 ; i < m ; i++) {
			st= new StringTokenizer(br.readLine());
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			
			arr[a].add(b);
			arr[b].add(a);
		}
		
		//정답인 예제라도 어느 정점에서 시작하냐에 따라 틀린답이 나올 수 있음
		for(int i = 0 ; i < n ; i++) {
			if(ans == 0) {
				dfs(i,1);
			}else {
				break;
			}
		}
		System.out.print(ans);
	}

	public static void dfs(int a, int depth) {
		if(depth == 5) {
			ans = 1;
			return;
		}
		
		check[a] = true;
		
		for(int nextnode : arr[a]) {
			if(!check[nextnode]) {
				dfs(nextnode,depth+1);
			}
		}
		//메인메소드에서 반복문으로 호출할때 또 써야하기때문에 초기화 시켜주는 작업임
		check[a] = false;
	}
}
