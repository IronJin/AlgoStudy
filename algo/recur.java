package algoprac;

import java.util.*;


//팩토리얼과 ArrayList 의 합을 재귀호출을 이용해 구현한 알고리즘

public class recur {

	public static int fac(int n) {
		
		if(n == 1) {
			return 1;
		}else {
			return n * fac(n-1);
		}
		
	}
	
	public static int sumfac(ArrayList<Integer> list) {
		if(list.size() <= 0) {
			return 0;
		}else {
			return list.get(0) + sumfac(new ArrayList<Integer>(list.subList(1, list.size())));
		}
	}
	
	public static void main(String[] args) {
		
		int answer = fac(5);
		System.out.println(answer);
		
		ArrayList<Integer> list = new ArrayList<>();
		
		for(int i=0 ; i < 10 ; i++) {
			list.add(i);
		}
		
		System.out.println(list);
		System.out.println(list.subList(1, 3));
		
		int sumanswer = sumfac(list);
		System.out.println(sumanswer);
		
	}
}
