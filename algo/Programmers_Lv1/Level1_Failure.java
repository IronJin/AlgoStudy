import java.util.*;

public class Level1_Failure {

	public static void main(String[] args) {
		
		int N = 5;
		int stages[] = {2, 1, 2, 6, 2, 4, 3, 3};
		int answer[]=solution(N,stages);

		for(int i = 0 ; i < N ; i++) {
			System.out.println(answer[i]);
		}
	}
	
	public static int[] solution(int N, int[] stages) {
        int[] answer = new int[N];
        
        double rank[][] = new double[N][2];
        
        double clear[] = new double[N+1]; //index 스테이지에 도달해서 클리어까지 한 사람
        double reached[] = new double[N+1]; //스테이지에 도달한 사람의 수
        
        for(int i = 0 ; i < stages.length ; i++) {
        	int cur = stages[i];
        	for(int j = 1 ; j < cur ; j++) {
        		reached[j] ++;
        		clear[j] ++;
        	}
        	if(cur <= N) {
            	reached[cur]++;
        	}      	
        }
        
        for(int i = 0 ; i < N ; i++) {
    		double failure = 0;
        	if(reached[i+1] != 0) {
        		failure = ((reached[i+1] - clear[i+1]) / reached[i+1]);
        	}
        	rank[i][0] = i+1;
        	rank[i][1] = failure;
        }
        
        Arrays.sort(rank, new Comparator<double[]>() {
        	
        	@Override
        	public int compare(double[] o1, double[] o2) {
        		
        		if(o1[1] == o2[1]) {
        			return Double.compare(o1[0], o2[0]);
        		}else {
        			return Double.compare(o2[1], o1[1]);
        		}
        	}
        	
        });

        
        for(int i = 0 ; i < N ; i++) {
        	answer[i] = (int) rank[i][0];
        }
        
        return answer;
	}

}
