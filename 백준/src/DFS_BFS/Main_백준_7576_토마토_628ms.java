package DFS_BFS;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main_백준_7576_토마토_628ms {

	static int[] dl = {-1, 0, 1, 0};
	static int[] dr = {0, 1, 0, -1};
	
	public static void main(String[] args) throws Exception {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int M = Integer.parseInt(st.nextToken());
		int N = Integer.parseInt(st.nextToken());
		
		int[][] m = new int[N + 2][M + 2];
		for (int i = 1; i <= M; i++) {
			m[0][i] = -1;
			m[N + 1][i] = -1;
		}
		for (int i = 0; i <= N; i++) {
			m[i][0] = -1;
			m[i][M + 1] = -1;
		}
		
		Queue<int[]> q = new LinkedList<int[]>();
		int tmp = 0;
		int cnt = 0;
		//입력 받으면서 1인 경우는 인덱스를 queue에 넣어줌
		//0인 경우는 카운트
		for (int i = 1; i <= N; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 1; j <= M; j++) {
				tmp = Integer.parseInt(st.nextToken());
				if (tmp == 1) {
					q.add(new int[] {i, j});
				} else if (tmp == 0) {
					cnt++;
				}
				m[i][j] = tmp;
			}
		}
		
		int day = 0;
		while (!q.isEmpty() && cnt > 0) {
			//하루 씩 BFS진행
			for (int i = q.size(); i > 0; i--) {
				int[] cur = q.poll();
				for (int j = 0; j < 4; j++) {
					int l = cur[0] + dl[j];
					int r = cur[1] + dr[j];
					if (m[l][r] == 0) {
						m[l][r] = 1;
						q.add(new int[] {l, r});
						cnt--;
					}
				}
			}
			day++;
		}
		//0이 다없어진 경우는 day출력
		System.out.println(cnt > 0 ? -1 : day);
	}
}//end class

