package Stack;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main_백준_10828_스택 {
	
	public static void main(String[] args) throws Exception {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		StringTokenizer st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());
		int[] stack = new int[N];
		int size = 0;
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			switch (st.nextToken()) {
			case "push":
				stack[size++] = Integer.parseInt(st.nextToken());
				break;
			case "pop":
				if (size == 0)
					sb.append(-1);
				else
					sb.append(stack[--size]);
				sb.append("\n");
				break;
			case "size":
				sb.append(size).append("\n");
				break;
			case "empty":
				sb.append(size == 0 ? 1 : 0).append("\n");
				break;
			case "top":
				sb.append(size == 0 ? -1 : stack[size - 1]).append("\n");
				break;
			}
		}
		System.out.print(sb);
	}
}

