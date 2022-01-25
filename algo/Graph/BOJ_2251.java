
import java.io.*;
import java.util.*;

/*
 * A물통 B물통 C물통에 존재하는 물의 양을 배열 즉, 좌표로 나타내줌
 * 그리고 그 좌표에서 각 물통으로 이동가능한 경우(좌표)들을 방향그래프로 만들어줌
 * 물통의 상태를 나타내는 구조체를 만들어 컨트롤해줌
 */

public class BOJ_2251 {

	static class State{
		//각 물통에 들어있는 물의 양을 나타내는 길이 3의 배열을 만들어줌
		int[] X;
		State(int[] _X){
			X = new int[3];
			for(int i = 0 ; i < 3 ; i++) {
				X[i] = _X[i];
			}
		}
		
		State move(int from, int to, int[] limit) {
			int[] nx = new int[] {X[0],X[1],X[2]};
			
			//from에서 to 로 이동할때 두가지 경우가 생김
			//1. from 의 물통이 먼저 비는경우
			//2. to의 물통이 먼저 꽉 차는경우
			if(X[from] + X[to] >= limit[to]) {
				nx[from] = X[from] - limit[to] + X[to];
				nx[to] = limit[to];
			}else {
				nx[to] = X[from] + X[to];
				nx[from] = 0;
			}
			
			return new State(nx);
		}
		
	}
	

	static int Limit[] = new int[3];
	static boolean visit[][][] = new boolean[201][201][201];
	static boolean possible[] = new boolean[201];
	
	static void pro() {
		bfs(0,0,Limit[2]);
		for(int i = 0 ; i < possible.length ; i++) {
			if(possible[i] == true) {
				System.out.print(i+" ");
			}
		}
		
	}
	
	static void bfs(int x1, int x2, int x3) {
		Queue<State> q = new LinkedList<>();
		q.add(new State(new int[] {x1, x2, x3}));
		visit[x1][x2][x3] = true;
		
		while(!q.isEmpty()) {
			State st = q.poll();
			if(st.X[0] == 0) {
				possible[st.X[2]] = true;
			}
			for(int from = 0 ; from < 3 ; from++) {
				for(int to = 0 ; to < 3 ; to++) {
					if(to == from) {
						continue;
					}
					State nextst = st.move(from, to, Limit);
					if(!visit[nextst.X[0]][nextst.X[1]][nextst.X[2]]) {
						q.add(new State(new int[] {nextst.X[0],nextst.X[1],nextst.X[2]}));
						visit[nextst.X[0]][nextst.X[1]][nextst.X[2]] = true;
					}
				}
			}
		}
	}
	
	public static void main(String[] args) throws IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		Limit[0]= Integer.parseInt(st.nextToken());
		Limit[1]= Integer.parseInt(st.nextToken());
		Limit[2]= Integer.parseInt(st.nextToken());
		pro();
	}

}
