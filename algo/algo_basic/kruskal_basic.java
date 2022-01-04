package algoprac;

import java.util.*;

public class kruskal_basic {

	
	//���� ���� �θ����� ������ ���� �ؽ���
	static HashMap<String, String> parent = new HashMap<>();
	static HashMap<String, Integer> rank = new HashMap<>();	
	
	//������ ������������ �����ؾ��ϹǷ� ������ �մ� �� ������ ����ġ ���� ����
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
	
	//union-find �˰���
	
	//find ==> �θ��带 ��������
	public static String find(String node) {
		//path compression
		//���� ����� �θ���� ���� ��尡 ��ġ���� �ʴ´ٸ� �����带 �θ��� �Ʒ��� �ٿ���
		if(parent.get(node) != node) {
			parent.put(node, find(parent.get(node)));
		}
		return parent.get(node);
	}
	
	//union ==> cycle �� �Ȼ��涧�� ȣ����
	//�ΰ��� ��Ʈ��带 ���� �ϳ��� Ʈ���� ��ġ�� ������
	public static void union(String nodeV, String nodeU) {
		String root1 = find(nodeV);
		String root2 = find(nodeU);
		
		//union by rank ���
		//���̰� �ٸ����� ���̰� ū�ʿ� �پ��. ���̰� ������ ���� �ϳ��� ���̰� ���ʿ� �پ��
		if(rank.get(root1) > rank.get(root2)) {
			parent.put(root2, root1);
		}else {
			parent.put(root1, root2);
			//���� ���� ���� ���̸� ���� ��ũ��� root2 �� ��ũ�� �ϳ� ��������ϹǷ�
			if(rank.get(root1) == rank.get(root2)) {
				rank.put(root2, rank.get(root2)+1);
			}
		}
	}
	
	//ó������ ������������ �����ϹǷ� �ʱ�ȭ ���ִ� �۾�
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
		
		
		
		//�ʱ�ȭ �۾�
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
