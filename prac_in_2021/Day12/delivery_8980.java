import java.io.*;
import java.util.Arrays;
import java.util.Comparator;
import java.util.StringTokenizer;

//생각자체는 했지만 구현에서 오래걸렸던 문제

public class delivery_8980 {

	public static void main(String[] args) throws IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		//마을 개수
		int n = Integer.parseInt(st.nextToken());
		//택배 용량
		int c = Integer.parseInt(st.nextToken());

		//택배 정보
		int m = Integer.parseInt(br.readLine());
		
		//마을마다의 택배 최소 용량
		int t[] = new int[n];
		
		int info[][] = new int[m][3];
		
		for(int i = 0 ; i < m ; i++) {
			st = new StringTokenizer(br.readLine());
			
			//보내는 마을
			info[i][0] = Integer.parseInt(st.nextToken());
			//받는 마을
			info[i][1] = Integer.parseInt(st.nextToken());
			//택배용량
			info[i][2] = Integer.parseInt(st.nextToken());
		}
		
		//받는 마을을 기준으로 오름차순 정렬
		//받는 마을이 같은경우 보내는마을을 기준으로 오름차순 정렬
		Arrays.sort(info, new Comparator<int[]>() {
		    @Override
		    public int compare(int[] o1, int[] o2) {
		            if(o1[1] == o2[1]){
		                 //같은경우 배열의 두번째 열을 기준으로 오름차순으로 정렬/ 내린차순으로 하려면 o1,o2의 순서를 바꾸면됨
		            	return o1[0] - o2[0];
		            }else {
		                //기본적으로 배열의 앞부분을 오름차순으로 정렬해줌 / 내림차순으로 하려면 o1, o2의 순서를 바꾸면됨
		                return o1[1] - o2[1];      
		            }
		    }
		});

		for(int i = 0 ; i < t.length ; i++) {
			t[i] = c;
		}
		
		int count = 0;
		
		for(int i = 0 ; i < m ; i ++) {
			//최대 한도를 구함
			//min 은 최소를 구하는 값이여야하므로 택배 최대용량보다 큰 10001을 초기값으로 설정
			int min=10001;
			for(int j = info[i][0] ; j< info[i][1] ; j++) {
				if(t[j] < min) {
					min = t[j];
				}
			}
			
			//최대 한도보다 택배 용량이 적은경우
			//구간별 최대 한도를 택배용량만큼 빼줌
			if(info[i][2] < min) {
				for(int j = info[i][0] ; j < info[i][1] ; j++) {
					t[j] -= info[i][2];
				}
				count += info[i][2];
			//그게 아니라면 구간별 최대한도 만큼 빼줌
			}else {
				for(int j = info[i][0] ; j < info[i][1] ; j++) {
					t[j] -= min;
				}
				count += min;
			}
				
		}
		
		System.out.println(count);
		
	}

}
