package Stack;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Stack;
import java.util.StringTokenizer;

public class Main_백준_2493_탑_732ms {
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		
		int n = Integer.parseInt(br.readLine());
		Stack<Integer> stack = new Stack<>();
		int[] height = new int[n + 1];
		StringTokenizer st = new StringTokenizer(br.readLine());
		for (int i = 1; i <= n; i++) {
			height[i] = Integer.parseInt(st.nextToken());
			while (!stack.isEmpty() && height[stack.peek()] < height[i]) {
				stack.pop();
			}
			if (stack.isEmpty()) {
				sb.append("0 ");
			} else {
				sb.append(stack.peek()).append(" ");
			}
			stack.push(i);
		}
		System.out.println(sb.toString());
	}
}
