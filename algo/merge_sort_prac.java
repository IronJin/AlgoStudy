package algoprac;

import java.util.*;

public class merge_sort_prac {

	public static ArrayList<Integer> split(ArrayList<Integer> data){
		
		if(data.size()<=1) {
			return data;
		}
		
		int mid = data.size()/2;
		
		ArrayList<Integer> left = split(new ArrayList<Integer>(data.subList(0, mid)));
		ArrayList<Integer> right = split(new ArrayList<Integer>(data.subList(mid, data.size())));
		
		return merge(left,right);
	}
	
	public static ArrayList<Integer> merge(ArrayList<Integer> left, ArrayList<Integer> right){
		ArrayList<Integer> ms = new ArrayList<Integer>();
		
		int leftindex = 0;
		int rightindex = 0;
		
		while(leftindex < left.size() && rightindex < right.size()) {
			if(left.get(leftindex) < right.get(rightindex)) {
				ms.add(left.get(leftindex));
				leftindex++;
			}else {
				ms.add(right.get(rightindex));
				rightindex++;
			}
		}
		
		while(leftindex < left.size()) {
			ms.add(left.get(leftindex));
			leftindex++;
		}
		
		while(rightindex < right.size()) {
			ms.add(right.get(rightindex));
			rightindex++;
		}
		
		return ms;
	}
	
	public static void main(String[] args) {
		
		ArrayList<Integer> list = new ArrayList<Integer>();
		
		for(int i = 1 ; i <=10 ; i++) {
			list.add((int)(Math.random()*10));
		}

		System.out.println(list);
		
		list = split(list);
		
		System.out.println(list);
	}

}
