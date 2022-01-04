package algoprac;

import java.util.*;

public class dijkstra_again_solo {

	static class Edge implements Comparable<Edge>{

		String vertex;
		int dist;
		
		public Edge(int dist, String vertex) {
			this.dist = dist;
			this.vertex = vertex;
		}
		
		@Override
		public String toString() {
			return "vertex : "+this.vertex+", dist : "+this.dist;
		}
		
		@Override
		public int compareTo(Edge o) {
			// TODO Auto-generated method stub
			return o.dist - this.dist;
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
		ArrayList<Edge> list = new ArrayList<>();
		HashMap<String, Integer> answer = new HashMap<>();
		
		for(String key : graph.keySet()) {
			answer.put(key, Integer.MAX_VALUE);
		}
		String start = "A";
		
		answer.put(start, 0);
		
		PriorityQueue<Edge> queue = new PriorityQueue<>();
		queue.add(new Edge(answer.get(start),start));
		
		while(!queue.isEmpty()) {
			Edge curEdge = queue.poll();
			String curvertex = curEdge.vertex;
			int curdist = curEdge.dist;
			
			if(curdist > answer.get(curvertex)) {
				continue;
			}
			
			list = graph.get(curvertex);
			for(int i = 0 ; i < list.size() ; i++) {
				Edge adj = list.get(i);
				String adjvertex = adj.vertex;
				int adjdist = adj.dist;
				
				int sumdist = adjdist + curdist;
				if(answer.get(adjvertex) > sumdist) {
					queue.add(new Edge(sumdist, adjvertex));
					answer.put(adjvertex, sumdist);
				}
			}
			
		}
		
		System.out.println(answer);
	}

}
