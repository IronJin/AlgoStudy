import java.util.*;

public class Level1_Two_plus {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
	
    public static ArrayList<Integer> solution(int[] numbers) {
       
    	ArrayList<Integer> answerlist = new ArrayList<>();
    	
    	for(int i = 0 ; i < numbers.length-1 ; i++) {
    		for(int j = i+1 ; j < numbers.length ; j++) {
    			int value = numbers[i] + numbers[j];
    			if(answerlist.contains(value)) {
    				continue;
    			}
    			answerlist.add(value);
    		}
    	}
    	
    	Collections.sort(answerlist);
    	
    	return answerlist;
    	
    }

}
