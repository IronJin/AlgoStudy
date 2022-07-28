/**
 * 없는숫자 더하기 - 프로그래머스 level1
 * @author 82105
 *
 */
public class level1_Adding_a_number_that_doesnt_exist {

	static boolean visit[] = new boolean[10]; // 0 ~ 9
	
	
	public static void main(String[] args) {
		
		int numbers[] = {1,2,3,4,6,7,8,0};
		int answer = solution(numbers);
		System.out.println(answer);

	}
	
	public static int solution(int[] numbers) {
        
		int answer = 0;
		
		for(int i = 0 ; i < numbers.length ; i++) {
			visit[numbers[i]] = true;
		}
		
		for(int i = 0 ; i < 10 ; i++) {
			if(visit[i] == false) {
				answer += i;
			}
		}
		
		return answer;
		
		
    }

}
