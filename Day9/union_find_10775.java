import java.util.Scanner;

//대표적인 그래프 알고리즘
//disjoint set(서로소 집합) 알고리즘이라고도 불림
//find 는 연결되어있는지 확인해주는 함수

public class union_find_10775 {
	
	static int[] gate = new int[100001];

	
	//외울것
	public static int find(int x){
		if(x == gate[x]) return x;
		return gate[x] = find(gate[x]);
	}
	
	//부모노드를 합치는 함수
	//외울것
	public static void union(int a, int b) {
		a = find(a);
		b = find(b);
		
		//더 작은값쪽으로 부모를 합쳐줌
		//b가 더 작은값임
		if(a != b) {
			gate[a] = b;
		}
		
	}
	
	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);

		//게이트 수
		int g = sc.nextInt();
		//비행기 수
		int p = sc.nextInt();
		
		int gi[] = new int[p];
		
		for(int i = 0 ; i < p ; i++) {
			gi[i] = sc.nextInt();
		}
		
		int ans = 0;
		
		//배열하나하나를 그래프 정점이라고 생각하고 서로 이어져있는상태가 아님
		//즉, 자기 배열번호의 값이 자기 자신을 가리키고 있는 상태임
		for(int i = 1 ; i <= g ; i++) {
			gate[i] = i;
		}
		
		for(int i = 0 ; i < p ; i++) {
			int v = find(gi[i]);
			if(v == 0) break;
			//1~v 중에서 가장 큰 값을 도킹한것이므로 그보다 한단계 작은 정점과 합쳐준다고 생각하면됨
			//근데 v-1이 
			union(v, v-1);
			ans++;
		}
		System.out.println(ans);
	}

}
