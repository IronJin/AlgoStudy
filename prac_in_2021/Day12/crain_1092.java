import java.io.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.StringTokenizer;


public class crain_1092 {

	public static void main(String[] args) throws NumberFormatException, IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		
		//ũ���� �����Է�
		int c = Integer.parseInt(br.readLine());
		Integer cr[] = new Integer[c];
		StringTokenizer st = new StringTokenizer(br.readLine());
		for(int i = 0 ; i < c ; i++) {
			cr[i] = Integer.parseInt(st.nextToken());
		}
		//ũ���� ����
		Arrays.sort(cr, Collections.reverseOrder());

		//ȭ�� �Է�
		int m = Integer.parseInt(br.readLine());
		ArrayList<Integer> box = new ArrayList<>();
		st = new StringTokenizer(br.readLine());
		for(int i = 0 ; i < m ; i ++) {
			box.add(Integer.parseInt(st.nextToken()));
		}
		//ȭ�� ����
		Collections.sort(box, Collections.reverseOrder());
		
		if(cr[0] < box.get(0)) {
			System.out.println(-1);
		}else {
			
			int count = 0;
			
			while(!box.isEmpty()) {
				
				//���� ū ũ���ο� ���� ������ ���� ���� ȭ���� �Ű���
				box.remove(0);
				if(box.isEmpty()) {
					count++;
					break;
				}
				int idx = 0;
				for(int i = 1 ; i < c ;) {
					if(idx == box.size()) break;
					if(cr[i] >= box.get(idx)) {
						box.remove(idx);
						i++;
					}else idx++;
				}
				
				count++;
				
			}//�ڽ��� �������� ����
			
			System.out.println(count);
		}
		
		
		
	}

}
