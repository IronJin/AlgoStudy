import java.util.*;
public class Level2_RotateMatrix {

	static int arr[][];
	
	public static void main(String[] args) {
		int aa[][] = {{2,2,5,4},{3,3,6,6},{5,1,6,3}};
		ArrayList<Integer> list = solution(6,6,aa);
		for(int i = 0 ; i < list.size() ; i ++) {
			System.out.print(list.get(i)+" ");
		}
	}
	
    public static ArrayList<Integer> solution(int row, int col, int[][] queries) {
        ArrayList<Integer> answer = new ArrayList<>();
        arr = new int[row][col];
        int count = 1;
        for(int i = 0 ; i < row ; i++) {
        	for(int j = 0 ; j < col ; j++) {
        		arr[i][j] = count;
        		count++;
        	}
        }
        
        for(int i = 0 ; i < queries.length ; i++) {
        	int startrow = queries[i][0]-1;
        	int startcol = queries[i][1]-1;
        	int endrow = queries[i][2]-1;
        	int endcol = queries[i][3]-1;
        	
        	int min = Integer.MAX_VALUE;

        	
        	for(int a = startrow ; a <= endrow ; a++) {
        		for(int b = startcol ; b <= endcol ; b++) {
        			if(a != startrow && a != endrow) {
        				min = Math.min(min, Math.min(arr[a][startcol], arr[a][endcol]));
        			}else {
        				min = Math.min(min, arr[a][b]);
        			}
        		}
        	}
        	
        	//ȸ�������ٰ�
        	rotate(startrow, startcol, endrow, endcol);
        	
        	for(int k = 0 ; k < row ; k++) {
        		for(int j = 0 ; j < col ; j++) {
        			System.out.print(arr[k][j]+" ");
        		}
        		System.out.println();
        	}
        	System.out.println();
        	answer.add(min);
        }
        
        
        return answer;
    }
    
    //rotate �Լ�
    static void rotate(int startrow, int startcol, int endrow, int endcol) {
    	
    	//���� �� �̵������ֱ� -> ���������� ��ĭ�� �̵��Ұ�
    	int temp = arr[startrow][endcol];
    	for(int i = endcol ; i > startcol ; i--) {
    		arr[startrow][i] = arr[startrow][i-1];
    	}
    	
    	//�� ������ �� �ٲ��ֱ�
    	int temp2 = arr[endrow][endcol];
    	for(int i = endrow ; i > startrow ; i--) {
    		arr[i][endcol] = arr[i-1][endcol];
    	}
    	arr[startrow +1][endcol] = temp;
    	
    	//�� �Ʒ��� ȸ�������ֱ�
    	int temp3 = arr[endrow][startcol];
    	for(int i = startcol ; i < endcol ; i++) {
    		arr[endrow][i] = arr[endrow][i+1];
    	}
    	arr[endrow][endcol-1] = temp2;
    	
    	//�� ���� �� ȸ�������ֱ�
    	for(int i = startrow ; i < endrow ; i++) {
    		arr[i][startcol] = arr[i+1][startcol];
    	}
    	arr[endrow-1][startcol] = temp3;
    }
    
	
}
