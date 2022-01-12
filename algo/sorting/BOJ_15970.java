import java.io.*;
import java.util.*;

/*
 * ����Ǯ�� ���
 * 1. ���� ��ġ�� ������ �Է����� �����Ƿ� �̸� 2�����迭�� �����Ѵ�.
 * 2. ���� �������ؼ��� Ȯ���� �ϸ�ǹǷ� 2���� �迭�� ���� ������ ������ �� �������� ���ؼ��� ��ġ������ �����Ѵ�.
 * 3. �� ���� �����ϰ� �� �� ���� ���� Ȯ�����ָ�ȴ�. �װ� ���� ����� ���̱� �����̴�.
 * 4-1. �� ���� �Ȱ��� ���� ���� ������ �ִ��� Ȯ���ϰ� �Ȱ��� ���� ������ �ִ°�� �� �� �� �������� answer������ �־��ش�
 * 4-2. ���� �迭�� ���� ���� ���� �ٸ� ��� �׳� �� �� �ε����� ��ġ�� �迭�� ��ġ�� ���� ���� ��ġ�� ���ְ� answer �� �־��ش�.
 * 4-3. ���� �ε����� �迭�� ���� �ε����� �迭�� ���� ������ �� ���� �ε��� �迭�� ������ �ٸ���� ���� �ε����� ���� �ε��� ���� ��ġ�� ���� answer�� �����ش�.
 * 5. �� ó�� �ε����� ���� �� ������ �ε����� ���� �� ���� ���� �� ���� ������ �Ÿ��� �����ָ� �ǹǷ� ���� ������ �� �ϰ� �� �������� �׳� answer�� �����ش�. 
 */

public class BOJ_15970 {

	static int t;
	static int arr[][];
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		t = Integer.parseInt(br.readLine());
		arr = new int[t][2];
		
		for(int i = 0 ; i < t ; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			arr[i][0] = Integer.parseInt(st.nextToken());
			arr[i][1] = Integer.parseInt(st.nextToken());
		}
		
		Arrays.sort(arr, new Comparator<int[]>() {

			@Override
			public int compare(int[] o1, int[] o2) {
				if(o1[1] == o2[1]) {
					return o1[0] - o2[0];
				}else {
					return o1[1] - o2[1];
				}
			}
			
		});

		int answer = 0;
		
		for(int i = 1 ; i < t-1 ; i++) {
			if(arr[i+1][1] == arr[i][1] && arr[i][1] == arr[i-1][1]) {
				answer += Math.min(Math.abs(arr[i][0] - arr[i+1][0]), Math.abs(arr[i-1][0] - arr[i][0]));
			}else if(arr[i][1] != arr[i+1][1]) {
				answer += arr[i][0] - arr[i-1][0];
			}else {
				answer += arr[i+1][0] - arr[i][0];
			}
		}
		answer += arr[1][0] - arr[0][0];
		answer += arr[t-1][0] - arr[t-2][0];
		
		System.out.println(answer);
	}

}
