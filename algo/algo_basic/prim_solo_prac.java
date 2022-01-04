package algoprac;

import java.util.*;

public class prim_solo_prac {

	static class Edge implements Comparable<Edge>{
		int weight;
		String node1;
		String node2;
		
		public Edge(int weight, String node1, String node2) {
			this.weight = weight;
			this.node1 = node1;
			this.node2 = node2;
		}

		@Override
		public String toString() {
			return this.weight+" "+this.node1+" "+this.node2;
		}
		
		@Override
		public int compareTo(Edge o) {
			// TODO Auto-generated method stub
			return this.weight - o.weight;
		}
	}
	
	public static void main(String[] args) {
		
		//mst 정답을 출력할 리스트
		ArrayList<Edge> mst = new ArrayList<>();
		
		ArrayList<Edge> edges = new ArrayList<>();
		edges.add(new Edge(7, "A", "B"));
		edges.add(new Edge(5, "A", "D"));
		edges.add(new Edge(8, "B", "C"));
		edges.add(new Edge(9, "B", "D"));
		edges.add(new Edge(7, "D", "E"));
		edges.add(new Edge(5, "C", "E"));
		edges.add(new Edge(7, "B", "E"));
		edges.add(new Edge(6, "D", "F"));
		edges.add(new Edge(8, "E", "F"));
		edges.add(new Edge(9, "E", "G"));
		edges.add(new Edge(11, "F", "G"));
		String start = "A";
		ArrayList<String> connectNode = new ArrayList<>();
		HashMap<String, ArrayList<Edge>> hash = new HashMap<>();
		connectNode.add(start);
		
		for(int i = 0 ; i < edges.size() ; i++) {
			Edge edge = edges.get(i);
			if(!hash.containsKey(edge.node1)) {
				hash.put(edge.node1, new ArrayList<>());
			}
			if(!hash.containsKey(edge.node2)) {
				hash.put(edge.node2, new ArrayList<>());
			}
		}
		
		for(int i = 0 ; i < edges.size() ; i++) {
			Edge edge = edges.get(i);
			ArrayList<Edge> list = new ArrayList<>();
			list = hash.get(edge.node1);
			list.add(new Edge(edge.weight, edge.node1, edge.node2));
			list = hash.get(edge.node2);
			list.add(new Edge(edge.weight, edge.node2, edge.node1));
		}
		
		PriorityQueue<Edge> queue = new PriorityQueue<>();
		ArrayList<Edge> candidate = new ArrayList<>();
		candidate = hash.get(start);
		for(int i = 0 ; i < candidate.size() ; i++) {
			queue.add(candidate.get(i));
		}
		
		while(!queue.isEmpty()) {
			Edge edge = queue.poll();
			if(!connectNode.contains(edge.node2)) {
				connectNode.add(edge.node2);
				mst.add(edge);
				
				ArrayList<Edge> adjlist = new ArrayList<>();
				adjlist = hash.get(edge.node2);
				for(int i = 0 ; i < adjlist.size() ; i++) {
					Edge adjedge = adjlist.get(i);
					if(!connectNode.contains(adjedge.node2)) {
						queue.add(adjedge);
					}
				}
			}
		}
		System.out.println(mst);
	}
}
