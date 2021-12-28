import java.util.Scanner;

public class dongjun_2847 {

	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		int t = sc.nextInt();
		
		int n[] = new int[t];
		
		for(int i = 0 ; i < t ; i ++) {
			n[i] = sc.nextInt();
		}
		int count = 0;
		
		//맨 마지막 레벨/ 즉 배열의 맨 마지막부터 검사해서 그 전의 배열보다 높은 값이면 현재 배열의 값에 -1만큼차이나게 해주면됨
		for(int i = n.length-1 ; i >0 ; i--) {
			if(n[i] <= n[i-1]) {
				int minus = n[i] -1;
				count += n[i-1] - minus;
				n[i-1] = minus;
			}
		}
		System.out.println(count);

	}

}
