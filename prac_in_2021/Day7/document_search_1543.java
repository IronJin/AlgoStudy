import java.util.Scanner;

public class document_search_1543 {

	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);

		String str = sc.nextLine();
		String st = sc.nextLine();
		
		str = str.replaceAll(st, "*");
		int count = 0;
		for(int i = 0 ; i < str.length() ; i++) {
			if(str.charAt(i) == '*') {
				count++;
			}
		}
		System.out.println(count);
	}

}
