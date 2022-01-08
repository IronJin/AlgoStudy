import java.io.*;
import java.util.*;

public class BOJ_10825 {

	static class Elem implements Comparable<Elem>{
		String name;
		int korean, english, math;
		
		@Override
		public int compareTo(Elem o) {
			//국어 점수가 감소하는 순서로
			if(korean != o.korean) {
				return o.korean - korean;
			}
			
			//국어점수가 같으면 영어점수를 오름차순
			if(english != o.english) {
				return english - o.english;
			}
			
			//국어 점수와 영어점수가 같으면 수학점수가 감소하는 순서로
			if(math != o.math) {
				return o.math - math;
			}
			
			//모든 점수가 같으면 이름이 사전순으로 증가하는 순서로
			return name.compareTo(o.name);
		}
		
		
	}
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		int testcase = Integer.parseInt(br.readLine());
		Elem e[] = new Elem[testcase];
		for(int i = 0 ; i < testcase ; i++) {
			st = new StringTokenizer(br.readLine());
			e[i] = new Elem();
			e[i].name = st.nextToken();
			e[i].korean = Integer.parseInt(st.nextToken());
			e[i].english = Integer.parseInt(st.nextToken());
			e[i].math = Integer.parseInt(st.nextToken());
		}
		
		Arrays.sort(e);
		
		for(int i = 0 ; i < e.length ;i++) {
			System.out.println(e[i].name);
		}
	}

}
