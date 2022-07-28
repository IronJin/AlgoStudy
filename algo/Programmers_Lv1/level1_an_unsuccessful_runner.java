
/**
 * 완주하지 못한 선수
 * @author 82105
 *
 */
import java.util.*;

public class level1_an_unsuccessful_runner {
	
	public static void main(String[] args) {
		
		String participant[] = {"leo", "kiki", "eden"};
		String completion[] = {"eden", "kiki"};
		
		String answer = solution(participant, completion);
		System.out.println(answer);
		
	}
	
	public static String solution(String[] participant, String[] completion) {

		HashMap<String, Integer> map = new HashMap<>();
		
		for(int i = 0 ; i < participant.length ; i++) {
			if(!map.containsKey(participant[i])) {
				map.put(participant[i], 1);
			}else {
				map.put(participant[i], map.get(participant[i]) + 1);
			}
		}
		
		for(int i = 0 ; i < completion.length ; i++) {
			map.put(completion[i], map.get(completion[i])-1);
			if(map.get(completion[i]) == 0) {
				map.remove(completion[i]);
			}
		}
		
		for(String key : map.keySet()) {
			return key;
		}
		
		return null;
		
    }

}
