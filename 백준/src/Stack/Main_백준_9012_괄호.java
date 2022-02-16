package Stack;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Stack;

public class Main_백준_9012_괄호 {
	
	public static void main(String[] args) throws Exception {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		int T = Integer.parseInt(br.readLine());
		
		for (int i = 0; i < T; i++) {
			Stack<Character> stack = new Stack<>();
			String str = br.readLine();
			boolean notValid = false;
			for (int j = 0; j < str.length(); j++) {
				char c = str.charAt(j);
				if (c == '(') {
					stack.push(c);
					continue;
				}
				if (stack.isEmpty() || stack.pop() != '(') {
					notValid = true;
					break;
				}
			}
			if (!notValid && stack.isEmpty())
				sb.append("YES");
			else
				sb.append("NO");
			sb.append("\n");
		}
		System.out.print(sb.toString());
	}//end main
}//end class