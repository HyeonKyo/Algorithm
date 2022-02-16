package Stack;

import java.io.BufferedReader;	
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main_백준_17298_오큰수_828ms {
	
	public static void main(String[] args) throws Exception {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		int n = Integer.parseInt(br.readLine());
		int[] numbers = new int[n];
		int[] stack = new int[n];
		int size = 0;
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		for (int i = 0; i < n; i++) {
			numbers[i] = Integer.parseInt(st.nextToken());
		}
		for (int i = n - 1; i >= 0; i--) {
			int cur = numbers[i];
			while (size > 0 && stack[size - 1] <= cur)
				size--;
			numbers[i] = size <= 0 ? -1 : stack[size - 1];
			stack[size++] = cur;
		}
		for (int i = 0; i < n; i++) {
			sb.append(numbers[i]).append(" ");
		}
		sb.setLength(sb.length() - 1);
		System.out.println(sb.toString());
	}//end main
}//end class
