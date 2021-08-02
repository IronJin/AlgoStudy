import java.io.*;
import java.util.Stack;
import java.util.StringTokenizer;

//처음에 시간초과나서 애먹은 문제
//스택의 탑보다 작은경우 그냥 스택에 계속해서 추가
//스택의 탑보다 현재 스택에 추가하려는 값이 큰 경우 스택의 탑을 계속 삭제해나가면서 스택에 추가하려는 값보다 큰값이 나오거나
//스택이 빌때까지 와일문 돌림
//31번째 포문을 돌면서 i를 조정해가며 27번째의 스택에서의 팝과 동시에 해당 index의 값을 삭제해주려고 했으나
//여기서 시간초과가 나서 그냥 스택만으로 해결하려고함
//틀렸습니다 두번 이유 : 스택의 탑과 한번만 비교해서 팝하고 애드 해줬기때문
//스택의 탑이 더 큰값이 나올때까지 팝해줬어야 했는데 간과하고 있었음. 그래서 while 뮨 수정후 정답인정
//468ms

public class makebig_2812 {

	public static void main(String[] args) throws IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		//길이
		int l = Integer.parseInt(st.nextToken());
		
		//지우개 개수
		int cnt = Integer.parseInt(st.nextToken());

		//문자열로받은 두번째줄
		//중간 문자열 하나를 삭제해주기 위함
		StringBuffer str = new StringBuffer(br.readLine());
	
		Stack<Integer> stack = new Stack<>();
		//문자열 맨처음 인덱스는 무조건 스택에 들어가니까 처음에 그냥 바로 설정
		stack.add(str.charAt(0)-'0');
		for(int i = 1 ; i < l ; i++) {
			//지우개가 0이 되면 종료
			if(cnt == 0) {
				stack.add(str.charAt(i) - '0');
				continue;
			}

			//스택의 탑보다 작거나 같은경우 스택에 추가해줌
			if(stack.peek() >= str.charAt(i)-'0') {
				stack.push(str.charAt(i) - '0');
			}else {
				while(cnt!=0 && !stack.isEmpty() && stack.peek() < str.charAt(i)-'0') {
					stack.pop();
					cnt--;
				}
				stack.add(str.charAt(i)-'0');
			}
		}
		
		//만약 지우개를 다 쓰지못한경우 그냥 스택의 탑을 계속해서 지워주면됨
		while(cnt != 0) {
			stack.pop();
			cnt--;
		}
	
		//스트링버퍼를 사용해야 스트링이 동적성질을가지고 중간 문자열을 삭제하거나 추가가능
		StringBuffer ab = new StringBuffer();
		
		//스택의 인덱스 맨 아래부터 스트링에 추가
		for(int i = 0 ; i < stack.size() ; i++) {
			ab.append(stack.get(i));
		}
		
		//출력
		System.out.println(ab.toString());
	
	
	}

}
