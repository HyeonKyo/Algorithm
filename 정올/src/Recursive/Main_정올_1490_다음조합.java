package Recursive;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main_정올_1490_다음조합  {
	
	static int N;
	static int K;
	static int[] num;
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		K = Integer.parseInt(st.nextToken());
		num = new int[K];
		st = new StringTokenizer(br.readLine());
		for (int i = 0; i < K; i++) {
			num[i]= Integer.parseInt(st.nextToken());
		}
		recur(K - 1);
	}//end main
	
	static void recur(int depth) {
		if (depth < 0) {
			System.out.println("NONE");
			return;
		}
		if (num[depth] >= N - (K - (depth + 1))) {
			recur(depth - 1);
			return;
		}
		num[depth]++;
		for (int j = depth + 1; j < K; j++) {
			num[j] = num[j - 1] + 1;
		}
		StringBuilder sb = new StringBuilder();
		for (int j = 0; j < K; j++) {
			sb.append(num[j]).append(" ");
		}
		System.out.println(sb);
	}
}//end class