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
		
		//108개의 해쉬맵 생성
		for(int a = 0 ; a < 4; a++) {
			for(int b = 0 ; b < 3 ; b++) {
				for(int c = 0 ; c< 3 ; c++) {
					for(int d = 0 ; d < 3 ; d++) {
						infomap.put(Language[a]+job[b]+career[c]+food[d], new ArrayList<>());
					}
				}
			}
		}
		
		//해쉬맵에 값을 넣어줘야함
		for(int i = 0 ; i < info.length ; i++) {
			StringTokenizer st = new StringTokenizer(info[i]);
			//해쉬맵의 키값을 이용해 16개의 인덱스에 모두 score를 넣어주어야함
			String la = st.nextToken();
			String jo = st.nextToken();
			String ca = st.nextToken();
			String fo = st.nextToken();
			String bar = "-";
			int score = Integer.parseInt(st.nextToken());
			
			//바를 사용을 하나도 안한경우
			infomap.get(la+jo+ca+fo).add(score);
			//한개만 사용한경우
			infomap.get(bar+jo+ca+fo).add(score);
			infomap.get(la+bar+ca+fo).add(score);
			infomap.get(la+jo+bar+fo).add(score);
			infomap.get(la+jo+ca+bar).add(score);
			//두개를 사용한경우
			infomap.get(bar+bar+ca+fo).add(score);
			infomap.get(bar+jo+bar+fo).add(score);
			infomap.get(bar+jo+ca+bar).add(score);
			infomap.get(la+bar+bar+fo).add(score);
			infomap.get(la+bar+ca+bar).add(score);
			infomap.get(la+jo+bar+bar).add(score);
			//3개를 사용한경우
			infomap.get(bar+bar+bar+fo).add(score);
			infomap.get(bar+bar+ca+bar).add(score);
			infomap.get(bar+jo+bar+bar).add(score);
			infomap.get(la+bar+bar+bar).add(score);
			//4개를 사용한경우
			infomap.get(bar+bar+bar+bar).add(score);
		}
		
		
		//바이너리 서치를 이용하기전에 소팅을 해줘야함
		//각 인덱스마다 저장되어 있는 리스트가 정렬이 됨
		for(Map.Entry<String, ArrayList<Integer>> entry : infomap.entrySet()) {
			Collections.sort(entry.getValue());
		}
		
		//이제 값을 찾으면됨
		for(int i = 0 ; i < query.length ; i++) {
			query[i] = query[i].replace(" and ", "");
			StringTokenizer st = new StringTokenizer(query[i]);
			String key = st.nextToken();
			int score = Integer.parseInt(st.nextToken());
			
			ArrayList<Integer> res = infomap.get(key);
			int idx = Collections.binarySearch(res, score);
			//못찾으면 idx 값은 그 값이 들어갈 인덱스에 -1 을 더해준 값이 출력됨
			if(idx < 0) {
				answer[i] = res.size() + (idx + 1);
			}
			//찾은경우 똑같은값이 또 있는지 확인
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

