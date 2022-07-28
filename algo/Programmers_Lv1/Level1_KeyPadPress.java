/**
 * level1 _ 프로그래머스 키패드 누르기 문제
 * @author 82105
 *
 */
import java.util.*;

public class Level1_KeyPadPress {

	static int rightrow = 3;
	static int rightcol = 2;
	static int leftrow = 3;
	static int leftcol = 0;
	
	static HashMap<Integer, int[]> map = new HashMap<>();
	
	public static void main(String[] args) {
		
		int numbers[] = {1, 3, 4, 5, 8, 2, 1, 4, 5, 9, 5};
		String hand = "right";
		String answer = solution(numbers, hand);
		System.out.println(answer);
	}
	//"LRLLLRLLRRL"
	public static String solution(int[] numbers, String hand) {
        StringBuilder answer = new StringBuilder();
		
        map.put(2, new int[] {0,1});
        map.put(5, new int[] {1,1});
        map.put(8, new int[] {2,1});
        map.put(0, new int[] {3,1});
        map.put(1, new int[] {0,0});
        map.put(4, new int[] {1,0});
        map.put(7, new int[] {2,0});
        map.put(3, new int[] {0,2});
        map.put(6, new int[] {1,2});
        map.put(9, new int[] {2,2});
        
        for(int i = 0 ; i < numbers.length ; i++) {
    		int location[] = map.get(numbers[i]);
        	if(numbers[i] == 1 || numbers[i] == 4 || numbers[i] == 7) {
        		answer.append("L");
        		leftrow = location[0];
        		leftcol = location[1];
        	}else if(numbers[i] == 3 || numbers[i] == 6 || numbers[i] == 9) {
        		answer.append("R");
        		rightrow = location[0];
        		rightcol = location[1];
        	}else {
        		int rightdiff = Math.abs(rightrow - location[0]) + Math.abs(rightcol - location[1]);
        		int leftdiff = Math.abs(leftrow - location[0]) + Math.abs(leftcol - location[1]);
        		if(rightdiff == leftdiff) {
        			if(hand.equals("right")) {
        				answer.append("R");
        				rightrow = location[0];
        				rightcol = location[1];
        			}else {
        				answer.append("L");
        				leftrow = location[0];
        				leftcol = location[1];
        			}
        		}else if(rightdiff > leftdiff) {
        			answer.append("L");
        			leftrow = location[0];
        			leftcol = location[1];
        		}else {
        			answer.append("R");
        			rightrow = location[0];
        			rightcol = location[1];
        		}
        	}
        }
        
		return answer.toString();
    }

}
