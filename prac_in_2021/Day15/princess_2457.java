import java.io.*;
import java.util.Arrays;
import java.util.Comparator;
import java.util.StringTokenizer;
public class princess_2457 {

	//피는날짜를 기준ㅇ로 오름차순 / 지는 날짜를 기준으로 내림차순
	//96퍼에서 틀렸읍니다.... 이유를 알았읍니다 
	//왜 정답인지 모르겟지만 정답인 답안
	public static void main(String[] args) throws NumberFormatException, IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int n = Integer.parseInt(br.readLine());
		
		int f[][] = new int[n][2];
		
		for(int i = 0 ; i < n ; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			
			int a = Integer.parseInt(st.nextToken()) * 100;
			int b = Integer.parseInt(st.nextToken());
			
			f[i][0] = a+b;
			
			int c = Integer.parseInt(st.nextToken()) * 100;
			int d = Integer.parseInt(st.nextToken());
			
			f[i][1] = c+d;
		}
		
		Arrays.sort(f, new Comparator<int[]>() {
		    @Override
		    public int compare(int[] o1, int[] o2) {
		            if(o1[0] == o2[0]){
		                 //같은경우 배열의 두번째 열을 기준으로 오름차순으로 정렬/ 내린차순으로 하려면 o1,o2의 순서를 바꾸면됨
		    	    return o1[1] - o2[1];
		            }else {
		                //기본적으로 배열의 앞부분을 오름차순으로 정렬해줌 / 내림차순으로 하려면 o1, o2의 순서를 바꾸면됨
		                return o1[0] - o2[0];   
		            }
		    }
		});

		int max = 0;
		int idx = 0;
		//301 이하에서 가장 큰 값을 찾음
		for(int i = 0 ; i < n ; i++) {
			if(f[i][0] <= 301) {
				if(max < f[i][1]) {
					max = f[i][1];
				}
			}else {
				//301보다 큰 수가 나오는 순간 인덱스 저장 후 break;
				idx = i;
				break;
			}
		}
		
		//
		boolean boo = true;
		
		//처음부터 고른 꽃의 날짜가 1130보다 큰 경우 불리언을 거짓으로 설정 후
		//꽃을 하나만 심는것으로 조건을 만족하므로 1출력
		if(max > 1130) {
			System.out.println(1);
			boo = false;
		}
		
		//하나만으로 되지않는경우 if문 들어감
		if(boo) {
			//초기값은 무조건 2임. 왜냐하면 위에서 3월 1일전에 하나 골랐고
			//여기서 하나를 고르는 상태이기 때문에
			int count = 2;
			int max1 = 0;
			for(int i = idx ; i < n ; i++) {
				//max보다 피는날이 작은 날짜중 지는날이 가장 큰 날을 고름
				//지는날이 가장 큰날을 max1 에 저장
				if(f[i][0] <= max) {
					if(max1 < f[i][1]) {
						max1 = f[i][1];
					}
				//max보다 피는날이 더 큰 날이 나오는 경우
				}else {
					//max1 은 max보다 피는날이 작은날중 지는날이 가장 큰날의 값이 저장되어 있는데
					//max1 보다 크다는것은 중간에 값이 붕 뜬다는 이야기 이므로 count 에 0 저장후 더이상 볼 것없이 break;
					if(max1 < f[i][0]) {
						count = 0;
						break;
					//위의 조건을 만족하지 않는다면 다음의 피는날이 지는날의 가장 큰값인 max1 보다 작다는 이야기 이므로
					//붕뜨지 않고 이어진다는 이야기
					}else {
						//따라서 max 에 max1 을 넣어주고
						//현재 index부터 다시 검사하기 위해 i-- 해줌 for문이 끝나면 i++가 되기때문
						max = max1;
						i--;
						//꽃을 하나 더 선택한것이기 때문에 count++해줌
						count++;
					}
				}
				//for문이 끝나기전에 선택한 꽃의 지는날이 1130보다 큰 경우가 생기면 더이상 경우를 셀 이유가없으니
				//break;
				if(max1 > 1130) {
					break;
				}
			}
			//다 검사하고 나왔을때 지는날이 제일 큰 경우가 1130을 못넘기는 경우에는 조건을 절대 만족 불가하므로
			//답을 출력하는 count 변수를 0
			if(max1 <= 1130) {
				count = 0;
			}
			System.out.println(count);
		}
		
	}

}
