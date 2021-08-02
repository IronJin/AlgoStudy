import java.io.*;
import java.util.StringTokenizer;

//DFS 를 사용한 알고리즘
//깊이우선 탐색 알고리즘
//여러 노드가 연결되어 있는경우 일단 연결되어있는 정점과 노드를 따라 계속해서 탐색해나가는 것
//도착한 지점에 방문했다고 하면서 백트래킹? 을 사용할때 보통 깊이우선탐색을 사용한다고 함
//어차피 길 하나만 파악하면서 가는것이므로 그냥 상식적으로 생각해보았을때 너비보단 깊이우선탐색을 사용하는것이 맞음
//추가적으로 오른쪽 위, 오른쪽, 오른쪽 아래 이런식으로 길을 찾아나가야 한다는게 그나마 그리디알고리즘이라고 할 수 있음

public class bread_3109 {

	static int ab[][];
	static int a;
	static int b;
	
	public static void main(String[] args) throws IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		a = Integer.parseInt(st.nextToken());
		b = Integer.parseInt(st.nextToken());

		ab = new int[a][b];
		
		for(int i = 0 ; i<a ; i++) {
			String str = br.readLine();
			
			for(int j = 0 ; j < b ; j++) {
				if(str.charAt(j) == '.') {
					ab[i][j] = 0;
				}else if(str.charAt(j) == 'x'){
					ab[i][j] = 1;
				}
			}
		}
		
		int count = 0;
		
		for(int i = 0 ; i < a; i++) {
			if(dfs(i,0)) {
				count++;
			}
		}
		
		System.out.println(count);
	}
	
	public static boolean dfs(int x, int y) {
		
		//도착한 지역은 무조건 1처리해줘야함
		//이유 : 도착한 지점에서 false가 반환되는경우 즉, 어차피 그 지점에서는 빵집에 도달할 수 없는 지역이기 때문
		
		ab[x][y] = 1;
		
		//빵집에 도착한 경우
		if(y == b-1) {
			return true;
		}
		//여기서부터 재귀함수 호출
		//오른쪽 위로 가는경우
		if(x>0 && ab[x-1][y+1] == 0) {
			if(dfs(x-1,y+1)) {
				return true;
			}
		}
		//오른쪽으로 가는경우
		if(ab[x][y+1] == 0) {
			if(dfs(x,y+1)) {
				return true;
			}
		}
		//오른쪽 아래
		if(x<a-1 && ab[x+1][y+1] == 0) {
			if(dfs(x+1,y+1)) {
				return true;
			}
		}
		
		return false;
	}
	
	
	

}
