package algoprac;

import java.util.*;

public class Prim_basic {

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
		ArrayList<Edge> myedges = new ArrayList<>();
		myedges.add(new Edge(7, "A", "B"));
		myedges.add(new Edge(5, "A", "D"));
		myedges.add(new Edge(8, "B", "C"));
		myedges.add(new Edge(9, "B", "D"));
		myedges.add(new Edge(7, "D", "E"));
		myedges.add(new Edge(5, "C", "E"));
		myedges.add(new Edge(7, "B", "E"));
		myedges.add(new Edge(6, "D", "F"));
		myedges.add(new Edge(8, "E", "F"));
		myedges.add(new Edge(9, "E", "G"));
		myedges.add(new Edge(11, "F", "G"));
		
		String start = "A";
		
		//이미 선택된 노드들의 집합
		ArrayList<String> connode = new ArrayList<>();
		connode.add(start);
		
		//최소신장트리
		ArrayList<Edge> answer = new ArrayList<>();
		
		//각 노드에 연결된 간선들을 저장
		HashMap<String, ArrayList<Edge>> adjEdges = new HashMap<>();
		
		for(int i = 0 ; i < myedges.size() ; i++) {
			Edge curEdge = myedges.get(i);
			if(!adjEdges.containsKey(curEdge.node1)) {
				adjEdges.put(curEdge.node1, new ArrayList<Edge>());
			}
			if(!adjEdges.containsKey(curEdge.node2)) {
				adjEdges.put(curEdge.node2, new ArrayList<Edge>());
			}
		}
		
		ArrayList<Edge> list = new ArrayList<>();
		for(int i = 0 ; i < myedges.size() ; i++) {
			Edge curEdge = myedges.get(i);
			list = adjEdges.get(curEdge.node1);
			list.add(new Edge(curEdge.weight, curEdge.node1, curEdge.node2));
			list = adjEdges.get(curEdge.node2);
			list.add(new Edge(curEdge.weight, curEdge.node2, curEdge.node1));
		}
		
		PriorityQueue<Edge> queue = new PriorityQueue<>();
		ArrayList<Edge> candidate = new ArrayList<>();
		candidate = adjEdges.get(start);
		
		for(int i = 0 ; i < candidate.size() ; i++) {
			queue.add(candidate.get(i));
		}
		
		while(!queue.isEmpty()) {
			Edge pop = queue.poll();
			if(!connode.contains(pop.node2)) {
				connode.add(pop.node2);
				answer.add(new Edge(pop.weight, pop.node1, pop.node2));
				
				ArrayList<Edge> adjnode = new ArrayList<>();
				adjnode = adjEdges.getOrDefault(pop.node2, new ArrayList<>());
				for(int i = 0 ; i < adjnode.size() ; i++) {
					Edge e = adjnode.get(i);
					if(!connode.contains(e.node2)) {
						queue.add(e);
					}
				}
			}
		}
		
		System.out.println(answer);
	}

}
