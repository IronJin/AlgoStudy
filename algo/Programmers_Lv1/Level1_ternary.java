import java.util.*;

public class Level1_ternary {

	public static void main(String[] args) {
		
		String str = "-1234";
		System.out.println(Integer.parseInt(str));
		
		int answer = solution(13);
		
		System.out.println(answer);
	}
	
    public static int solution(int n) {

    	int answer = 0;
    	
    	ArrayList<Integer> list = new ArrayList<>();
        
    	while(n > 0) {
    		list.add(n%3);
    		n /= 3;
    	}
    	
    	for(int i = 0 ; i < list.size(); i ++) {
    		System.out.println(list.get(i));
    	}
        
    	for(int i = list.size() -1 ; i >= 0 ; i--) {
    		answer += (int)Math.pow(3,list.size()-1-i) * list.get(i);
    	}
    	
    	return answer;
    }

}
