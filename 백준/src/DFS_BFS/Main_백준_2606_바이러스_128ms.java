package DFS_BFS;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class Main_백준_2606_바이러스_128ms {

	static List<Integer>[] list;
	static boolean[] isVisit;
	static int cnt;
	
	public static void main(String[] args) throws Exception {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		int link = Integer.parseInt(br.readLine());
		list = new ArrayList[N + 1];
		for (int i = 0; i <= N; i++) {
			list[i] = new ArrayList<>();
		}
		for (int i = 0; i < link; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			list[a].add(b);
			list[b].add(a);
		}
		//DFS
		isVisit = new boolean[N + 1];
		dfs(1);
		System.out.println(cnt);
	}//end main
	
	static void dfs(int cur) {
		isVisit[cur] = true;
		for (Integer child : list[cur]) {
			if (isVisit[child])
				continue;
			cnt++;
			dfs(child);
		}
	}
}//end class
