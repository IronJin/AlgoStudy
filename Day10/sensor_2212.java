import java.io.*;
import java.util.Arrays;
import java.util.Collections;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class sensor_2212 {

	//문제 알고리즘을 30분정도 생각해보았으나 바로 생각하지 못함
	//차이 배열에서 기지국이 n개라면 배열에서 차이가 가장 큰 값을 n-1 개 뺄수있음.
	//ex)기지국 두개가 입력됐고 각 인접센서의 차이배열에  1 2 3 가 들어있으면 3을 빼면됨
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
