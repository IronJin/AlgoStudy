import java.util.*;

public class Level3_Ranking {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
	
	static int fanin[];
	static int fanout[];
	static ArrayList<Integer> list[];
	
    public static int solution(int n, int[][] results) {
        int answer = 0;
        list = new ArrayList[n+1];
        for(int i = 1 ; i <=n ; i++ ) {
        	list[i] = new ArrayList<>();
        }
        fanin = new int[n+1];
        fanout = new int[n+1];
        
        for(int i = 0 ; i < results.length ; i++) {
        	int a = results[i][0];
        	int b = results[i][1];
        	list[a].add(b);
        }
        
        for(int i = 1 ; i <= n ; i++) {
        	bfs(i, n);
        }
        
        for(int i = 1; i <= n ; i++) {
        	int possible = fanin[i] + fanout[i];
        	if(possible >= n-1) {
        		answer++;
        	}
        }
        
        return answer;
    }
    
    static void bfs(int startnode, int n) {
    	Queue<Integer> q = new LinkedList<>();
    	q.add(startnode);
    	boolean visit[] = new boolean[n+1];
    	visit[startnode]= true;
    	int count = 0;
    	
    	while(!q.isEmpty()) {
    		int curnode = q.poll();
    		for(int i = 0 ; i < list[curnode].size() ; i++) {
    			int nextnode = list[curnode].get(i);
    			if(visit[nextnode] == false) {
    				q.add(nextnode);
    				visit[nextnode] = true;
    				count++;
    				fanin[nextnode] ++;
    			}
    		}
    	}
    	
    	fanout[startnode] = count;
    	
    }

}
