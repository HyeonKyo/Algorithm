package Recursive;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main_정올_1175_주사위던지기2 {
	
	static int N;
	static int M;
	static int[] num;
	static StringBuilder sb = new StringBuilder();
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		num = new int[N];
		
		dice(0, 0);
		System.out.println(sb.toString());
	}//end main
	
	static void dice(int sum, int depth) {
		if (depth >= N) {
			if (sum == M)
				saveNum();
			return;
		}
		if (sum >= M)
			return;
		for (int i = 1; i <= 6; i++) {
			num[depth] = i;
			dice(sum + i, depth + 1);
		}
	}
	
	static void saveNum() {
		for (int i = 0; i < N; i++) {
			sb.append(num[i]).append(" ");
		}
		sb.deleteCharAt(sb.length() - 1);
		sb.append("\n");
	}
}//end class