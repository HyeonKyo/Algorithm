package DFS_BFS;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class Main_백준_9372_상근이의여행 {
	
	static int N, M, end, min;
	static List<List<Integer>> g;
	static int[] cnt;
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		int TC = Integer.parseInt(br.readLine());
		for (int i = 0; i < TC; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			N = Integer.parseInt(st.nextToken());
			M = Integer.parseInt(st.nextToken());
			g = new ArrayList<>(N + 1);
			for (int j = 0; j <= N; j++) {
				g.add(new ArrayList<Integer>());
			}
			for (int j = 0; j < M; j++) {
				st = new StringTokenizer(br.readLine());
				int a = Integer.parseInt(st.nextToken());
				int b = Integer.parseInt(st.nextToken());
				g.get(a).add(b);
				g.get(b).add(a);
			}
			end = (1 << N + 1) - 1;
			min = Integer.MAX_VALUE;
			cnt = new int[N + 1];
			cnt[1] = 1;
			dfs(1, 0, 1);
			sb.append(min).append("\n");
		}
		System.out.print(sb.toString());
	}//end main
	
	static void dfs(int cur, int move, int bit) {
		
		bit |= (1 << cur);
		
		if (bit == end) {
			if (min > move)
				min = move;
			return;
		}
		
		if (cnt[cur] >= 3)
			return;
		
		for (int n : g.get(cur)) {
			if (move < min)
				cnt[n]++;
				dfs(n, move + 1, bit);
				cnt[n]--;
		}
	}
}//end class

/*
 * 
 * 
 * 
 * */
