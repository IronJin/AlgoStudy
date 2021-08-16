import java.io.*;
public class reverse_17609 {

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int n = Integer.parseInt(br.readLine());
		
		String[] str = new String[n];
		
		for(int i = 0 ; i < n ; i ++) {
			str[i] = br.readLine();
			int a = 0;
			int b = str[i].length()-1;
			int diff = 0;
			int left = 0;
			int right = 0;
			
			//검사하다가 틀린거나오면 그때의 왼쪽과 오른쪽을 가리키는 인덱스를 left와 right에 저장
			while(a<b) {
				if(str[i].charAt(a) == str[i].charAt(b)) {
					a++;
					b--;
				}else {
					left = a;
					right = b;
					//일단 오류가 하나 났다는 표시를 해줌
					diff++;
					break;
				}
			}
			
			//왼쪽 한칸 건너뛰고부터 생각
			//현재 a와 b의 인덱스에서 a만 하나 증가시켜 생각을 해줌
			//diff가 1일때만 실행
			//여기서도 오류가 생기면 diff 값 증가를 하나 더해줌
			if(diff == 1) {
				a++;
				while(a<b) {
					if(str[i].charAt(a) == str[i].charAt(b)) {
						a++;
						b--;
					}else {
						diff++;
						break;
					}
				}
			}
			
			//왼쪽을 하나 건너뛰고 생각을 해봤을때 오류가 생겼으면 왼쪽은 그대로 두고 오른쪽만 생각해
			if(diff == 2) {
				a = left;
				b = right;
				b--;
				while(a<b) {
					if(str[i].charAt(a) == str[i].charAt(b)) {
						a++;
						b--;
					}else {
						diff++;
						break;
					}
				}
			}
			
			if(diff == 0) {
				System.out.println(0);
			//diff 값이 처음오류 생길때 1 , 왼쪽검사할때 오류생기면 2 가 됨 3이되면 오른쪽검사도 오류가생긴다는 뜻임
			}else if(diff > 0 && diff<=2) {
				System.out.println(1);
			}else {
				System.out.println(2);
			}
			
			
		}

	}

}
