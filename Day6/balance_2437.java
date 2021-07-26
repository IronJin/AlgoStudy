import java.io.*;
import java.util.Arrays;
import java.util.StringTokenizer;

/*
 그리디 스럽게 푼 문제는 아님
 ex) 예제에 17이라는 숫자가 주어짐
 이러한 경우 배열중에서 이보다 작은 숫자부터 빼주는거임
 백준의 예제의 경우 1 1 2 3 6 7 30 이니까 배열에서 17보다 작은 숫자는 7
 빼주고 남은거는 10 여기서 그다음 배열부터 만족하는 작은 숫자는 6
 그다음은 3 그다음은 1
 이런식으로 활용해나가면서 보다보면 만족하지 못하는 숫자가 생기는 순간이 생김
 이러한 경우 두번째 와일문을 다 돌리고 나와도 만들지 못하는 숫자이므로 break 를 통해 빠져나오고 이 때 테스트한 숫자를 출력
 */

//테스트 시간 1584ms

public class balance_2437 {

	public static void main(String[] args) throws NumberFormatException, IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int n = Integer.parseInt(br.readLine());
		
		int b[] = new int[n];
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		for(int i = 0 ; i < n ; i ++) {
			b[i] = Integer.parseInt(st.nextToken());
		}
		Arrays.sort(b);
		
		int j;
		int c= 1;
		int i = b.length-1;
		
		while(true) {
			//j는 반복문중 계산되므로 내가 현재 테스트중인 값을 c에 저장하고
			//계산되는 값은 j가 하도록 이런식으로 변수를 설정
			j = c;
		while(i >= 0) {
			//작은 경우 들어감
			if(b[i] <= j) {
				//해당하는 무게추를 j에서 빼주고 다음 더 작은 무게추를 검사하기 위해 i--해줌
				j = j-b[i];
				i--;
				//만약 j가 0이 되서 입력되어 있는 무게추로 만들수 있으면 
				if(j==0) {
					//현재 테스트중인 값의 1보다 더 큰수를 다시 배열의 가장 큰 무게부터 계산해주기 위해
					//i 값을 배열의 가장 큰 무게부터 설정해주고
					i = b.length-1;
					//현재 테스트중인 값보다 1큰수를 테스트하기 위해 c++ 해줌
					//이렇게 더해진 값은 39번째 줄에서 j에 전달후 다시 j가 계산
					c++;
					break;
				}
			//무게 추가 더 큰 경우는 다음 더 작은 무게추를 검사하기위해 i --
			}else if(b[i] > j) {
				i--;
			}
		}
		//이게 없는경우 while 반복루프를 빠져나오지 못함
		//배열의 0번째까지 돌리고 나왔는데 계산된 값이 0이 아니라 남아있는 경우 반복문 탈출
		if(j != 0) {
			break;
		}
		}
		
		//무게가 0이 되지 않고 나온 테스트중인 값을 출력
		System.out.println(c);
		
	}
}
