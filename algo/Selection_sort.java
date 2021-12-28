package algoprac;

import java.util.*;

public class Selection_sort {

	public static void main(String[] args) {
		
		ArrayList<Integer> list = new ArrayList<>();

		for(int i = 0 ; i < 10; i++) {
			list.add((int) (Math.random()*100));
		}
		
		for(int j = 0 ; j < list.size()-1 ; j++) {
			
			int min= j;
			boolean swap = false;
			
			for(int i = j+1 ; i < list.size() ; i++) {
				if(list.get(i) < list.get(min)) {
					min = i;
					swap = true;
				}
			}
			
			if(swap == true) {
				Collections.swap(list, min, j);
			}
			
		}
		
		System.out.println(list);
		
	}

}
