package DFS_BFS;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main_백준_1260_DFS와BFS_268ms {

	static List<Integer>[] list;
	static boolean[] isVisit;
	static StringBuilder sb = new StringBuilder();
	
	public static void main(String[] args) throws Exception {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		int V = Integer.parseInt(st.nextToken());
		
		list = new ArrayList[N + 1];
		for (int i = 0; i <= N; i++) {
			list[i] = new ArrayList<>();
		}
		
		for (int i = 0; i < M; i++) {
			st = new StringTokenizer(br.readLine());
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			list[a].add(b);
			list[b].add(a);
		}
		for (int i = 1; i <= N; i++) {
			Collections.sort(list[i]);
		}
		
		//DFS
		isVisit = new boolean[N + 1];
		dfs(V);
		sb.append("\n");
		//BFS
		isVisit = new boolean[N + 1];
		Queue<Integer> q = new LinkedList<>();
		q.offer(V);
		while (!q.isEmpty()) {
			int cur = q.poll();
			if (isVisit[cur])
				continue;
			isVisit[cur] = true;
			sb.append(cur).append(" ");
			for (Integer child : list[cur]) {
				q.offer(child);
			}
		}
		System.out.println(sb.toString());
	}//end main
	
	static void dfs(int cur) {
		if (isVisit[cur])
			return;
		isVisit[cur] = true;
		sb.append(cur).append(" ");
		for (Integer child : list[cur]) {
			dfs(child);
		}
	}
}//end class
