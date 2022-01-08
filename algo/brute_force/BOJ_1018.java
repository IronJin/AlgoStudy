package brute_force;

import java.io.*;
import java.util.*;

public class BOJ_1018 {

	static int row;
	static int col;
	static int chess[][];
	static int blackcount;
	static int answer = Integer.MAX_VALUE;
	static int whitecount;
	
	static void blackfunc(int currentrow, int currentcol, int check, int stoprow, int stopcol) {
		
		if(currentrow == stoprow) {
			return;
		}else if(currentcol == stopcol) {
			if(check == 1) {
				check = 0;
			}else if(check == 0) {
				check = 1;
			}
			blackfunc(currentrow+1, stopcol-8, check, stoprow, stopcol);
		}else {
			if(chess[currentrow][currentcol] != check) {
				blackcount++;
			}
			
			if(check == 1) {
				check = 0;
			}else if(check == 0) {
				check = 1;
			}
			blackfunc(currentrow, currentcol+1 , check , stoprow, stopcol);
		}
	}
	
static void whitefunc(int currentrow, int currentcol, int check, int stoprow, int stopcol) {
		
		if(currentrow == stoprow) {
			return;
		}else if(currentcol == stopcol) {
			if(check == 1) {
				check = 0;
			}else if(check == 0) {
				check = 1;
			}
			whitefunc(currentrow+1, stopcol-8, check, stoprow, stopcol);
		}else {
			if(chess[currentrow][currentcol] != check) {
				whitecount++;
			}
			
			if(check == 1) {
				check = 0;
			}else if(check == 0) {
				check = 1;
			}
			whitefunc(currentrow, currentcol+1 , check , stoprow, stopcol);
		}
	}
	
	public static void main(String[] args) throws IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		row = Integer.parseInt(st.nextToken());
		col = Integer.parseInt(st.nextToken());
		chess = new int[row][col];
		
		for(int i = 0 ; i < row ; i++) {
			String str = br.readLine();
			for(int j = 0 ; j < col ; j++) {
				if(str.charAt(j) == 'W') {
					chess[i][j] = 0;
				}else {
					chess[i][j] = 1;
				}
			}
		}
	
		for(int i = 0 ; i <= row-8 ; i++) {
			for(int j = 0 ; j <= col-8 ; j++) {
				blackcount = 0;
				whitecount = 0;
				blackfunc(i,j,1,i+8,j+8);
				whitefunc(i,j,0,i+8,j+8);
				answer = Math.min(blackcount, Math.min(whitecount, answer));
			}
		}
		
		System.out.println(answer);
		
	}
}
