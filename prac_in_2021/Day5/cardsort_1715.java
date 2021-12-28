import java.util.PriorityQueue;
import java.util.Scanner;

//문제 틀렸고 답을 확인
//우선순위 큐 를 이용해야함
//최소 힙 우선순위 큐 선언하면 쉽게 풀 수 있음
//처음 생각한것은 작은대로 정렬 후 계속해서 더해주면서 가면됨
//반례 10 10 10 10 같은 경우 (10+ 10) + (10+10) + 20+20
//내 풀이같은 경우 10 + 10 + 20 + 10 + 30+ 10
public class cardsort_1715 {

	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		
		//테스트 케이스 입력
		int t = sc.nextInt();
		int sum = 0;
		int result = 0;
		//최소 힙 구조를 가진 우선순위 큐임
		//힙과 우선순위큐의 구조는 비슷하지만 힙의 경우 최소값이나 최대값을 빠르게 찾아내기 위한 완전이진트리 형태로 만들어진 자료구조
		//우선순위 큐는 우선순위가 높은 순서대로 요소를 제공받음/ 연결리스트로 표현이 가능하다는 소리
		PriorityQueue<Integer> pq = new PriorityQueue<>();
		
		for(int i = 0 ; i < t ; i ++) {
			pq.add(sc.nextInt());
		}
	
		while(pq.size() != 1) {
			sum = pq.poll() + pq.poll();
			result += sum;
			pq.add(sum);
			}
		System.out.println(result);
		
	}
}

