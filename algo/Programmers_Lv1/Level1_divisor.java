
public class Level1_divisor {

	public static void main(String[] args) {
		

	}
	
    public int solution(int left, int right) {
        int answer = 0;
        
        for(int cur = left ; cur <= right ; cur++) {
        	
        	int count = 0;
        	
        	for(int i = 1 ; i <= cur ; i++) {
        		if(cur % i == 0) {
        			count++;
        		}
        	}
        	
        	if(count % 2 != 0) {
        		answer -= cur;
        	}else {
        		answer += cur;
        	}
        	
        }

        return answer;
    }

}
