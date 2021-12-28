import java.io.*;
import java.util.Arrays;
import java.util.StringTokenizer;

public class matrix_1080 {

	public static void main(String[] args) throws IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int row = Integer.parseInt(st.nextToken());
		int column = Integer.parseInt(st.nextToken());
		
		int a[][] = new int[row][column];
		int b[][] = new int[row][column];
		
		int count = 0;
		
		//a행렬 입력
		for(int i = 0 ; i < row ; i ++) {
			String str = br.readLine();
			for(int j = 0 ; j < column ; j++) {
				a[i][j] = str.charAt(j)-'0';
			}
		}
		//b행렬 입력
		for(int i = 0 ; i < row ; i ++) {
			String str = br.readLine();
			for(int j = 0 ; j < column ; j ++) {
				b[i][j] = str.charAt(j) - '0';
			}
		}
		//위에까지가 입력을 완료한 상태
		
		
		//a행렬을 3*3 부분행렬으로써 값을 모두 바꿔주기 위해 코드 구현
		if(row >=3 && column >=3) {
			for(int i = 0 ; i <= row - 3 ; i ++) {
				for(int j = 0 ; j <= column -3 ; j++) {
					if(a[i][j] != b[i][j]) {
						count++;
						for(int k = i; k<=i+2;k++) {
							for(int z = j ; z <= j+2 ; z++) {
								a[k][z] = 1- a[k][z];
							}
						}
					}
				}
			}
			if(Arrays.deepEquals(a, b) == true) {
				System.out.println(count);
			}else {
				System.out.println(-1);
			}
		//여기서부터는 컬럼과 로우의 길이가 3미만인 경우 한번 바꿨을때 똑같은지를 봄
		}else {
			if(Arrays.deepEquals(a, b) == true) {
				System.out.println(0);
			}else {
				System.out.println(-1);
			}
		}
	}

}
