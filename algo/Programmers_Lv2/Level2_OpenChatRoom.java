import java.util.*;

public class Level2_OpenChatRoom {

	public static void main(String[] args) {
		
		String[] record = {"Enter uid1234 Muzi", "Enter uid4567 Prodo","Leave uid1234","Enter uid1234 Prodo","Change uid4567 Ryan"};
		System.out.println(record.length);
		ArrayList<String> answer = solution(record);
		System.out.println(answer.toString());

	}
    
	public static ArrayList<String> solution(String[] record) {
        ArrayList<String> answer = new ArrayList<>();
        HashMap<String, String> map = new HashMap<>();
        
        for(int i = 0 ; i < record.length ; i++) {
        	
        	StringTokenizer st = new StringTokenizer(record[i]);
        	String state = st.nextToken();
        	if(state.equals("Leave")) {
        		continue;
        	}
        	
        	String uid = st.nextToken();
        	String name = st.nextToken();
        	map.put(uid, name);
        	        	
        }
        
        for(int i = 0 ; i < record.length ; i++) {
        	StringTokenizer st = new StringTokenizer(record[i]);
        	String state = st.nextToken();
        	String uid = st.nextToken();
        	
        	if(state.equals("Change")) continue;
        	
        	if(state.equals("Enter")) {
        		answer.add(map.get(uid)+"´ÔÀÌ µé¾î¿Ô½À´Ï´Ù.");
        	}else {
        		answer.add(map.get(uid)+"´ÔÀÌ ³ª°¬½À´Ï´Ù.");
        	}
        	
        }
        
        return answer;
    }

	
}
