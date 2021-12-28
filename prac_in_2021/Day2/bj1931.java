import java.io.*;
import java.util.Arrays;
import java.util.StringTokenizer;
import java.util.Comparator;

//백준에 제출하기전엔 Main으로 바꿔줄것
public class bj1931 {


	
	public static void main(String[] args) throws NumberFormatException, IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int n = Integer.parseInt(br.readLine());
		int [][] time= new int[n][2];
		
		for(int i = 0 ; i < n ; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			time[i][0] = Integer.parseInt(st.nextToken());
			time[i][1] = Integer.parseInt(st.nextToken());
		}
		
		//종료시간이 같은경우 시작시간이 빠른순으로 정렬
		//그 외에는 종료시간을 기준으로 오름차순으로 정렬
		Arrays.sort(time, new Comparator<int[]>() {
			@Override
			public int compare(int[] o1, int[] o2) {
				if(o1[1] == o2[1]) {
					return o1[0] - o2[0];
				}
				
				return o1[1] - o2[1];	
			}
		});
		
		int count = 0;
		int end_time = 0;
		for(int i = 0 ; i < n ; i ++) {
			if(end_time <= time[i][0]) {
				end_time = time[i][1];
				count++;
			}
		}
		
		System.out.println(count);
	}

}
