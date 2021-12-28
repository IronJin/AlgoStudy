package algoprac;
import java.util.*;

public class BFS_usingHash {

	public static ArrayList<String> bfs(HashMap<String, ArrayList<String>> graph, String str){
		ArrayList<String> visited = new ArrayList<String>();
		ArrayList<String> needvisit = new ArrayList<String>();
		
		needvisit.add(str);
		
		while(!needvisit.isEmpty()) {
			//맨 앞에 있는 노드를 가져오는것은 큐를 사용한 것과 같음
			String node = needvisit.remove(0);
			
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
		
		System.out.println(bfs(graph,"A"));
	}

}
