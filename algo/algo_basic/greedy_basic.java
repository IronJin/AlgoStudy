package algoprac;

/*
 * 문제 1. 동전 개수 가장적게
 * 문제 2. 
 */

import java.io.*;
import java.util.*;

public class greedy_basic {

	public static void main(String[] args) throws NumberFormatException, IOException {
		
		//지불해야하는값이 4720원 일때 1원 50원 100원 500원 동전으로 동전수가 가장 적게 지불
		//총 동전개수를 출력
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		System.out.print("가격을 입력 : ");
		int price = Integer.parseInt(br.readLine());
		int count = 0;
		ArrayList<Integer> coin = new ArrayList<Integer>();
		coin.addAll(Arrays.asList(500,100,50,1));
		
		for(int i = 0 ; i < coin.size() ; i++) {
			int n = price/(coin.get(i));
			count += n;
			price = price%coin.get(i);
			System.out.println(coin.get(i)+"원 "+n+"개");
		}
		
		System.out.println(count);
		

	}

}
