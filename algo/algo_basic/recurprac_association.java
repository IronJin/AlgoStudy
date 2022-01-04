package algoprac;


//정수 4를 1,2,3 의 조합으로 나타내는 방법의 수를 구하시오
//정수 n이 들어왔을때 1,2,3의 조합으로 나타낼수 있는 방법의 수
public class recurprac_association {

	public static int recur(int n) {
		
		if(n == 1) {
			return 1;
		}else if(n ==2) {
			return 2;
		}else if(n == 3) {
			return 4;
		}else {
			return recur(n-1) + recur(n-2) + recur(n-3);
		}
	}
	
	public static void main(String[] args) {
		
		int answer = recur(5);
		System.out.println(answer);
		
	}

}
