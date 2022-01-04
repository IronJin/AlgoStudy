package brute_force;

import java.util.*;
import java.io.*;


//대각선에도 존재할수없고
//같은 행에도 존재할수없고
//같은 열에도 존재할수 없음
//위의 세가지 조건에 유의하면서 풀것
public class BOJ_9663 {

	static ArrayList<Integer> list = new ArrayList<Integer>();
	static int t;
	static int answer = 0;
	//static int col[];
	
	/*static void rec_func(ArrayList<Integer> horse, int currentrow) {
		if(currentrow == t) {
			answer++;
		}else {
			for(int i = 0 ; i < t ; i++) {
				if(currentrow == 0) {
					horse.add(i);
					col[i] = 1;
					rec_func(horse, currentrow+1);
					col[i] = 0;
					horse.remove(horse.size()-1);
				}else {
					if(col[i] == 1) {
						continue;
					}else {
						boolean conti = false;
						for(int j = 0 ; j < horse.size() ; j++) {
							if(Math.abs(horse.get(j) - i) == Math.abs(currentrow - j)) {
								conti = true;
								continue;
							}
						}
						if(conti) {
							continue;
						}else {
							horse.add(i);
							col[i] = 1;
							rec_func(horse, currentrow +1);
							col[i] = 0;
							horse.remove(horse.size()-1);
						}
					}
				}
			}
		}
		
	}*/
	
	
	//코드 깔끔하게 작성해보기
	static void rec_func(ArrayList<Integer> horse, int currentrow) {
		if(currentrow == t) {
			answer++;
		}else {
			for(int i = 0 ; i < t ; i++) {
				if(positive(horse, i)) {
					horse.add(i);
					rec_func(horse, currentrow+1);
					horse.remove(currentrow);
				}
			}
		}
	}
	
	//조건에 걸리는지 안걸리는지를 파악해줌
    //행에서는 어차피 하나의 말만 놓을수 있으므로 위의 재귀함수 안에서 다음 재귀함수 호출을 통해 해결이 가능
    //열과 행은 전에 존재하는 말의 위치를 통해 대각선에 존재하는지와 같은 열에 존재하는 말이 있는지를 검사
	static boolean positive(ArrayList<Integer> list, int currentcol) {
		int currentrow = list.size();
		for(int i = 0 ; i < list.size() ; i++) {
			if(Math.abs(currentcol - list.get(i)) == Math.abs(currentrow - i) || currentcol == list.get(i)) {
				return false;
			}
		}
		return true;
	}
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		t = Integer.parseInt(br.readLine());
		//col = new int[t];
		rec_func(list, 0);
		System.out.println(answer);
	}

}
