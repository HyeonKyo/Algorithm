package DFS_BFS;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main_백준_11725_트리의부모찾기_640ms {

	public static void main(String[] args) throws Exception {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		int N = Integer.parseInt(br.readLine());
		List<Integer>[] list = new ArrayList[N + 1];
		for (int i = 0; i < N + 1; i++) {
			list[i] = new ArrayList<Integer>();
		}
		
		for (int i = 1; i <= N - 1; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			list[a].add(b);
			list[b].add(a);
		}
		
		//BFS
		int[] result = new int[N + 1];
		boolean[] isVisit = new boolean[N + 1];
		Queue<Integer> q = new LinkedList<>();
		q.offer(1);
		while (!q.isEmpty()) {
			int cur = q.poll();
			if (isVisit[cur])
				continue;
			isVisit[cur] = true;
			for (Integer child : list[cur]) {
				q.offer(child);
				if (result[child] == 0)
					result[child] = cur;
			}
		}
		for (int i = 2; i <= N; i++) {
			sb.append(result[i]).append("\n");
		}
		System.out.print(sb.toString());
	}//end main
}//end class
