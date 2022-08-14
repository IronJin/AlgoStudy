import java.util.*;

public class Level2_TakePicture {

	static int answer;
	//8명
	static String member[] = {"A","C","F","J","M","N","R","T"};
	static boolean used[];
	public static void main(String[] args) {
		
		String []data = {"N~F=0", "R~T>2"};
		
		System.out.println(solution(2,data));
	}

    public static int solution(int n, String[] data) {
        answer = 0;
    	used = new boolean[8];
    	
        dfs("", 0, data);
        
        return answer;
    }
    
    static void dfs(String str, int depth, String[] data) {
    	if(depth == 8) {
    		if(check(str, data)) {
    			answer++;
    		}
    	} else {
    		for(int i = 0 ; i < 8 ; i++) {
    			if(used[i] == false) {
    				used[i] = true;
    				str += member[i];
    				dfs(str, depth+1, data);
    				str = str.replace(member[i], "");
    				used[i] = false;
    			}
    		}
    	}
    }
    
    static boolean check(String str, String[] data) {
    	
    	for(int i = 0 ; i < data.length ; i++) {
    		
    		String name1 = String.valueOf(data[i].charAt(0));
    		String name2 = String.valueOf(data[i].charAt(2));
    		String condition = String.valueOf(data[i].charAt(3));
    		String number = String.valueOf(data[i].charAt(4));
    		
    		//조건에 부합하는지 확인하기
    		int index1 = str.indexOf(name1);
    		int index2 = str.indexOf(name2);
    		int diff = Math.abs(index1 - index2) -1;
    		if(condition.equals(">")) {
    			if(diff <= Integer.parseInt(number)) return false;
    		} else if(condition.equals("<")) {
    			if(diff >= Integer.parseInt(number)) return false;
    		} else {
    			if(diff != Integer.parseInt(number)) return false;
    		}
    		
    	}
    	
    	return true;
    }
    
    
    
	
}
