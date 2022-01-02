package algoprac;

/*
 * ���� 1. ���� ���� ��������
 * ���� 2. 
 */

import java.io.*;
import java.util.*;

public class greedy_basic {

	public static void main(String[] args) throws NumberFormatException, IOException {
		
		//�����ؾ��ϴ°��� 4720�� �϶� 1�� 50�� 100�� 500�� �������� �������� ���� ���� ����
		//�� ���������� ���
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		System.out.print("������ �Է� : ");
		int price = Integer.parseInt(br.readLine());
		int count = 0;
		ArrayList<Integer> coin = new ArrayList<Integer>();
		coin.addAll(Arrays.asList(500,100,50,1));
		
		for(int i = 0 ; i < coin.size() ; i++) {
			int n = price/(coin.get(i));
			count += n;
			price = price%coin.get(i);
			System.out.println(coin.get(i)+"�� "+n+"��");
		}
		
		System.out.println(count);
		

	}

}
