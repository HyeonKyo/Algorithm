package DFS_BFS;

import java.io.BufferedReader;	
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main_백준_9372_상근이의여행2 {
	
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
//			end = (1 << N + 1) - 1;
//			//BFS를 1부터 N까지
//			for (int start = 1; start <= N; start++) {
//				min = Integer.MAX_VALUE;
//				int ret = bfs(start);
//				if (min > ret)
//					min = ret;
//			}
			min = N - 1;
			
			sb.append(min).append("\n");
		}
		System.out.print(sb.toString());
	}//end main
	
	static int bfs(int start) {
		int[] ck = new int[N + 1];
		Queue<int[]> q = new LinkedList<>();
		q.add(new int[] {start, 1 | (1 << start)});
		int cnt = 0;
		while (!q.isEmpty()) {
			int size = q.size();
			for (int i = 0; i < size; i++) {
				int[] cur = q.poll();
				if (cur[1] == end) {
					return cnt;
				}
				if (++ck[cur[0]] >= N)
					continue;
				for (Integer n : g.get(cur[0])) {
					q.add(new int[] {n, cur[1] | (1 << n)});
				}
			}
			cnt++;
		}
		return cnt;
	}
}//end class