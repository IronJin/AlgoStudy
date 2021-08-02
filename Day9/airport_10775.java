import java.util.HashSet;
import java.util.Scanner;

public class airport_10775 {

	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		
		//게이트 수
		int g = sc.nextInt();
		//비행기 수
		int p = sc.nextInt();
		
		int gi[] = new int[p];
		
		for(int i = 0 ; i < p ; i++) {
			gi[i] = sc.nextInt();
		}
		
		HashSet<Integer> set = new HashSet<>();
		int ans = 0;
		int a = gi[0];
		int i = 0;
		while(a!=0 || i == p) {
			//해쉬에 현재 게이트가 도킹이 되어있는경우 현재 게이트보다 한자리 작은 게이트 확인
			if(set.contains(a)) {
				a--;
			//포함이 되어있지 않다면
			}else {
				//현재게이트번호 넣어주고 다음 비행기 확인
				set.add(a);
				i++;
				a = gi[i];
				ans ++;
			}
		}
		System.out.println(ans);
		
	}

}
