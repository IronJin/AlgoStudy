
import java.util.Scanner;


public class sum_of_number_1789 {

	
	
	public static void main(String[] args) {



		Scanner sc = new Scanner(System.in);
		long s = sc.nextLong();
		long sum = 0;
		long i = 0;
		while(sum <= s) {
			i++;
			sum = sum+ i;
		}
		System.out.println(i-1);
	}
}
