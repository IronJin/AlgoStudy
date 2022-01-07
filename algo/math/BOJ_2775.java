import java.io.*;
import java.util.*;

public class BOJ_2775 {

	static int testcase;
	static int room;
	static int floor;
	static int people[][];
	
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		testcase = Integer.parseInt(br.readLine());
		
		while(testcase > 0) {
			floor = Integer.parseInt(br.readLine());
			room = Integer.parseInt(br.readLine());
			people = new int[floor+1][room+1];
			
			for(int i = 1 ; i <= room ; i++) {
				people[0][i] = i;
			}
			
			for(int i = 1 ; i <= floor ; i++) {
				int sum = 0;
				for(int j = 1 ; j <= room ; j++) {
					sum += people[i-1][j];
					people[i][j] = sum;
				}
			}
			testcase--;
			System.out.println(people[floor][room]);
		}
		
		
		
		
		
		
		
		
		
		
	}
}
