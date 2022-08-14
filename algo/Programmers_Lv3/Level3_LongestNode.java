import java.util.*;

public class Level3_LongestNode {

	
	
	public static void main(String[] args) {

	}

	static ArrayList<Integer> list[];
	static boolean visit[];
	static int[] dist;
	
	//1번 노드에서 가장 먼 노드 찾기
	public static int solution(int n, int[][] edge) {
		int answer = 0;

	    list = new ArrayList[n + 1];
	    visit = new boolean[n + 1];
	    dist = new int[n + 1];
	    for(int i = 1 ; i <= n; i++) {
	    	list[i] = new ArrayList<>();
	    }
	    
	    for(int i = 0 ; i < edge.length ; i++) {
	    	int a = edge[i][0];
	    	int b = edge[i][1];
	    	list[a].add(b);
	    	list[b].add(a);
	    }
	    
	    bfs(1);
	    
	    HashMap<Integer, Integer> map = new HashMap<>();
	    
	    for(int i = 1 ; i <= n ; i++) {
	    	if(map.containsKey(dist[i])) {
	    		map.put(dist[i], map.get(dist[i]) + 1);
	    	}else {
	    		map.put(dist[i], 1);
	    	}
	    }
	    
	    for(int i = n ; i > 0 ; i--) {
	    	if(map.containsKey(i)) {
	    		return map.get(i);
	    	}
	    }

	    return answer;
	}
	
	static void bfs(int startnode) {
		Queue<Integer> q = new LinkedList<>();
		q.add(startnode);
		dist[startnode] = 0;
		visit[startnode] = true;
		
		while(!q.isEmpty()) {
			int curnode = q.poll();
			for(int i = 0 ; i < list[curnode].size() ; i++) {
				int nextnode = list[curnode].get(i);
				if(visit[nextnode] == false) {
					dist[nextnode] = dist[curnode] + 1;
					visit[nextnode] = true;
					q.add(nextnode);
				}
			}
		}
		
	}
	

}
