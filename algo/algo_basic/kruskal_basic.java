package algoprac;

import java.util.*;

public class kruskal_basic {

	
	//현재 노드와 부모노드의 정보를 갖는 해쉬맵
	static HashMap<String, String> parent = new HashMap<>();
	static HashMap<String, Integer> rank = new HashMap<>();	
	
	//간선을 오름차순으로 정렬해야하므로 간선을 잇는 두 정점과 가중치 변수 선언
	static class Edge implements Comparable<Edge>{
	
		public int weight;
		public String nodeV;
		public String nodeU;
		
		public Edge(int weight, String nodeV, String nodeU) {
			this.weight = weight;
			this.nodeV = nodeV;
			this.nodeU = nodeU;
		}
		
		@Override
		public String toString() {
			return this.weight+" "+this.nodeV+" "+this.nodeU;
		}

		@Override
		public int compareTo(Edge o) {
			return this.weight - o.weight;
		}
	}
	
	//union-find 알고리즘
	
	//find ==> 부모노드를 리턴해줌
	public static String find(String node) {
		//path compression
		//현재 노드의 부모노드와 현재 노드가 일치하지 않는다면 현재노드를 부모노드 아래로 붙여줌
		if(parent.get(node) != node) {
			parent.put(node, find(parent.get(node)));
		}
		return parent.get(node);
	}
	
	//union ==> cycle 이 안생길때만 호출함
	//두개의 루트노드를 갖고 하나의 트리로 합치는 과정임
	public static void union(String nodeV, String nodeU) {
		String root1 = find(nodeV);
		String root2 = find(nodeU);
		
		//union by rank 기법
		//높이가 다를때는 높이가 큰쪽에 붙어라. 높이가 같으면 높이 하나를 높이고 한쪽에 붙어라
		if(rank.get(root1) > rank.get(root2)) {
			parent.put(root2, root1);
		}else {
			parent.put(root1, root2);
			//만약 둘이 같은 높이를 가진 랭크라면 root2 의 랭크를 하나 높여줘야하므로
			if(rank.get(root1) == rank.get(root2)) {
				rank.put(root2, rank.get(root2)+1);
			}
		}
	}
	
	//처음에는 개별집합으로 존재하므로 초기화 해주는 작업
	public static void makeSet(String node) {
		parent.put(node, node);
		rank.put(node, 0);
	}
	
	public static void main(String[] args) {
		
		ArrayList<String> vetices = new ArrayList<String>(Arrays.asList("A","B","C","D","E","F","G"));
		ArrayList<Edge> edges = new ArrayList<>();
		edges.add(new Edge(7, "A", "B"));
		edges.add(new Edge(5, "A", "D"));
		edges.add(new Edge(7, "B", "A"));
		edges.add(new Edge(8, "B", "C"));
		edges.add(new Edge(9, "B", "D"));
		edges.add(new Edge(7, "B", "E"));
		edges.add(new Edge(8, "C", "B"));
		edges.add(new Edge(5, "C", "E"));
		edges.add(new Edge(5, "D", "A"));
		edges.add(new Edge(9, "D", "B"));
		edges.add(new Edge(7, "D", "E"));
		edges.add(new Edge(6, "D", "F"));
		edges.add(new Edge(7, "E", "B"));
		edges.add(new Edge(5, "E", "C"));
		edges.add(new Edge(7, "E", "D"));
		edges.add(new Edge(8, "E", "F"));
		edges.add(new Edge(9, "E", "G"));
		edges.add(new Edge(6, "F", "D"));
		edges.add(new Edge(8, "F", "E"));
		edges.add(new Edge(11, "F", "G"));
		edges.add(new Edge(9, "G", "E"));
		edges.add(new Edge(11, "G", "F"));
		

		
		ArrayList<Edge> answer = new ArrayList<>();
		
		
		
		//초기화 작업
		for(int i = 0 ; i < vetices.size() ; i++) {
			makeSet(vetices.get(i));
		}
		
		Collections.sort(edges);
	
		for(int i = 0 ; i < edges.size() ; i++) {
			Edge curEdge = edges.get(i);
			String nodeV = curEdge.nodeV;
			String nodeU = curEdge.nodeU;
			
			if(find(nodeV) != find(nodeU)) {
				union(nodeV,nodeU);
				answer.add(curEdge);
			}
		}
		
		System.out.println(answer);
		
		
	}
}
