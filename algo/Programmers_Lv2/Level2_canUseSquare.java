import java.util.*;
public class Level2_canUseSquare {

	static long answer = 0;
	
	public static void main(String[] args) {
		
		long answer = solution(8,12);
		System.out.println(answer);
		

	}

    public static long solution(long col, long row) {
    	answer = row * col;
    	long maxdivisor = 0;
        ArrayList<Integer> colList = new ArrayList<>();
        for(int i = 1 ; i <= col ; i++) {
        	if(col % i == 0) {
        		colList.add(i);
        	}
        }
        for(int i = 0; i < colList.size() ; i++) {
        	int value = colList.get(i);
        	if(row % value == 0) {
        		maxdivisor = Math.max(maxdivisor, value);
        	}
        }
        
        long revisedCol = col/maxdivisor;
        long revisedRow = row/maxdivisor;
        //�ִ� ������� ���ϴ� ��� ��
        
        //���α��� + ���α��� - 1
        answer -= (revisedRow + revisedCol -1)*maxdivisor;
        
        
        return answer;
    }
    
    
	
}
