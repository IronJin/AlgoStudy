import java.util.*;

public class Level2_GameMap {

	public static void main(String[] args) {
		
		

	}
	
	static int row;
	static int col;
	
	static int yr[] = {0,0,1,-1};
	static int xc[] = {1,-1,0,0};
	
	static int dist[][];
	static boolean visit[][];
	
    public static int solution(int[][] maps) {
        int answer = 0;
        
        row = maps.length;
        col = maps[0].length;
        dist = new int[row][col];
        visit = new boolean[row][col];
        
        bfs(0,0,maps);
        
        if(dist[row-1][col-1] == 0) {
        	answer = -1;
        }else {
        	answer = dist[row-1][col-1];
        }
        
        
        return answer;
    }
    
    static void bfs(int startrow, int startcol, int[][] arr) {
    	
    	Queue<int[]> q = new LinkedList<>();
    	q.add(new int[] {startrow, startcol});
    	visit[startrow][startcol] = true;
    	dist[startrow][startcol] = 1;
    	
    	while(!q.isEmpty()) {
    		int location[] = q.poll();
    		int currow = location[0];
    		int curcol = location[1];
    		for(int i = 0 ; i < 4 ; i++) {
    			int nextrow = currow + yr[i];
    			int nextcol = curcol + xc[i];
    			if(0 <= nextrow && nextrow < row && 0 <= nextcol && nextcol < col) {
    				if(visit[nextrow][nextcol] == false && arr[nextrow][nextcol] == 1) {
    					visit[nextrow][nextcol] = true;
    					dist[nextrow][nextcol] = dist[currow][curcol] + 1;
    					q.add(new int[] {nextrow, nextcol});
    				}
    			}
    		}
    	}
    	
    	
    }

}
