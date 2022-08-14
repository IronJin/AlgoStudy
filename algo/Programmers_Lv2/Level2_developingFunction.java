import java.util.*;

public class Level2_developingFunction {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
	
    public static ArrayList<Integer> solution(int[] progresses, int[] speeds) {
        ArrayList<Integer> answer = new ArrayList<>();
        
        int list[] = new int[progresses.length];
        
        for(int i = 0 ; i < progresses.length ; i++) {
        	int remainder = 100 - progresses[i];
        	
        	int count = remainder / speeds[i];
        	remainder %= speeds[i];
        	if(remainder != 0) {
        		count++;
        	}
        	
        	list[i] = count;
        }
        
        int max = 0;
        int count = 0;
        for(int i = 0 ; i < list.length ; i++) {
        	if(max >= list[i]) {
        		count++;
        	}else {
        		max = list[i];
        		answer.add(count);
        		count = 1;
        	}
        }
        answer.add(count);
        
        answer.remove(0);
        
        return answer;
    }

}
