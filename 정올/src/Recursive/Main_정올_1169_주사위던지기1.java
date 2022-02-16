package Recursive;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main_정올_1169_주사위던지기1 {
	
	static int N;
	static int M;
	static int[] num;
	static boolean[] ck = new boolean[7];
	static StringBuilder sb = new StringBuilder();
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		num = new int[N];
		
		switch (M) {
		case 1:
			dice1(0); // 중복 순열
			break;
		case 2:
			dice2(1, 0);
			break;
		case 3:
			dice3(0);
			break;
		}
		System.out.println(sb.toString());
	}//end main
	
	static void dice1(int depth) {
		if (depth >= N) {
			saveNum();
			return;
		}
		for (int i = 1; i <= 6; i++) {
			num[depth] = i;
			dice1(depth + 1);
		}
	}
	
	static void dice2(int start, int depth) {
		if (depth >= N) {
			saveNum();
			return;
		}
		
		int i = depth <= 0 ? 1 : num[depth - 1];
		for ( ; i <= 6; i++) {
			num[depth] = i;
			dice2(start + 1, depth + 1);
		}
	}
	
	static void dice3(int depth) {
		if (depth >= N) {
			saveNum();
			return;
		}
		for (int i = 1; i <= 6; i++) {
			if (!ck[i]) {
				num[depth] = i;
				ck[i] = true;
				dice3(depth + 1);
				ck[i] = false;
			}
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
