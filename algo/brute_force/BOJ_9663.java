package brute_force;

import java.util.*;
import java.io.*;


//�밢������ �����Ҽ�����
//���� �࿡�� �����Ҽ�����
//���� ������ �����Ҽ� ����
//���� ������ ���ǿ� �����ϸ鼭 Ǯ��
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
	
	
	//�ڵ� ����ϰ� �ۼ��غ���
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
	
	//���ǿ� �ɸ����� �Ȱɸ������� �ľ�����
    //�࿡���� ������ �ϳ��� ���� ������ �����Ƿ� ���� ����Լ� �ȿ��� ���� ����Լ� ȣ���� ���� �ذ��� ����
    //���� ���� ���� �����ϴ� ���� ��ġ�� ���� �밢���� �����ϴ����� ���� ���� �����ϴ� ���� �ִ����� �˻�
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
