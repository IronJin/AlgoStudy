import java.io.*;
import java.util.Arrays;
import java.util.StringTokenizer;

//잃어버린 괄호
public class bj1541 {

	public static void main(String[] args) throws NumberFormatException, IOException{

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int plus1 = 0;
		int minus1 = 0;
		//식 입력
		String str = br.readLine();
		//-를 기준으로 나눔 
		String[] minus = str.split("-");
		
		for(int i = 0 ; i < minus.length ; i++) {
			//맨 처음에 들어간 것들은 무조건 더해줘야 하는것임
			if(i == 0 ) {
				StringTokenizer st = new StringTokenizer(minus[i],"+");
				while(st.hasMoreTokens()) {
					plus1 += Integer.parseInt(st.nextToken());
				}
				//처음 - 이후부터 등장하는 모든 + 들을 더해준다음 빼면 됨
			}else {
				StringTokenizer st = new StringTokenizer(minus[i],"+");
				while(st.hasMoreTokens()) {
					minus1 += Integer.parseInt(st.nextToken());
				}
			}
		}
		System.out.println(plus1 - minus1);
	}
}
