package algoprac;

import java.util.*;

public class Quicksort_solo_prac {

	public static ArrayList<Integer> sort(ArrayList<Integer> list){
		if(list.size() <= 1) {
			return list;
		}
		
		int pivot = list.get(0);
		
		ArrayList<Integer> left = new ArrayList<Integer>();
		ArrayList<Integer> right = new ArrayList<Integer>();
		
		for(int i = 1 ; i < list.size() ; i++) {
			if(list.get(i) < pivot) {
				left.add(list.get(i));
			}else {
				right.add(list.get(i));
			}
		}
		
		ArrayList<Integer> merge = new ArrayList<Integer>();
		
		//재귀를 활용하여 오른쪽과 왼쪽도 똑같은 것을 진행함
		merge.addAll(sort(left));
		merge.addAll(Arrays.asList(pivot));
		merge.addAll(sort(right));
		
		return merge;
	}
	
	public static void main(String[] args) {
		
		// 입출력
		ArrayList<Integer> list = new ArrayList<Integer>();
		for(int i = 0 ; i < 10 ; i++) {
			list.add((int)(Math.random()*100));
		}
		
		System.out.println(list);
		System.out.println(sort(list));

	}

}
