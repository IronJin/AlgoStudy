import java.io.*;
import java.util.StringTokenizer;

public class secret {
	
	//Ǯ�̽ð� 50��
	//�ַ�� �Լ����� �迭 �ʱ�ȭ�� ������ϳ�
	//�Ѱ��ְ� ���� ��� ���� null##### �̷������� ����;

	public static void main(String[] args) throws NumberFormatException, IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int n = Integer.parseInt(br.readLine());
		
		int arr1[]= new int[n];
		int arr2[] = new int[n];
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		for(int i = 0 ; i < n ; i++) {
			arr1[i]= Integer.parseInt(st.nextToken());
		}
		st = new StringTokenizer(br.readLine());
		for(int i = 0 ; i < n ; i++) {
			arr2[i] = Integer.parseInt(st.nextToken());
		}
		String answer[];
		answer = solution(n,arr1,arr2);
		for(int i = 0 ; i < answer.length ; i++) {
			System.out.print(answer[i].length());
			System.out.print(answer[i]);
			System.out.println();
		}
	}
	
	public static String[] solution(int n ,int arr1[], int arr2[]) {
		String answer[] = new String[n];
		
		boolean ar[][] = new boolean[n][n];
		int count = 1;
		
		//�������� ��Ÿ���� ���� ��
		for(int i = 0 ; i < n-1 ; i++) {
			count *= 2;
		}
		for(int i = 0 ; i < n ; i++) {
			int count1 = count;
			int a = arr1[i];
			for(int j = 0 ; j < n ; j++) {
				if(count1 <= a) {
					a -= count1;
					ar[i][j] = true;
				}
				count1 = count1/2;
			}
		}
		
		for(int i = 0 ; i < n ; i++) {
			int count1 = count;
			int a = arr2[i];
			for(int j = 0 ; j < n ; j++) {
				if(count1 <= a) {
					a -= count1;
					ar[i][j] = true;
				}
				count1 = count1/2;
			}
		}
		
		for(int i = 0 ; i < n ; i++) {
			answer[i] = "";
		}
		
		for(int i = 0 ; i < n ; i++) {
			for(int j = 0 ; j < n ; j++) {
				if(ar[i][j] == true) {
					answer[i] += "#";
				}else {
					answer[i] += " ";
				}
			}
		}
		
		return answer;
	}

}
