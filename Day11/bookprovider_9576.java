import java.io.*;
import java.util.ArrayList;
import java.util.StringTokenizer;

//�̺и�Ī�� �̿��Ѵٴ� ��Ʈ�� ��
public class bookprovider_9576 {

	static int count;
	static int n;
	static int m;
	//���ʿ� ������ �������� �����ʿ� ����Ǿ� �ִ� ������ �־��ִ� ����Ʈ �迭 ����
	static ArrayList<Integer> arr[];
	static boolean check[];
	//������ ����(å)
	static int book[];
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int t = Integer.parseInt(br.readLine());
		
		//�׽�Ʈ ���̽���ŭ ����
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
			}//�ѻ������ ���ϴ� å�� ����� ��̸���Ʈ�� �־��� �Ϸ�
			
			for(int i = 1 ; i<=m;i++) {
				for(int j = 0 ; j <= n ; j++) {
					check[j] = false;
				}
				if(dfs(i)) {
					count++;
				}
			}
			System.out.println(count);
			
		}//�׽�Ʈ ���̽� ���� ��
		

		
		
	}//�����Լ� ��
	

	//�湮ó���� ���� ���ش��� �� å�� ������ �ȵǾ��ְų� �� å�� �̹� ����� ������ �ٸ� å�� ����� �� �ִٸ�
	//�� å�� �ٸ� ������ ������ ���ְ� ���� ������ å�� ����
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
