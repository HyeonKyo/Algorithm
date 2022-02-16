package DFS_BFS;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main_백준_2178_미로탐색_136ms {

	static char[][] m;
	static int[] dl = {-1, 0, 1, 0};
	static int[] dr = {0, 1, 0, -1};
	
	public static void main(String[] args) throws Exception {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		
		//맵 입력받기
		m = new char[N + 2][M + 2];
		for (int i = 1; i <= N; i++) {
			String tmp = br.readLine();
			for (int j = 1; j <= M; j++) {
				m[i][j] = tmp.charAt(j - 1);
			}
		}
		
		int cnt = 1;
		//1,1부터 BFS실행 -> 좌표가 N, M이면 종료
		boolean[][] visit = new boolean[N + 2][M + 2];
		Queue<Integer> queue = new LinkedList<>();
		queue.add(1001);//위치 i,j -> 1000 * i + j -> int형으로 좌표를 표현가능
		visit[1][1] = true;
		while (!queue.isEmpty()) {
			//한 싸이클씩 체크
			for (int i = queue.size(); i > 0; i--) {
				//좌표 값 뽑기
				int tmp = queue.poll();
				int il = tmp / 1000;
				int ir = tmp % 1000;
				//좌표 도착하면 출력 후 종료
				if (il == N && ir == M) {
					System.out.println(cnt);
					return;
				}
				//4방 탐색 -> 방문 안했고, 값이 1이면 큐에 넣기
				for (int j = 0; j < 4; j++) {
					int l = il + dl[j];
					int r = ir + dr[j];
					if (m[l][r] == '1' && !visit[l][r]) {
						visit[l][r] = true;
						queue.add(1000 * l + r);
					}
				}
			}
			cnt++;
		}
	}
}//end class
/*
 * BFS
 * 사방 탐색 후 값이 1이면 한칸씩 이동
 * 좌표 도착하면 cnt출력 후 종료
 * 
 * */

