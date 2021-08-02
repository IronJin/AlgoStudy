import java.io.*;

//맨처음 컵홀더는 무조건 꽂혀있는거라 count 를 1로 시작
//LL을 하나로 보고 count 해주고 count 가 n 이되면 반복문 종료
public class cupholder_2810 {

	public static void main(String[] args) throws NumberFormatException, IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		
		String str = br.readLine();
		
		int count = 1;
		
		for(int i = 0 ; i < n ; i++) {
			if(count == n) break;
			if(str.charAt(i) == 'L') {
				i++;
				count++;
			}
			if(str.charAt(i) == 'S') {
				count++;
			}
		}

		System.out.println(count);
		
	}

}
