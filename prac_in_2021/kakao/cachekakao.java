import java.io.*;
import java.util.ArrayList;

public class cachekakao {

	//Ǯ�̽ð� 45��
	//���� ������ �� 45�� + 2�ð� + 1�ð� 30�� = 4�ð� 15��
	//������ �ѹ����� 45�оȿ� Ǯ�����
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
			//ĳ���� ���� �ƹ��͵� ������ ������
			if(list.size() == 0) {
				list.add(cities[i]);
				answer += 5;
			//ĳ��ũ�⿡ �������� �ʾ�����
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
			//ĳ��ũ�⸦ ����������
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
