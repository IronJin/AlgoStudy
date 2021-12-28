import java.io.*;
import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.Stack;
public class fibonacci_9009 {

	public static void main(String[] args) throws NumberFormatException, IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int t = Integer.parseInt(br.readLine());
		
		for(int z = 0 ; z < t ; z++) {
			
			int n = Integer.parseInt(br.readLine());
			
			Stack<Integer> st = new Stack<>();
			
			st.add(0);
			st.add(1);
			while(true) {
				int a = st.pop();

				int b = st.pop();

				int c = a+b;

				//b a c 순서로 넣어야함 b가 더 뒤에 있는 값을 꺼내는 것이기 때문
				// 0 1 2 가 abc 순서면 1 0 2 가 됨
				st.add(b);
				st.add(a);
				st.add(c);
				//스택의 맨위가 n보다 커지는 경우 스택에서 빼주고 while 문을 빠져나옴
				if(st.peek() > n) {
					st.pop();
					break;
				}
			}
			
			//오름차순으로 출력하기 위한 우선순위 큐 생성
			PriorityQueue<Integer> pq = new PriorityQueue<>();
			
			//스택의 맨 위가 n보다 작거나 같은경우 n에서 빼주고 그 값을 우선순위큐에 삽입
			while(n!=0) {
				int a = st.pop();
				if(a <= n) {
					n = n-a;
					pq.add(a);
				}
			}
			
			//우선순위큐가 빌때까지 하나씩 값을 출력
			while(!pq.isEmpty()) {
				System.out.print(pq.poll()+" ");
			}
			System.out.println();
		}

	}

}
