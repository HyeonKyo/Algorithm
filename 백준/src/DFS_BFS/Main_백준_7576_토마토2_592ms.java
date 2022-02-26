package DFS_BFS;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main_백준_7576_토마토2_592ms {

	static int[] dl = {-1, 0, 1, 0};
	static int[] dr = {0, 1, 0, -1};
	static final int L = 0;
	static final int R = 1;
	
	public static void main(String[] args) throws Exception {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int M = Integer.parseInt(st.nextToken());
		int N = Integer.parseInt(st.nextToken());
		
		Queue<int[]> q = new LinkedList<int[]>();
		int[][] map = new int[N][M];
		int raw = N * M;
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < M; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
				if (map[i][j] == 0)
					continue;
				if (map[i][j] == 1)
					q.offer(new int[] {i, j});
				raw--;
			}
		}
		
		int day = -1;
		while (!q.isEmpty()) {
			int len = q.size();
			for (int i = 0; i < len; i++) {
				int[] cur = q.poll();
				
				for (int j = 0; j < 4; j++) {
					int il = cur[L] + dl[j];
					int ir = cur[R] + dr[j];
					if (il < 0 || il >= N || ir < 0 || ir >= M
							|| map[il][ir] != 0)
						continue;
					map[cur[L]][cur[R]] = 1;
					q.offer(new int[] {il, ir});
					raw--;
				}
			}
			day++;
		}
		System.out.println(raw <= 0 ? day : -1);
	}
}//end class

