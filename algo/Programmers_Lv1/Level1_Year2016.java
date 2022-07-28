
public class Level1_Year2016 {

	public static void main(String[] args) {

		String answer = solution(1,1);
		System.out.println(answer);

	}
	
    public static String solution(int a, int b) {
    	String[] answer = {"FRI", "SAT", "SUN", "MON", "TUE", "WED", "THU"};
    	
    	int total = -1;
    	int index = 0;
    	
    	int[] days = {0, 31, 29, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31};
    	
    	for(int i = 0 ; i < a ; i++) {
    		total += days[i];
    	}
    	total += b;
    	
    	index = total % 7;
    	
    	return answer[index];
    }

}
