import java.util.Arrays;

public class Level1_Budget {

	public static void main(String[] args) {


	}
	
    public static int solution(int[] d, int budget) {
        
    	int answer = 0;
    	Arrays.sort(d);
    	for(int i = 0 ; i < d.length ; i++) {
    		if(budget < d[i]) break;
    		
    		budget -= d[i];
    		answer++;
    		
    	}
    	
    	return answer;
    	
    }

}
