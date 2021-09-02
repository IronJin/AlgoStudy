import java.io.*;
import java.util.ArrayList;

public class cachekakao {

	//풀이시간 45분
	//현재 세문제 총 45분 + 2시간 + 1시간 30분 = 4시간 15분
	//나머지 한문제를 45분안에 풀어야함
	public static void main(String[] args) throws NumberFormatException, IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int n = Integer.parseInt(br.readLine());
		String[] city = new String[12];
		
		for(int i = 0 ; i < city.length ; i++) {
			city[i] = br.readLine();
		}
		int answer = solution(n,city);
		System.out.println(answer);
	}
	
	public static int solution(int cacheSize, String[] cities) {
		int answer = 0;
		
		ArrayList<String> list = new ArrayList<>();
		
		if(cacheSize == 0) {
			answer = cities.length * 5;
			return answer;
		}
		
		for(int i = 0 ; i < cities.length ; i++) {
			cities[i] = cities[i].toUpperCase();
			//캐쉬에 아직 아무것도 들어가있지 않을때
			if(list.size() == 0) {
				list.add(cities[i]);
				answer += 5;
			//캐쉬크기에 도달하지 않았을때
			}else if(list.size() != cacheSize) {
				if(list.contains(cities[i])) {
					for(int j = 0 ; j < list.size() ; j++) {
						if(list.get(j).equals(cities[i])) {
							list.remove(j);
							list.add(cities[i]);
							answer+=1;
							break;
						}
					}
				}else {
					list.add(cities[i]);
					answer+=5;
				}
			//캐쉬크기를 도달했을때
			}else if(list.size() == cacheSize) {
				if(list.contains(cities[i])) {
					for(int j = 0 ; j < list.size() ; j++) {
						if(list.get(j).equals(cities[i])) {
							list.remove(j);
							list.add(cities[i]);
							answer+=1;
							break;
						}
					}
				}else {
					list.remove(0);
					list.add(cities[i]);
					answer+=5;
				}
			}
			
		}
		
		return answer;
	}

}
