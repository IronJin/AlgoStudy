package algoprac;

//순차탐색 기본예시
public class seq_search {

	public static int seq(int[] data, int n) {
		
		for(int i = 0 ; i < data.length ;i++) {
			if(n == data[i]) {
				return data[i];
			}
		}
		return -1;
	}
	
	public static void main(String[] args) {
		
		int[] array = new int[100];
		
		for(int i = 0 ; i < 100 ; i++) {
			array[i] = (int)(Math.random()*100);
		}

		int answer = seq(array, 30);
		
		System.out.println(answer);
	}

}
