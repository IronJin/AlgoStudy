import java.util.Arrays;

public class Level2_directions {

	public static void main(String[] args) {
		
		

	}
	
    public static boolean solution(String[] book) {
    	
    	Arrays.sort(book);
    	
    	for(int i = 1 ; i < book.length ; i++) {
    		if(book[i].startsWith(book[i-1])) {
    			return false;
    		}
    	}
    	
    	return true;
    }
    	
}