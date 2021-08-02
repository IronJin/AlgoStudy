import java.io.*;
import java.util.Arrays;
import java.util.Collections;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class sensor_2212 {

	//���� �˰����� 30������ �����غ������� �ٷ� �������� ����
	//���� �迭���� �������� n����� �迭���� ���̰� ���� ū ���� n-1 �� ��������.
	//ex)������ �ΰ��� �Էµư� �� ���������� ���̹迭��  1 2 3 �� ��������� 3�� �����
	public static void main(String[] args) throws NumberFormatException, IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int s = Integer.parseInt(br.readLine());
		int k = Integer.parseInt(br.readLine());
		int sum = 0;
		int a[] = new int[s];
		PriorityQueue<Integer> pq = new PriorityQueue<>(Collections.reverseOrder());
		StringTokenizer st = new StringTokenizer(br.readLine());
		for(int i = 0 ; i < s ; i++) {
			a[i] = Integer.parseInt(st.nextToken());
		}
		
		Arrays.sort(a);
		
		for(int i = 0 ; i < s-1 ; i++) {
			pq.add(a[i+1] - a[i]);
		}
		
		for(int i = 0 ; i < k-1 ; i++) {
			pq.poll();
		}
		
		while(!pq.isEmpty()) {
			sum += pq.poll();
		}
		
		System.out.println(sum);
	}

}
