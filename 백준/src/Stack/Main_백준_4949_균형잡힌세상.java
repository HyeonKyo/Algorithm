package Stack;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Stack;

public class Main_백준_4949_균형잡힌세상 {
	
	public static void main(String[] args) throws Exception {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		
		while (true) {
			String str = br.readLine();
			if (str.equals("."))
				break;
			Stack<Character> stack = new Stack<>();
			boolean notValid = false;
			for (int j = 0; j < str.length(); j++) {
				char c = str.charAt(j);
				if (checkType(c) < 0)
					continue;
				if (isOpen(c)) {
					stack.push(c);
					continue;
				}
				if (stack.isEmpty()) {
					notValid = true;
					break;
				}
				char tmp = stack.pop();
				if (!isOpen(tmp) || checkType(tmp) != checkType(c)) {
					notValid = true;
					break;
				}
			}
			if (!notValid && stack.isEmpty())
				sb.append("yes");
			else
				sb.append("no");
			sb.append("\n");
		}
		System.out.print(sb.toString());
	}//end main
	
	static boolean isOpen(char c) {
		if (c == '(' || c == '[')
			return true;
		return false;
	}
	
	static int checkType(char c) {
		if (c == '(' || c == ')')
			return 1;
		else if (c == '[' || c == ']')
			return 2;
		return -1;
	}
}//end class