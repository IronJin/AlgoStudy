import java.util.Arrays;
import java.util.Scanner;

public class numbertie_1744 {

	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);

		int t = sc.nextInt();
		
		int arr[] = new int[t];
		
		for(int i = 0 ; i < t ; i ++) {
			arr[i] = sc.nextInt();
		}
		long sum = 0;
		Arrays.sort(arr);
		
		if(t != 1) {
		for(int i = arr.length-1 ; i>0 ; i= i-2) {
			if(arr[i] * arr[i-1] > 0 ) {
				if(i - 2 == 0 && arr[i] > 0 && arr[i-1] >0) {
					if(arr[i-2] > 0 && arr[i-1] != 1 && arr[i] != 1) {
						sum += arr[i] * arr[i-1] + arr[i-2];
					}else {
						if(arr[i] * arr[i-1] + arr[i-2] > arr[i] + arr[i-1] + arr[i-2]) {
							sum += arr[i] *arr[i-1] + arr[i-2];
						}else {
							sum += arr[i] + arr[i-1] + arr[i-2];
						}
					}
				}else if(arr[i] < 0 && (i%2) == 0) {
					sum += arr[i];
					i++;
				}else {
					if(arr[i-1] != 1 && arr[i] != 1) {
						sum += arr[i] * arr[i-1];
					}else {
						sum += arr[i] + arr[i-1];
					}
				}
			}else if(arr[i] == 0 && arr[i-1] == 0) {
				i++;
			}
			else if(arr[i]> 0 && arr[i-1] ==0) {
				sum += arr[i];
				i++;
			}else if(arr[i] ==0 && arr[i-1] < 0) {
				if(i%2 == 0) i++;
			}else if(arr[i] * arr[i-1] <0) {
				if(i%2 == 0) {
					sum += arr[i];
					i++;
				}else {
					if(arr[i] * arr[i-1] > arr[i] + arr[i-1]) {
						sum += arr[i] * arr[i-1];
					}else {
						sum += arr[i] + arr[i-1];
					}
				}
			}
		}
		System.out.println(sum);
		}
		else System.out.println(arr[0]);
	}

}
