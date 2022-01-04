package algoprac;

import java.util.*;

public class merge_sort {
	
	//배열을 분리하는 함수
	public static ArrayList<Integer> split(ArrayList<Integer> sp) {
		if(sp.size() <= 1) {
			return sp;
		}
		
		int mid = sp.size()/2;
		
		ArrayList<Integer> left = split(new ArrayList<>(sp.subList(0, mid)));
		ArrayList<Integer> right = split(new ArrayList<>(sp.subList(mid, sp.size())));
		
		return merge(left, right);
	}
	
	public static ArrayList<Integer> merge(ArrayList<Integer> left, ArrayList<Integer> right){
		
		ArrayList<Integer> mergesort = new ArrayList<Integer>();
		
		int leftindex = 0;
		int rightindex = 0;
		
		while(leftindex < left.size() && rightindex < right.size()) {
			if(left.get(leftindex) > right.get(rightindex)) {
				mergesort.add(right.get(rightindex));
				rightindex++;
			}else {
				mergesort.add(left.get(leftindex));
				leftindex++;
			}
		}
		
		while(rightindex < right.size()) {
			mergesort.add(right.get(rightindex));
			rightindex++;
		}
		
		while(leftindex < left.size()) {
			mergesort.add(left.get(leftindex));
			leftindex++;
		}
		System.out.println("1");
		
		return mergesort;
		
	}
	

	public static void main(String[] args) {
		
		ArrayList<Integer> sp = new ArrayList<>();
		
		sp.add(10);
		sp.add(25);
		sp.add(3);
		sp.add(14);
		sp.add(51);
		sp.add(6);
		
		ArrayList<Integer> answer = new ArrayList<>();
		
		answer = split(sp);
		System.out.println(answer);
	}
}
