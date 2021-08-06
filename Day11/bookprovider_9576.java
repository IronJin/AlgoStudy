import java.io.*;
import java.util.ArrayList;
import java.util.StringTokenizer;

//이분매칭을 이용한다는 힌트만 봄
public class bookprovider_9576 {

	static int count;
	static int n;
	static int m;
	//왼쪽에 정점을 기준으로 오른쪽에 연결되어 있는 정점을 넣어주는 리스트 배열 선언
	static ArrayList<Integer> arr[];
	static boolean check[];
	//오른쪽 정점(책)
	static int book[];
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int t = Integer.parseInt(br.readLine());
		
		//테스트 케이스만큼 실행
		for(int z = 0 ; z < t; z++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			count = 0;
			n = Integer.parseInt(st.nextToken());
			m = Integer.parseInt(st.nextToken());
			check = new boolean[n+1];
			book = new int[n+1];
			arr = new ArrayList[m+1];
			for(int i = 1; i<=m ; i++) {
				arr[i] = new ArrayList<>();
				st= new StringTokenizer(br.readLine());
				int a = Integer.parseInt(st.nextToken());
				int b = Integer.parseInt(st.nextToken());
				for(int j = a ; j <= b ; j++) {
					arr[i].add(j);
				}
			}//한사람마다 원하는 책이 어떤건지 어레이리스트에 넣어줌 완료
			
			for(int i = 1 ; i<=m;i++) {
				for(int j = 0 ; j <= n ; j++) {
					check[j] = false;
				}
				if(dfs(i)) {
					count++;
				}
			}
			System.out.println(count);
			
		}//테스트 케이스 포문 끝
		

		
		
	}//메인함수 끝
	

	//방문처리를 먼저 해준다음 그 책이 선택이 안되어있거나 그 책과 이미 연결된 정점이 다른 책과 연결될 수 있다면
	//그 책을 다른 정점과 연결을 해주고 내가 선택한 책을 연결
	static boolean dfs(int a) {
		for(int node : arr[a]) {
			if(check[node]) continue;
			check[node] = true;
			if(book[node] == 0 || dfs(book[node])) {
				book[node] = a;
				return true;
			}
		}
		return false;
	}
	

}
