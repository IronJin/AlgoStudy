import java.io.*;
import java.util.Arrays;

public class bj_rope_2217 {

	//제일 적은 최대 중량을 가지는 로프를 택한 후 로프의 개수만큼 곱해주면 됨
	public static void main(String[] args) throws NumberFormatException, IOException{

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int n = Integer.parseInt(br.readLine());
		
		int a[] = new int[n];
		
		for(int i = 0 ; i < a.length ; i++) {
			a[i] = Integer.parseInt(br.readLine());
		}
		Arrays.sort(a);
		int max = 0;
		
		int i = 0;
		//작은 것부터 정렬후 제일 작은것을 하나씩 지워가면서 최대 중량을 기존 방식대로 계산
		//기존방식이라고 하면 제일 적은 최대 중량을 가지는 로프를 기준으로 계산하는 방식
		while(i != n) {
			if(max <= a[i] * (n-i)) {
			max = a[i] * (n-i);
			}
			i++;
		}
		System.out.println(max);
	}
}
