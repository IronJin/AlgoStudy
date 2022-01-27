import java.io.*;
import java.util.*;

public class BOJ_2230 {

	static int n;
	static int m;
	static int arr[];
	
	static void pro() {
		int answer = Integer.MAX_VALUE;
		int left = 0;
		int right = 0;
		
		//right < n ���ν� right �� n�� �Ѿ�� ��������Ž���� �����ϵ��� ���������� �ϳ�
		//�� �κ��� �����ϰ� for������ �ذ��Ϸ��� ��
		while(right < n) {
			if(arr[right] - arr[left] < m) {
				right++;
			}else {
				answer = Math.min(answer, arr[right] - arr[left]);
				//right �� left �� ���ٴ°��� 0�� �ǹ��ϰ� �̴� ���̻� ������ ������ �ʴ´ٴ� ���� �ǹ��ϹǷ�
				//���̻� �������� Ž���� �������� �ʾƵ� ��
				if(right == left) {
					break;
				//�װ� �ƴ϶�� left �� ������Ű�� right �� left �� �� ���� ���Ͽ� �ݺ����� �°� �����ϵ�����
				}else {
					left++;
				}
			}
		}
		System.out.println(answer);
	}
	
	public static void main(String[] args) throws IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		n = Integer.parseInt(st.nextToken());
		m = Integer.parseInt(st.nextToken());
		arr = new int[n];
		for(int i = 0 ; i < n ; i++) {
			arr[i] = Integer.parseInt(br.readLine());
		}
		Arrays.sort(arr);
		
		pro();
		
	}

}
