package algoprac;

import java.util.*;

import algoprac.dijkstra_basic.Node;

public class dijkstra_solo_prac {

	static class Edge implements Comparable<Edge>{
		String vertex;
		int cost;
		
		Edge(int cost, String vertex){
			this.vertex = vertex;
			this.cost = cost;
		}
		
		@Override
		public String toString() {
			return this.vertex+" "+this.cost;
		}

		@Override
		public int compareTo(Edge o) {
			return this.cost - o.cost;
		}
	}
	
	public static void main(String[] args) {
		
		HashMap<String, ArrayList<Edge>> graph = new HashMap<>();
		graph.put("A", new ArrayList<Edge>(Arrays.asList(new Edge(8, "B"), new Edge(1, "C"), new Edge(2, "D"))));
		graph.put("B", new ArrayList<Edge>());
		graph.put("C", new ArrayList<Edge>(Arrays.asList(new Edge(5, "B"), new Edge(2, "D"))));
		graph.put("D", new ArrayList<Edge>(Arrays.asList(new Edge(3, "E"), new Edge(5, "F"))));
		graph.put("E", new ArrayList<Edge>(Arrays.asList(new Edge(1, "F"))));
		graph.put("F", new ArrayList<Edge>(Arrays.asList(new Edge(5, "A"))));
		
		//인접 노드들을 담을 어레이 리스트
		ArrayList<Edge> nodelist = new ArrayList<>();

		//각 정점의 가중치 정보를 넣어줄 해쉬맵
		HashMap<String, Integer> map = new HashMap<>();
		
		//초기값 설정
		for(String key : graph.keySet()) {
			map.put(key, Integer.MAX_VALUE);
		}
		String start = "A";
		map.put(start, 0);
		
		PriorityQueue<Edge> queue = new PriorityQueue<>();
		queue.add(new Edge(map.get(start), start));
		
		while(!queue.isEmpty()) {
			Edge curEdge = queue.poll();
			String curvertex = curEdge.vertex;
			int curcost = curEdge.cost;
			
			if(map.get(curvertex) < curcost) {
				continue;
			}
			
			nodelist = graph.get(curvertex);
			
			for(int i = 0 ; i < nodelist.size() ; i++) {
				Edge adjEdge = nodelist.get(i);
				String adjvertex = adjEdge.vertex;
				int adjcost = adjEdge.cost;
				int sumcost = adjcost + curcost;
				if(map.get(adjvertex) > sumcost) {
					map.put(adjvertex, sumcost);
					queue.add(new Edge(sumcost, adjvertex));
				}
			}
		}
		
		System.out.println(map);
	}

}
