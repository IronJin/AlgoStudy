import java.util.*;

public class Level1_Gym_Clothes {

	public static void main(String[] args) {
		
		int n = 3;
		int lost[] = {3};
		int reserve[] = {1};

		int answer = solution(n, lost, reserve);
		System.out.println(answer);
	}

	public static int solution(int n, int[] lost, int[] reserve) {
		int answer = 0;
		
		Arrays.sort(lost);
		Arrays.sort(reserve);
		
		int count[] = new int[n+1];
		for(int i = 1; i <= n ; i++) {
			count[i] = 1;
		}
		
		for(int i = 0 ; i < reserve.length ; i++) {
			int index= reserve[i];
			count[index] = 2;
		}
		
		for(int i = 0 ; i < lost.length ; i++) {
			int index = lost[i];
			count[index] --;
		}
		
		
		
		for(int i = 1; i<= n ; i++) {
			if(count[i] != 2) continue;
			
			int preindex = i - 1;
			if(preindex >= 1) {
				if(count[preindex] == 0) {
					count[preindex] = 1;
					count[i] = 1;
					continue;
				}
			}
			
			int nextindex = i + 1;
			if(nextindex <= n) {
				if(count[nextindex] == 0) {
					count[nextindex] = 1;
					count[i] = 1;
				}
			}
		}
		
		for(int i = 1; i <= n ; i++) {
			if(count[i] > 0) {
				answer++;
			}
		}
		
		
		
		return answer;
	}

	
}
