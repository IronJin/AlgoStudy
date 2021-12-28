package brute_force;

import java.io.*;
import java.util.ArrayList;
import java.util.Collections;
import java.util.StringTokenizer;


//��Ʈ��ŷ�� �̿���
public class inequality_sign_2529 {
	static int n;
	static boolean check[] = new boolean[10]; //���ڸ� �ϳ��� ����ϹǷ� �� ���ڸ� ������� üũ���ִ� 
	static char ch[];
	static ArrayList<String> list = new ArrayList<>();
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		n = Integer.parseInt(br.readLine());
		
		ch = new char[n];
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		for(int i = 0 ; i < n ; i ++) {
			ch[i] = st.nextToken().charAt(0);
		}

		dfs("",0);
		
		Collections.sort(list);
		
		System.out.println(list.get(list.size()-1));
		System.out.println(list.get(0));
		
		
	}
	
	public static void dfs(String num , int depth) {
		
		if(depth == n+1) {
			list.add(num);
			return;
		}
		
		for(int i = 0 ; i <=9 ; i++ ) {
			if(depth == 0 || !check[i] && compare(num.charAt(num.length()-1) -'0', i, ch[depth-1])) {
				check[i] = true;
				dfs(num+i,depth+1);
				check[i] = false;
			}

		}
	}
	
	public static boolean compare(int a, int b, char c) {
		if(c == '<') return a<b;
		else return a>b;
	}

}
