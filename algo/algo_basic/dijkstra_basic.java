package algoprac;

import java.util.*;

public class dijkstra_basic {

	static class Node implements Comparable<Node> {
		String vertex;
		int cost;
		
		Node(int cost ,String vertex){
			this.cost = cost;
			this.vertex = vertex;
		}

		//System.out.println() 으로 객체 자체 출력시,
		public String toString() {
			return "vertex:" +this.vertex+", distance:"+this.cost;
		}
		
		@Override
		public int compareTo(Node node) {
			return this.cost - node.cost;
		}
	}
	
	public static void main(String[] args) {
		
		HashMap<String, ArrayList<Node>> graph = new HashMap<>();
		graph.put("A", new ArrayList<Node>(Arrays.asList(new Node(8, "B"), new Node(1, "C"), new Node(2, "D"))));
		graph.put("B", new ArrayList<Node>());
		graph.put("C", new ArrayList<Node>(Arrays.asList(new Node(5, "B"), new Node(2, "D"))));
		graph.put("D", new ArrayList<Node>(Arrays.asList(new Node(3, "E"), new Node(5, "F"))));
		graph.put("E", new ArrayList<Node>(Arrays.asList(new Node(1, "F"))));
		graph.put("F", new ArrayList<Node>(Arrays.asList(new Node(5, "A"))));
		ArrayList<Node> nodelist = new ArrayList<>();
		//출력할 답
		HashMap<String, Integer> dist = new HashMap<>();
		
		String start = "A";
		
		for(String key : graph.keySet()) {
			dist.put(key, Integer.MAX_VALUE);
		}
		dist.put(start, 0);
		
		PriorityQueue<Node> queue = new PriorityQueue<>();
		queue.add(new Node(dist.get(start),start));
		
		while(!queue.isEmpty()) {

			Node curNode = queue.poll();
			String curvertex = curNode.vertex;
			int curdist = curNode.cost;
			
			if(dist.get(curvertex) < curdist) {
				continue;
			}
			
			nodelist = graph.get(curvertex);
			
			for(int i = 0 ; i < nodelist.size() ; i++) {
				Node adjnode = nodelist.get(i);
				String adjvertex = adjnode.vertex;
				int adjdist = adjnode.cost;
				int sumdist = curdist+adjdist;
				if(sumdist < dist.get(adjvertex)) {
					dist.put(adjvertex, sumdist);
					queue.add(new Node(sumdist,adjvertex));
				}
			}
		}
		
		System.out.println(dist);
	}

}
