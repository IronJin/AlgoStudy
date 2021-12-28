package algoprac;

import java.util.ArrayList;
import java.util.Arrays;

public class quick_sort {

	public static ArrayList<Integer> split(ArrayList<Integer> list){
		if(list.size() <= 1) {
			return list;
		}
		
		ArrayList<Integer> left = new ArrayList<Integer>();
		ArrayList<Integer> right = new ArrayList<Integer>();
		
		ArrayList<Integer> merge = new ArrayList<Integer>();
		
		int pivot = list.get(0);
		
		for(int i = 1 ; i < list.size() ; i++) {
			if(list.get(i) < pivot) {
				left.add(list.get(i));
			}else {
				right.add(list.get(i));
			}
		}
		
		merge.addAll(split(left));
		merge.add(list.get(0));
		merge.addAll(split(right));
		
		return merge;
	}
	
	public static void main(String[] args) {
		
		ArrayList<Integer> list = new ArrayList<>();

		for(int i = 0 ; i < 10 ; i++) {
			list.add((int)(Math.random()*100));
		}
		
		System.out.println(split(list));
		
	}

}
