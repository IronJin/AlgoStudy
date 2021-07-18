import java.io.*;
import java.util.Arrays;
import java.util.Comparator;
import java.util.StringTokenizer;

//런타임 오류 발생
public class Newrecruits_1946 {
	
	public static void main(String[] args) throws NumberFormatException, IOException{

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		//테스트 케이스 개수
		int t = Integer.parseInt(br.readLine());
		
		for(int i = 0 ; i < t ; i ++) {
			int a = Integer.parseInt(br.readLine());
			int count = 0;
			int grade[][] = new int[a][2];
			for(int j = 0 ; j < grade.length ; j++) {
				StringTokenizer st = new StringTokenizer(br.readLine());
				grade[j][0] = Integer.parseInt(st.nextToken());
				grade[j][1] = Integer.parseInt(st.nextToken());
			}
			Arrays.sort(grade, new Comparator<int[]>() {
				@Override
				public int compare(int [] t1, int[] t2) {
					return t1[0] - t2[0];
				}
			});
			int min = grade[0][1];
			for(int j = 0 ; j < grade.length ; j ++) {
				if(grade[j][1] <= min) {
					count++;
					min = grade[j][1];
				}
			}
			System.out.println(count);
		}
	}
}
