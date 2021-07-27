import java.io.*;
import java.util.HashSet;
import java.util.StringTokenizer;

//운영체제의 page replacement 방법 중 optimal page replacement 와 똑같은 알고리즘
//가장 오랫동안 사용되지 않는 페이지를 희생 페이지로 선정하는 알고리즘
//메모리 공간을 page와 같은 크기의 frame 으로 나누고 이 frame 이 꽉 차있는 경우 다른 페이지가
//메모리에 할당받아야 하는 상황일때 가장 오랫동안 사용되지 않는 frame을 victim frame 으로 설정하는 방법
//이론상 최적의 알고리즘이지만 운영체제에서는 나중에 어떤 프로세스가 미리 쓰일지 모르기 때문에 현실적으로 구현이 어려움
//허나 이 문제에서는 다음에 어떠한 전자기기를 쓸것인지 나와있기때문에 이 최적 페이지 대체 알고리즘을 쓰면됨
//현재까지 풀면서 답을 다 알고도 구현할 수 없었던 구현에 어려웠던 문제 ㅠ
//hashset 사용해서 품 - 문제풀이시간 3시간;...

//그 외로 FIFO 알고리즘 -> 가장 먼저들어온 페이지를 메모리에서 삭제해주는 알고리즘
//LRU(least recently used) : 가장 오래 사용되지 않은 페이지를 교체해주는 알고리즘
//FIFO알고리즘 보다 효율적이며 많은 운영체제에서 사용중임
public class multitap_1700 {

	public static void main(String[] args) throws IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		StringTokenizer st =new StringTokenizer(br.readLine());
		
		int n = Integer.parseInt(st.nextToken());
		int k = Integer.parseInt(st.nextToken());
		
		int elec[] = new int[k];
		
		st = new StringTokenizer(br.readLine());
		int z = 0;
		while(st.hasMoreTokens()) {
			elec[z] = Integer.parseInt(st.nextToken());
			z++;
		}
		
		//출력으로 제출할 정답변수 선언
		int ans = 0;

		//값이 있는지 없는지 알 수 있음.
		//배열처럼 크기를 미리 선언할 필요도없으며 정적이 아닌 동적임
		HashSet<Integer> set = new HashSet<>();
		for(int i = 0 ; i < k ; i ++) {
			//해쉬셋을 콘센트라고 일단 가정
			//콘센트가 현재 내가 쓰려는 전자기기가 꽃혀있는지 확인
			//꽃혀있는경우 그냥 다음에 쓸 전자기기 확인하면됨
			//1. 콘센트가 비어있는지 확인하고 비어있는 콘센트가 있는경우 현재 내가쓰려는 전자기기가 꽂혀있는지 확인
			if(set.contains(elec[i])) continue;
			
			//2.안꽃혀있는경우 콘센트가 꽉차있는지 확인 꽉차있는경우를 확인해야함
			//3.그런경우가 아니라면 아래에 있는 if문을 건너뛰고 그냥 현재값을 해쉬셋에 추가해주면됨
			//해쉬 사이즈가 내가 처음에 입력한 크기가 되면 if문으로 들어가고 아니면 else로 들어면됨
			if(set.size() == n) {
				int idx = -1, target = 0;
				for(int t : set) {
					int tidx = 999;
					for(int j = i+1; j < k ; j++) {
						if(t == elec[j]) {
							tidx = j;
							break;
						}
					}
					//해쉬셋에 들어있는전자기기가 나중에 쓸일 없는 전자기기인 경우
					//index가 바뀔일이 없음.
					//그냥 그 값을 바로 해쉬셋에서 빼주면됨
					if(tidx == 999) {
						target = t;
						break;
					}else {
						if(tidx > idx) {
							idx = tidx;
							target = elec[idx];
						}
					}
				}
				//target에 해당하는 값을 해쉬에서 지워줌
				set.remove(target);
				ans++;
			}//if문의 끝
			
			//비어있으면 그냥 자동으로 추가되고
			//비어있지 않다면 바로앞의 if문에서 어느 한 전자기기가 삭제된 후 삽입이 됨
			set.add(elec[i]);
		}
	
	
	
	
	System.out.println(ans);
	
	
	}
}
