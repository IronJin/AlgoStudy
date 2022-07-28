
public class Level1_MinimumRectangle {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

    public int solution(int[][] sizes) {
    	
    	int row = 0;
    	int col = 0;
        
    	for(int i = 0 ; i < sizes.length ; i++) {
    		if(sizes[i][0] < sizes[i][1]) {
    			int temp = sizes[i][0];
    			sizes[i][0] = sizes[i][1];
    			sizes[i][1] = temp;
    		}
    		
    		row = Math.max(row, sizes[i][0]);
    		col = Math.max(col, sizes[i][1]);
    		
    	}
    	
    	return row * col;
    	
    	
    	
    }
	
}
