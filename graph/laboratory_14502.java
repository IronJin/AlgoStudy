import java.io.*;
import java.util.*;

//���Ʈ ����, �� ��� ��츦 �� �˻��غ��� �ϴµ� �� �� dfs �� Ȱ�� 
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
		
        //�̷ο� ���� �־��� - �Է¿��� �ۼ�
		for(int i = 0 ; i < row ; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0 ; j < col ; j++) {
				miro[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		
        //���Ʈ ���� ����
		dfs(0);
		
        //���� ���
		System.out.println(answer);

	}
	
	public static void dfs(int depth) {
		
        //�� ������ ������ �� bfs �� ����
		if(depth == 3) {
			bfs(miro);
			return;
		}
		
        //���� ������ ������ �ʾҴٸ� ��͸� ���� ������ ����� �۾� ����
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
		//������ �˻縦 �ؾ��ϴ� ������ �̷ο� ����ϸ� �ȵ�
        //���� copymiro �� ����Ͽ� ������ �̷θ� ��������
		for(int i = 0 ; i < row ; i++) {
			for(int j = 0 ; j < col ; j++) {
				copymiro[i][j] = map[i][j];
			}
		}
		
        //���̷����� �ִ� �κ��� ť�� �־���
		for(int i = 0 ; i < row ; i++) {
			for(int j = 0 ; j < col ; j++) {
				if(copymiro[i][j] == 2) {
					q.add(new int[] {j,i});
				}
			}
		}
		
        //bfs Ž�� ����
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
		
        //0�� �κ� ��, ���̷����� �������� ���� ������ ã�Ƽ� count �� �������ְ� �� ���� �ٽ� answer�� �������ִ� �۾�
        //answer �� count �� ���� �� ū ���� answer �� �������ִ� ����
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
