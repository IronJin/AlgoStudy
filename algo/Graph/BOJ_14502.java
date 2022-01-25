/*
 * 1. ���� ������ ����µ� ���Ʈ������ ���� ������ ����
 * 2. ���� ������ �� ������ ���̷����� ���� BFS Ž���� ���� ���̷����� �۶߸�
 * 3. BFS Ž���� ���� �� ���ڿ��� 0�� ������ �����
 */

import java.io.*;
import java.util.*;

public class BOJ_14502 {

	static int row;
	static int col;
	static int arr[][];
	static int x[] = {0,0,-1,1};
	static int y[] = {1,-1,0,0};
	static int answer = 0;
	
	static void pro() {
		dfs(0);
		System.out.println(answer);
	}
	
	
	//���� ������ ��������
	static void dfs(int depth) {
		if(depth == 3) {
			answer = Math.max(answer, bfs());
			return;
		}
		
		for(int i = 0 ; i < row ; i++) {
			for(int j = 0 ; j < col ; j++) {
				if(arr[i][j] == 0) {
					arr[i][j] = 1;
					dfs(depth+1);
					arr[i][j] = 0;
				}
			}
		}
	}
	
	//���� ���� ����� ���� ���̷����� �����ϴ°��� ���� ť�� �־����� ���� �ƴѰ��� Ž��
	static int bfs() {
		Queue<int[]> q = new LinkedList<>();
		int copy[][] = new int[row][col];
		boolean visit[][] = new boolean[row][col];
		for(int i = 0 ; i < row ; i++) {
			for(int j = 0 ; j < col ; j++) {
				copy[i][j] = arr[i][j];
				if(copy[i][j] == 2) {
					q.add(new int[] {i,j});
				}
			}
		}
		
		while(!q.isEmpty()) {
			int location[] = q.poll();
			int currow = location[0];
			int curcol = location[1];
			//System.out.println(currow +" "+curcol);
			for(int i = 0 ; i < 4 ; i++) {
				int nextrow = currow+y[i];
				int nextcol = curcol+x[i];
				if(nextrow >= 0 && nextrow < row && nextcol >= 0 && nextcol < col) {
					if(visit[nextrow][nextcol] == false && copy[nextrow][nextcol] == 0) {
						visit[nextrow][nextcol] = true;
						copy[nextrow][nextcol] = 2;
						q.add(new int[] {nextrow, nextcol});
					}
				}
			}
		}
		
		int count = 0;
		for(int i = 0 ; i < row ; i++) {
			for(int j = 0 ; j < col ; j++) {
				if(copy[i][j] == 0) {
					count++;
				}
			}
		}
		return count;
	}
	
	public static void main(String[] args) throws IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		row = Integer.parseInt(st.nextToken());
		col = Integer.parseInt(st.nextToken());
		arr = new int[row][col];
		for(int i = 0 ; i < row ; i++) {
			st = new StringTokenizer(br.readLine());
			for(int j = 0 ; j < col ; j++) {
				arr[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		
		pro();
		
	}

}
