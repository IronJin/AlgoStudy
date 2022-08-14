import java.util.*;

public class Level2_tuple {

	public static void main(String[] args) {
		
		solution("{{1,2,3},{2,1},{1,2,4,3,2},{2}}");

	}

    public static int[] solution(String s) {
        
    	ArrayList<Integer> list = new ArrayList<>();
    	StringTokenizer st = new StringTokenizer(s,"}");
    	
    	while(st.hasMoreTokens()) {
    		String str = st.nextToken();
    		str = str.replace("{", "");
    		str = str.replace("}", "");
    		StringTokenizer st1 = new StringTokenizer(str, ",");
    		HashSet<String> set = new HashSet<>();
    		
    		while(st1.hasMoreTokens()) {
    			String copy = st1.nextToken();
    			//System.out.println(copy);
    			if(set.contains(copy)) {
    				str = str.replaceFirst(copy, "");
    			}else {
    				set.add(copy);
    			}
    		}
    		str = str.replace(",", "");
    		list.add(Integer.parseInt(str));
    	}
    	
    	Collections.sort(list);
    	
    	String arr[] = new String[list.size()];

    	
    	for(int i = 0 ; i < list.size(); i++) {
    		arr[i] = list.get(i).toString();
    	}

    	for(int i = 1 ; i < list.size(); i++) {
    		for(int j = 0 ; j < i ; j++) {
    			arr[i] = arr[i].replaceFirst(arr[j], "");
    		}
    	}

    	int answer[] = new int[arr.length];
    	
    	for(int i = 0 ; i < arr.length ; i++) {
    		answer[i] = Integer.parseInt(arr[i]);
    	}
    	
//    	for(int i = 0 ; i < answer.length ; i++) {
//    		System.out.println(answer[i]);
//    	}
        return answer;
    }
	
}
