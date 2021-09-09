package programmers;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;


//같은 길이를 가진 단어끼리만 Trie 구조를 만들것임
//단어를 뒤집어서도 Trie 구조를 만들것임
 
class Solution{
	class Trie{
		Trie[] child = new Trie[26];
		int count;
		int al = Character.getNumericValue('a');
		
		void insert(String str){
			Trie curr = this;
			for(char ch : str.toCharArray()) {
				curr.count++;
				int idx = Character.getNumericValue(ch) - al;
				if(curr.child[idx] == null) {
					curr.child[idx] = new Trie();
				}
				curr = curr.child[idx];
			}
			curr.count++;
		}
		
		int search(String str) {
			 Trie curr = this;
			 for(char ch : str.toCharArray()){
				 
				 if(ch == '?') return curr.count;
				 
				 curr = curr.child[Character.getNumericValue(ch) - al];
				 if(curr == null) {
					 return 0;
				 }
			 }
			return curr.count;
		}
	}
	
	Trie[] TrieRoot = new Trie[10000];
	Trie[] ReTrieRoot = new Trie[10000];
	
	public int[] solution(String[] words, String[] q) {
		int answer[] = new int[q.length];
		int ansIdx = 0;
		
		for(String str : words) {
			int idx = str.length() -1;
			if(TrieRoot[idx] == null) {
				TrieRoot[idx] = new Trie();
				ReTrieRoot[idx] = new Trie();
			}
			
			TrieRoot[idx].insert(str);
			str = new StringBuilder(str).reverse().toString();
			ReTrieRoot[idx].insert(str);
		}
		
		for(String str : q) {
			int idx = str.length()-1;
			//단어가 없는경우
			if(TrieRoot[idx] == null) {
				answer[ansIdx++] = 0;
				continue;
			}
			
			if(str.charAt(0) != '?') {
				answer[ansIdx++] = TrieRoot[idx].search(str);
			}else {
				str = new StringBuilder(str).reverse().toString();
				answer[ansIdx++] = ReTrieRoot[idx].search(str);
			}
		}
		return answer;
	}
}

public class search_2020 {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		String[] words = new String[6];
		String[] q = new String[5];
		
		for(int i = 0 ; i < 6 ; i++) {
			words[i] = br.readLine();
		}
		
		for(int i = 0 ; i < 5 ; i++) {
			q[i] = br.readLine();
		}
		
		Solution solution = new Solution();

		int arr[] = solution.solution(words, q);
		
		for(int i = 0 ; i < 5 ; i ++) {
			System.out.println(arr[i]);
		}
	}
}
