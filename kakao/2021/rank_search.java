package programmers;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;
import java.util.StringTokenizer;
import java.io.*;
public class rank_search {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String[] info = {
				"java backend junior pizza 150","python frontend senior chicken 210","python frontend senior chicken 150","cpp backend senior pizza 260","java backend junior chicken 80","python backend senior chicken 50"
		};
		String[] q = {
				"java and backend and junior and pizza 100","python and frontend and senior and chicken 200","cpp and - and senior and pizza 250","- and backend and senior and - 150","- and - and - and chicken 100","- and - and - and - 150"
		};

		int arr[] = solution(info, q);
		
		for(int i = 0 ; i < arr.length ; i++) {
			System.out.println(arr[i]);
		}
	}
	
	
	
	public static int[] solution(String[] info, String[] query) {
		String Language[] = {"java", "cpp", "python", "-"};
		String job[] = {"backend", "frontend","-"};
		String career[] = {"junior", "senior","-"};
		String food[] = {"chicken","pizza","-"};
		
		int[] answer = new int[query.length];
		HashMap<String, ArrayList<Integer>> infomap = new HashMap<>();
		
		//108���� �ؽ��� ����
		for(int a = 0 ; a < 4; a++) {
			for(int b = 0 ; b < 3 ; b++) {
				for(int c = 0 ; c< 3 ; c++) {
					for(int d = 0 ; d < 3 ; d++) {
						infomap.put(Language[a]+job[b]+career[c]+food[d], new ArrayList<>());
					}
				}
			}
		}
		
		//�ؽ��ʿ� ���� �־������
		for(int i = 0 ; i < info.length ; i++) {
			StringTokenizer st = new StringTokenizer(info[i]);
			//�ؽ����� Ű���� �̿��� 16���� �ε����� ��� score�� �־��־����
			String la = st.nextToken();
			String jo = st.nextToken();
			String ca = st.nextToken();
			String fo = st.nextToken();
			String bar = "-";
			int score = Integer.parseInt(st.nextToken());
			
			//�ٸ� ����� �ϳ��� ���Ѱ��
			infomap.get(la+jo+ca+fo).add(score);
			//�Ѱ��� ����Ѱ��
			infomap.get(bar+jo+ca+fo).add(score);
			infomap.get(la+bar+ca+fo).add(score);
			infomap.get(la+jo+bar+fo).add(score);
			infomap.get(la+jo+ca+bar).add(score);
			//�ΰ��� ����Ѱ��
			infomap.get(bar+bar+ca+fo).add(score);
			infomap.get(bar+jo+bar+fo).add(score);
			infomap.get(bar+jo+ca+bar).add(score);
			infomap.get(la+bar+bar+fo).add(score);
			infomap.get(la+bar+ca+bar).add(score);
			infomap.get(la+jo+bar+bar).add(score);
			//3���� ����Ѱ��
			infomap.get(bar+bar+bar+fo).add(score);
			infomap.get(bar+bar+ca+bar).add(score);
			infomap.get(bar+jo+bar+bar).add(score);
			infomap.get(la+bar+bar+bar).add(score);
			//4���� ����Ѱ��
			infomap.get(bar+bar+bar+bar).add(score);
		}
		
		
		//���̳ʸ� ��ġ�� �̿��ϱ����� ������ �������
		//�� �ε������� ����Ǿ� �ִ� ����Ʈ�� ������ ��
		for(Map.Entry<String, ArrayList<Integer>> entry : infomap.entrySet()) {
			Collections.sort(entry.getValue());
		}
		
		//���� ���� ã�����
		for(int i = 0 ; i < query.length ; i++) {
			query[i] = query[i].replace(" and ", "");
			StringTokenizer st = new StringTokenizer(query[i]);
			String key = st.nextToken();
			int score = Integer.parseInt(st.nextToken());
			
			ArrayList<Integer> res = infomap.get(key);
			int idx = Collections.binarySearch(res, score);
			//��ã���� idx ���� �� ���� �� �ε����� -1 �� ������ ���� ��µ�
			if(idx < 0) {
				answer[i] = res.size() + (idx + 1);
			}
			//ã����� �Ȱ������� �� �ִ��� Ȯ��
			else {
				for(int j = idx -1 ; j >=0 ; j--) {
					if(res.get(idx).equals(res.get(j))) {
						idx = j;
					}else {
						break;
					}
				}
				answer[i] = res.size() - idx;
			}
		}
		return answer;
	    }
}

