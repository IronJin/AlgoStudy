package algoprac;

import java.util.*;

public class DFS_usingHash {

	public static ArrayList<String> dfs(HashMap<String, ArrayList<String>> graph, String start){
		ArrayList<String> visited = new ArrayList<>();
		ArrayList<String> needvisit = new ArrayList<>();
		
		needvisit.add(start);
		
		while(!needvisit.isEmpty()) {
			String node = needvisit.remove(needvisit.size()-1);
			
			if(!visited.contains(node)) {
				visited.add(node);
				needvisit.addAll(graph.get(node));
			}
		}
		return visited;
	}
	
	public static void main(String[] args) {
		
		HashMap<String, ArrayList<String>> graph = new HashMap<>();

		graph.put("A", new ArrayList<String>(Arrays.asList("B", "C")));
		graph.put("B", new ArrayList<String>(Arrays.asList("A", "D")));
		graph.put("C", new ArrayList<String>(Arrays.asList("A", "G", "H", "I")));
		graph.put("D", new ArrayList<String>(Arrays.asList("B", "E", "F")));
		graph.put("E", new ArrayList<String>(Arrays.asList("D")));
		graph.put("F", new ArrayList<String>(Arrays.asList("D")));
		graph.put("G", new ArrayList<String>(Arrays.asList("C")));
		graph.put("H", new ArrayList<String>(Arrays.asList("C")));
		graph.put("I", new ArrayList<String>(Arrays.asList("C", "J")));
		graph.put("J", new ArrayList<String>(Arrays.asList("I")));
		
		System.out.println(dfs(graph,"A"));
	}

}
