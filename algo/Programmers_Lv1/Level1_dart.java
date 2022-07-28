import java.util.*;
public class Level1_dart {

	public static void main(String[] args) {
		int answer = solution("1D2S#10S");
		System.out.println(answer);
	}

    public static int solution(String dartResult) {
        int answer= 0;
    	
        HashMap<Character, Integer> hash = new HashMap<>();
        
        hash.put('S',1);
        hash.put('D',2);
        hash.put('T',3);
        
        ArrayList<Integer> list = new ArrayList<>();
        list.add(0);
        
        String cur = "";
        int index = 0;
        for(int i = 0 ; i < dartResult.length() ; i++) {
        	if(dartResult.charAt(i) == 'S' || dartResult.charAt(i) == 'D' || dartResult.charAt(i) == 'T') {
        		int number = Integer.parseInt(cur);
        		cur = "";
        		number = (int) Math.pow(number, hash.get(dartResult.charAt(i)));
        		list.add(number);
        	}else if(dartResult.charAt(i) =='*') {
        		list.set(index, list.get(index) * 2);
        		list.set(index -1, list.get(index-1) *2);
        	}else if(dartResult.charAt(i) == '#') {
        		list.set(index, list.get(index) * -1);
        	}else { //숫자인 경우
        		index ++;
        		cur += String.valueOf(dartResult.charAt(i));
        	}
        }
        
        for(int i = 0 ; i < list.size() ; i++) {
        	System.out.println(list.get(i));
        	answer += list.get(i);
        }
        
        
        return answer;
    }
	
}
