import java.util.*;

public class Level2_kakaoFriendsColorBook {

	static int yr[] = {0,0,1,-1};
	static int xc[] = {1,-1,0,0};
	static boolean visit[][];
	static int row = 0;
	static int col = 0;
	static int maxArea = 0;
	static int AreaCount = 0;
	
	public static void main(String[] args) {
		
		

	}
	//영역의 개수와 가장 큰 영역의 크기를 구하면 됨
    public static int[] solution(int r, int c, int[][] picture) {
    	row = r; //전역변수로 컨트롤 하기 위한 설정
    	col = c; //전역변수로 컨트롤 하기 위한 설정
    	visit = new boolean[row][col];
    	maxArea = 0;
    	AreaCount = 0;
    	
    	for(int i = 0 ; i < row ; i++) {
    		for(int j = 0 ; j < col ; j++) {
    			visit[i][j] = false;
    		}
    	}
    			
    	for(int i = 0 ; i < row ; i++) {
    		for(int j = 0 ; j < col ; j++) {
    			if(picture[i][j] != 0 && visit[i][j] == false) {
    				bfs(i,j,picture,picture[i][j]);
    				AreaCount++;
    			}
    		}
    	}
    	
    	int answer[] = new int[2];
    	answer[0] = AreaCount;
    	answer[1] = maxArea;
    	return answer;
    }
    
    static void bfs(int startrow, int startcol, int[][] picture, int value) {
    	int count = 1;
    	Queue<int[]> q = new LinkedList<>();
    	q.add(new int[] {startrow, startcol});
    	visit[startrow][startcol] = true;
    	
    	while(!q.isEmpty()) {
    		int location[] = q.poll();
    		int currow = location[0];
    		int curcol = location[1];
    		for(int i = 0 ; i < 4 ; i++) {
    			int nextrow = currow + yr[i];
    			int nextcol = curcol + xc[i];
    			if(0 <= nextrow && nextrow < row && 0 <= nextcol && nextcol < col) {
    				if(picture[nextrow][nextcol] == value && visit[nextrow][nextcol] == false) {
    					visit[nextrow][nextcol] = true;
    					q.add(new int[] {nextrow, nextcol});
    					count++;
    				}
    			}
    		}
    	}
    	
    	maxArea = Math.max(count, maxArea);
    	
    }

}
