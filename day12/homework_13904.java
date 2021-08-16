import java.io.*;
import java.util.Arrays;
import java.util.Collections;
import java.util.PriorityQueue;
import java.util.StringTokenizer;
import java.util.*;

//Ǯ�̽ð� �ѽð�
public class homework_13904 {
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int n = Integer.parseInt(br.readLine());
		
		int a[][] = new int[n][2];
		
		StringTokenizer st;
		for(int i = 0 ; i < n ; i++) {
			st = new StringTokenizer(br.readLine());
			a[i][0] = Integer.parseInt(st.nextToken());
			a[i][1] = Integer.parseInt(st.nextToken());		
		}
		int count = 0;
		
		PriorityQueue<Integer> pq = new PriorityQueue<>(Collections.reverseOrder());

		//day �� �������� �������� ����
		//�������� ������ �������� ����
		Arrays.sort(a, new Comparator<int[]>() {
		    public int compare(int[] o1, int[] o2) {
		            if(o2[0] == o1[0]){
		    	    return o2[1] - o1[1];
		            }else {
		                return o2[0] - o1[0]  ;    
		            }
		    }
		});

		//�������� �����̹Ƿ� �Էµ� ���̽��� ���� ū ��¥�� �ʱ� day ���������� ����
		int day = a[0][0];
		//i�� �迭 �ε����� ����ų ������
		int i = 0;
		
		//day�� 0�̵Ǹ� ����
		while(day !=0) {
			//���ĵ� �迭�� �������� ���ʺ��� ���캽 day���� ū day�� ������ �ִ� ���
			//�� �ε����� ������ �켱����ť�� �־���
			//day �� i�� ����Ű�� �ε����� day���� Ŭ������ ������
			//i!=n �� ������ �迭�� day���� day ���� ������ ��� Ŭ�� �ֱ⶧��
			while(i != n) {
				if(day <= a[i][0]) {
					pq.add(a[i][1]);
					i++;	
				}else break;
			}
			
			//pq �� ������� �ʴٸ� ���߿��� ���� ū �������� count �� �����ְ� �Ϸ縦 �Һ������Ƿ� pq.poll ����
			if(!pq.isEmpty()) {
				count += pq.poll();
				day--;
			//else �� �� ������ pq�� ���������� poll �Ҷ� ������ �� �� �ֱ� ����
			}else day--; continue;
		}
		
		
		System.out.println(count);
		
	}

}
