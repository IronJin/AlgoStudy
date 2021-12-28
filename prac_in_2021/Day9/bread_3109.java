import java.io.*;
import java.util.StringTokenizer;

//DFS �� ����� �˰���
//���̿켱 Ž�� �˰���
//���� ��尡 ����Ǿ� �ִ°�� �ϴ� ����Ǿ��ִ� ������ ��带 ���� ����ؼ� Ž���س����� ��
//������ ������ �湮�ߴٰ� �ϸ鼭 ��Ʈ��ŷ? �� ����Ҷ� ���� ���̿켱Ž���� ����Ѵٰ� ��
//������ �� �ϳ��� �ľ��ϸ鼭 ���°��̹Ƿ� �׳� ��������� �����غ������� �ʺ񺸴� ���̿켱Ž���� ����ϴ°��� ����
//�߰������� ������ ��, ������, ������ �Ʒ� �̷������� ���� ã�Ƴ����� �Ѵٴ°� �׳��� �׸���˰����̶�� �� �� ����

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
		
		//������ ������ ������ 1ó���������
		//���� : ������ �������� false�� ��ȯ�Ǵ°�� ��, ������ �� ���������� ������ ������ �� ���� �����̱� ����
		
		ab[x][y] = 1;
		
		//������ ������ ���
		if(y == b-1) {
			return true;
		}
		//���⼭���� ����Լ� ȣ��
		//������ ���� ���°��
		if(x>0 && ab[x-1][y+1] == 0) {
			if(dfs(x-1,y+1)) {
				return true;
			}
		}
		//���������� ���°��
		if(ab[x][y+1] == 0) {
			if(dfs(x,y+1)) {
				return true;
			}
		}
		//������ �Ʒ�
		if(x<a-1 && ab[x+1][y+1] == 0) {
			if(dfs(x+1,y+1)) {
				return true;
			}
		}
		
		return false;
	}
	
	
	

}
