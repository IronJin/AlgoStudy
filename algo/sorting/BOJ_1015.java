import java.io.*;
import java.util.*;

public class BOJ_1015 {

	static int n;
	static int array[][];
	/*
	 * 1. array[i][0] �� A�迭�� ������ ���ʴ�� �־��ְ� array[i][1] �� �� ����� index�� ����ϰ� �־���
	 * 2. array[i][0] �� �������� ������ ������ �� array[i][2] �� index�� ���ʴ�� ����
	 * 3. array[i][1] �� �������� �ٽ� �������� ������ ���ָ� ����P �� �ش��ϴ� ���� ���� ���Ե� ���Ҽ����� ��µȴ�.
	 */
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		n = Integer.parseInt(br.readLine());
		StringTokenizer st = new StringTokenizer(br.readLine());
		array = new int[n][3];
		for(int i = 0 ; i < array.length ;i++) {
			array[i][0] = Integer.parseInt(st.nextToken());
			array[i][1] = i;
		}
		
		
		Arrays.sort(array, new Comparator<int[]>() {
			@Override
			public int compare(int[] o1, int[] o2) {
				if(o1[0] == o2[0]) {
					return o1[1] - o2[1];
				}else {
					return o1[0] - o2[0];
				}
			}
		});
		
		for(int i = 0 ; i < array.length ; i++) {
			array[i][2] = i;
		}
		
		Arrays.sort(array, new Comparator<int[]>() {

			@Override
			public int compare(int[] o1, int[] o2) {
				// TODO Auto-generated method stub
				return o1[1] - o2[1];
			}
		});
		
		for(int i = 0 ; i < array.length ; i++) {
			System.out.print(array[i][2]+" ");
		}
	}
}
