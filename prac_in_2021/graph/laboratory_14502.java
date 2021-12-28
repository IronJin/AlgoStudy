import java.io.*;
import java.util.*;

//브루트 포스, 즉 모든 경우를 다 검사해봐야 하는데 이 때 dfs 를 활용 
public class laboratory_14502 {

	static int row;
	static int col;
	static int[][] miro;
	static int dx[] = {0,0,-1,1};
	static int dy[] = {1,-1,0,0};
	static int answer = 0;
	
	public static void main(String[] args) throws IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		row = Integer.parseInt(st.nextToken());
		col = Integer.parseInt(st.nextToken());
		miro = new int[row][col];
		
        //미로에 값을 넣어줌 - 입력예제 작성
		for(int i = 0 ; i < row ; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0 ; j < col ; j++) {
				miro[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		
        //브루트 포스 진행
		dfs(0);
		
        //정답 출력
		System.out.println(answer);

	}
	
	public static void dfs(int depth) {
		
        //벽 세개를 세웠을 때 bfs 를 진행
		if(depth == 3) {
			bfs(miro);
			return;
		}
		
        //벽을 세개를 세우지 않았다면 재귀를 통해 세개를 세우는 작업 진행
		for(int i = 0 ; i < row ; i++) {
			for(int j = 0 ; j < col ; j++) {
				if(miro[i][j] == 0) {
					miro[i][j] = 1;
					dfs(depth+1);
					miro[i][j] = 0;
				}
			}
		}
			
	}
	
	public static void bfs(int map[][]) {
		Queue<int []> q = new LinkedList<>();
		
		int copymiro[][] = new int[row][col];
		//여러번 검사를 해야하니 기존의 미로에 사용하면 안됨
        //따라서 copymiro 를 사용하여 기존의 미로를 복사해줌
		for(int i = 0 ; i < row ; i++) {
			for(int j = 0 ; j < col ; j++) {
				copymiro[i][j] = map[i][j];
			}
		}
		
        //바이러스가 있는 부분을 큐에 넣어줌
		for(int i = 0 ; i < row ; i++) {
			for(int j = 0 ; j < col ; j++) {
				if(copymiro[i][j] == 2) {
					q.add(new int[] {j,i});
				}
			}
		}
		
        //bfs 탐색 진행
		while(!q.isEmpty()) {
			int location[] = q.poll();
			int x = location[0];
			int y = location[1];
			for(int i = 0 ; i < 4 ; i++) {
				int nextx = x + dx[i];
				int nexty = y + dy[i];
				if(nextx >= 0 && nexty >= 0 && nextx < col && nexty < row) {
					if(copymiro[nexty][nextx] == 0) {
						copymiro[nexty][nextx] = 2;
						q.add(new int[] {nextx,nexty});
					}
				}
			}
		}
		
        //0인 부분 즉, 바이러스에 오염되지 않은 구역을 찾아서 count 에 저장해주고 그 값을 다시 answer에 저장해주는 작업
        //answer 와 count 를 비교해 더 큰 값을 answer 에 저장해주는 것임
		int count = 0;
		for(int i = 0 ; i < row ; i++) {
			for(int j = 0 ; j < col ; j++) {
				if(copymiro[i][j] == 0) {
					count++;
				}
			}
		}
		
		answer = Math.max(count, answer);
	}

}
