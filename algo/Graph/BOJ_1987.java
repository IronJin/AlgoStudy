//1. DFS 로 풀 수 있는 문제
//2. 방문처리를 알파벳 사용여부로 측정해줘도됨
//3. 36번째 줄에 방문처리 해제를 시켜줘야하는데 그 이유는 주변 알파벳을 다 본 후 방문체크를 해제해줘야 하기 때문
import java.io.*;
import java.util.*;

public class BOJ_1987 {

	static int row;
	static int col;
	static char[][] ch;
	static boolean[] alpha = new boolean[26];
	
	static int answer = 1;
	static int count = 1;
	
	static int yr[] = {0,0,-1,1};
	static int xc[] = {1,-1,0,0};
	
	static void dfs(int x, int y, int depth) {
		answer = Math.max(answer, depth);
		
		alpha[(int)ch[y][x]-65] = true;
		for(int i = 0 ; i < 4 ; i++) {
			int nextrow = y + yr[i];
			int nextcol = x + xc[i];
			if(0<=nextrow && nextrow < row && 0 <= nextcol && nextcol < col) {
				if(alpha[(int)ch[nextrow][nextcol]-65] == false) {

					dfs(nextcol,nextrow, depth+1);
					count--;
				}
			}
		}
		
		alpha[(int)ch[y][x]-65] = false;
	}
	
	public static void main(String[] args) throws IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		row = Integer.parseInt(st.nextToken());
		col = Integer.parseInt(st.nextToken());
		ch = new char[row][col];
		for(int i = 0 ; i < row ; i++) {
			String str = br.readLine();
			for(int j = 0 ; j < col ; j++) {
				ch[i][j] = str.charAt(j);
			}
		}
		dfs(0,0,1);
		System.out.println(answer);
	}

}
