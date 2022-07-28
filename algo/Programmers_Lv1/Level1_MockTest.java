
import java.util.*;

public class Level1_MockTest {

	public static void main(String[] args) {
		
		int answers[] = {1,3,2,4,2};
		solution(answers);

	}
	
	public static int[] solution(int[] answers) {
        
		int one[] = {1,2,3,4,5};
		int two[]= {2,1,2,3,2,4,2,5};
		int three[] = {3,3,1,1,2,2,4,4,5,5};
		
		HashMap<Integer, Integer> map = new HashMap<>();
		map.put(1, 0);
		map.put(2, 0);
		map.put(3, 0);
		
		for(int i = 0 ; i < answers.length ; i++) {
			
			int fiveindex = i % 5;
			int eightindex = i % 8;
			int tenindex = i % 10;
			
			if(answers[i] == one[fiveindex]) {
				map.put(1, map.get(1) + 1);
			}
			
			if(answers[i] == two[eightindex]) {
				map.put(2, map.get(2) + 1);
			}
			
			if(answers[i] == three[tenindex]) {
				map.put(3, map.get(3) + 1);
			}
		}
	
		
		ArrayList<Integer> list = new ArrayList<>();
		
		list.add(1);
		for(int i = 2 ; i <= 3 ; i++) {
			if(map.get(list.get(0)).equals(map.get(i))) {
				list.add(i);
			}else if(map.get(list.get(0)) < map.get(i)) {
				list.clear();
				list.add(i);
			}
		}
		
		int answer[] = new int[list.size()];
		for(int i = 0 ; i < list.size();  i++) {
			answer[i] = list.get(i);
		}
		return answer;
    }

}
