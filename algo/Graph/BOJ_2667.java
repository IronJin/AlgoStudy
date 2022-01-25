import java.io.*;
import java.util.*;

public class BOJ_2667 {

	static int n;
	static int arr[][];
	static boolean visit[][];
	static int x[] = {-1,1,0,0};
	static int y[] = {0,0,1,-1};
	static int count = 0;
	static int answer = 0;
	static ArrayList<Integer> list = new ArrayList<>();
	
	static void DFS(int col, int row) {
		visit[col][row] = true;
		for(int i = 0 ; i < 4 ; i++) {
			if(col+x[i] < n && 0<= col+x[i] && 0<= row + y[i] && row + y[i] < n) {
				if(visit[col+x[i]][row+y[i]] == false && arr[col+x[i]][row + y[i]] == 1) {
					DFS(col + x[i], row + y[i]);
					answer++;
				}
			}
		}
		
	}
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		n = Integer.parseInt(br.readLine());
		arr = new int[n][n];
		visit = new boolean[n][n];
		for(int i = 0 ; i < n ; i++) {
			String str = br.readLine();
			
			for(int j = 0 ; j < str.length() ; j++) {
				if(str.charAt(j) == '0') {
					arr[i][j] = 0;
				}else {
					arr[i][j] = 1;
				}
			}
		}
		
		for(int i = 0 ; i < n ; i++) {
			for(int j = 0 ; j < n ; j++) {
				if(!visit[i][j] && arr[i][j] == 1) {
					answer = 0;
					DFS(i, j);
					count++;
					list.add(answer);
				}
			}
		}
		Collections.sort(list);
		System.out.println(count);
		for(int i = 0 ; i < list.size() ; i++) {
			System.out.println(list.get(i)+1);
		}
		
		
		
	}

}
