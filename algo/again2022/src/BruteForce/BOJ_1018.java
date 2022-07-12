package BruteForce;

import java.io.*;
import java.util.*;

public class BOJ_1018 {

	static int row;
	static int col;
	
	static char arr[][];
	
	static int answer = Integer.MAX_VALUE;
	
	public static void main(String[] args) throws IOException{
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		row = Integer.parseInt(st.nextToken());
		col = Integer.parseInt(st.nextToken());
		
		arr = new char[row][col];
		
		for(int i = 0 ; i < row ; i++) {
			String a = br.readLine();
			for(int j = 0 ; j < col ; j++) {
				arr[i][j] = a.charAt(j);
			}
		}
		
		pro();
		
		System.out.println(answer);
		
	}
	
	static void pro() {
		for(int i = 0 ; i <= row - 8 ; i++) {
			for(int j = 0 ; j <= col - 8 ; j++) {
				answer = Math.min(answer, counter(i,j));
				//System.out.println(i + " " + j);
			}
		}
	}
	
	static int counter(int startrow, int startcol) {
		
		int count = 0;
		
		int nextcount = 0;
		
		for(int i = startrow ; i < startrow + 8 ; i = i+2) {
			for(int j = startcol ; j < startcol + 8 ; j = j+2) {
				if(arr[startrow][startcol] != arr[i][j]) {
					count++;
				}
			}
		}
		
		for(int i = startrow + 1 ; i < startrow + 8 ; i = i+2) {
			for(int j = startcol + 1 ; j < startcol + 8 ; j = j+2) {
				if(arr[startrow][startcol] != arr[i][j]) {
					count++;
				}
			}
		}
		
		for(int i = startrow ; i < startrow + 8 ; i = i + 2) {
			for(int j = startcol + 1; j < startcol + 8 ; j = j + 2) {
				if(arr[startrow][startcol] == arr[i][j]) count ++;
			}
		}
		
		for(int i = startrow + 1; i < startrow + 8 ; i = i + 2) {
			for(int j = startcol ; j < startcol + 8 ; j = j + 2) {
				if(arr[startrow][startcol] == arr[i][j]) count++;
			}
		}
		
//		
//		if(arr[startrow][startcol] == 'B') {
//			arr[startrow][startcol] = 'W';
//		}else {
//			arr[startrow][startcol] = 'B';
//		}
		
		for(int i = startrow ; i < startrow + 8 ; i = i+2) {
			for(int j = startcol ; j < startcol + 8 ; j = j+2) {
				if(arr[startrow][startcol] == arr[i][j]) {
					nextcount++;
				}
			}
		}

		
		for(int i = startrow + 1 ; i < startrow + 8 ; i = i+2) {
			for(int j = startcol + 1 ; j < startcol + 8 ; j = j+2) {
				if(arr[startrow][startcol] == arr[i][j]) {
					nextcount++;
				}
			}
		}
		
		for(int i = startrow ; i < startrow + 8 ; i = i + 2) {
			for(int j = startcol + 1; j < startcol + 8 ; j = j + 2) {
				if(arr[startrow][startcol] != arr[i][j]) nextcount ++;
			}
		}
		
		for(int i = startrow + 1; i < startrow + 8 ; i = i + 2) {
			for(int j = startcol ; j < startcol + 8 ; j = j + 2) {
				if(arr[startrow][startcol] != arr[i][j]) nextcount++;
			}
		}
//		
//		if(arr[startrow][startcol] == 'B') {
//			arr[startrow][startcol] = 'W';
//		}else {
//			arr[startrow][startcol] = 'B';
//		}
		
		return Math.min(count, nextcount);
		
	}
	
	

}
