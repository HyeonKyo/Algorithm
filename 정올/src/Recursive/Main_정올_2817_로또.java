package Recursive;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main_정올_2817_로또  {
	
	static int N;
	static int[] num;
	static StringBuilder sb = new StringBuilder();
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		num = new int[N];
		for (int i = 0; i < N; i++) {
			num[i] = Integer.parseInt(st.nextToken());
		}
		int[] assem = new int[6];
		recur(0, 0, assem);
		System.out.println(sb);
	}//end main
	
	static void recur(int idx, int depth, int[] assem) {
		if (depth >= 6) {
			for (int i = 0; i < 6; i++) {
				sb.append(assem[i]).append(" ");
			}
			sb.append("\n");
			return;
		}
		for (int i = 0; i <= N - 6; i++) {
			if (idx + i < N) {
				assem[depth] = num[idx + i];
				recur(idx + i + 1, depth + 1, assem);
			}
		}
	}
}//end class