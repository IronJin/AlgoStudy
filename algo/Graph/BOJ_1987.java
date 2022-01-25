//1. DFS �� Ǯ �� �ִ� ����
//2. �湮ó���� ���ĺ� ��뿩�η� �������൵��
//3. 36��° �ٿ� �湮ó�� ������ ��������ϴµ� �� ������ �ֺ� ���ĺ��� �� �� �� �湮üũ�� ��������� �ϱ� ����
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
