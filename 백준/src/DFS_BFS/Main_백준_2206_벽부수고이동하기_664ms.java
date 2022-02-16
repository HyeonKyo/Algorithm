package DFS_BFS;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;

public class Main_백준_2206_벽부수고이동하기_664ms {

	static int N;
	static int M;
	static char[][] m;
	static boolean[][][] v;
	static int[] dl = {-1, 0, 1, 0};
	static int[] dr = {0, 1, 0, -1};
	static int min = Integer.MAX_VALUE;
	
	public static void main(String[] args) throws Exception {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String[] tmp = br.readLine().split(" ");
		N = Integer.parseInt(tmp[0]);
		M = Integer.parseInt(tmp[1]);
		
		m = new char[N + 2][M + 2];
		v = new boolean[2][N + 2][M + 2];
		for (int i = 1; i <= N; i++) {
			String line = br.readLine();
			for (int j = 1; j <= M; j++) {
				m[i][j] = line.charAt(j - 1);
			}
		}
		//BFS
		Queue<int[]> q = new LinkedList<>();
		q.add(new int[] {1, 1, 0});
		int cnt = 0;
		boolean end = false;
		while (!end && !q.isEmpty()) {
			for (int i = q.size(); i > 0; i--) {
				int[] cur = q.poll();
				if (cur[0] == N && cur[1] == M) {
					end = true;
					break;
				}
				for (int j = 0; j < 4; j++) {
					int l = cur[0] + dl[j];
					int r = cur[1] + dr[j];
					if (m[l][r] == '0' && !v[cur[2]][l][r]) {
						v[cur[2]][l][r] = true;
						q.add(new int[] {l, r, cur[2]});
					} else if (cur[2] == 0 && m[l][r] == '1') {
						if (!v[cur[2] + 1][l][r]) {
							v[cur[2] + 1][l][r] = true;
							q.add(new int[] {l, r, cur[2] + 1});
						}
					}
				}
			}
			cnt++;
		}
		System.out.println(end ? cnt : -1);
	}//end main
}//end class

/*
 * DFS로 풀기 -> 시간 초과!!!
 * --------------------
 * BFS로 풀기
 * 1. 일반적인 BFS에 벽을 뚫는 경우를 고려하는 코드를 작성해야함.
 * 2. BFS도 각 노드에서 4방탐색 지점 0이면 큐에 저장하여 다음에 접근을 시도함
 * 3. 그러나 이미 방문한 노드면 굳이 순서가 더 늦는 경우에서 추가 접근할 필요가 없으므로 방문 체크를 해서 접근을 제한한것임
 * 4. 이 경우는 벽을 한번 뚫고 접근하는 경우가 생김
 * 5. 벽을 한 번 뚫은 경우에 방문한 경우를 체크한 것과 뚫지 않은 상태에서 접근한 경우 2가지로 방문체크 배열을 구분해서 체크
 * 
 * 
 * */
