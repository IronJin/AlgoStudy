package algoprac;
/*
 * 배낭문제
 * 가치와 무게를 가지고 무게제한이 k인 배낭에 최대 가치가 되도록 물건을 넣는 문제
 * 물건의 일부를 쪼개서 넣을수도 있음
 */

import java.io.*;
import java.util.*;

public class greedy_basic2 {

	public static void main(String[] args) throws IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		int thing[][] = new int[5][2];
		System.out.print("배낭 무게 입력 : ");
		double cap = Double.parseDouble(br.readLine());
		System.out.println("물건의 무게와 가치 입력");
		for(int i = 0 ; i < 5 ; i++) {
			st = new StringTokenizer(br.readLine());
			thing[i][0] = Integer.parseInt(st.nextToken());
			thing[i][1] = Integer.parseInt(st.nextToken());
		}
		
		Arrays.sort(thing, new Comparator<int []>() {
			@Override
			public int compare(int[] ob1, int[] ob2) {
				return (ob2[1]/ob2[0]) - (ob1[1]/ob1[0]);
			}
		});
		
		double totalvalue = 0.0;
		double frac = 0.0;
		for(int i = 0 ; i < thing.length; i++) {
			if(cap - (double)thing[i][0] > 0.0) {
				cap -= (double)thing[i][0];
				totalvalue += (double)thing[i][1];
			}else {
				frac = cap/(double)thing[i][0];
				totalvalue += frac * (double)thing[i][1];
				break;
			}
		}
		System.out.println(totalvalue);
	}

}
