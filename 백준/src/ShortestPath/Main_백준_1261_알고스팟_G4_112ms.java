package ShortestPath;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

/*
 * 이 문제를 다익스트라로 보는 방법??
 * 문제의 요구사항 : 최소한의 벽(1)을 뚫고 목표지점에 도달해야함.
 * => 현재 위치에서 다음 위치가 0(빈 방)이면 가중치가 0, 1(벽)이면 가중치를 1로 두면
 *    다익스트라처럼 풀 수 있다.
 * 
 * */
public class Main_백준_1261_알고스팟_G4_112ms {

	static int[] dl = {0, 1, 0, -1};
	static int[] dr = {1, 0, -1, 0};
	
	public static void main(String[] args) throws Exception {
		//1.입력 받기
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		int M = Integer.parseInt(st.nextToken());
		int N = Integer.parseInt(st.nextToken());
		char[][] m = new char[N][];
		for (int i = 0; i < N; i++) {
			m[i] = br.readLine().toCharArray();
		}
		
		int[][] dist = new int[N][M];
		for (int i = 0; i < N; i++) {
			Arrays.fill(dist[i], Integer.MAX_VALUE);
		}
		dist[0][0] = 0;
		PriorityQueue<Point> q = new PriorityQueue<>();
		q.offer(new Point(0, 0, 0));
		
		while (!q.isEmpty()) {
			Point cur = q.poll();
			
			for (int i = 0; i < 4; i++) {
				int il = cur.l + dl[i];
				int ir = cur.r + dr[i];
				if (il < 0 || il >= N || ir < 0 || ir >= M)
					continue;
				int nextDist = dist[cur.l][cur.r] + m[il][ir] - '0';
				if (dist[il][ir] > nextDist) {
					dist[il][ir] = nextDist;
					q.offer(new Point(il, ir, nextDist));
				}
			}
		}
		System.out.println(dist[N - 1][M - 1]);
	}//end main
	
	static class Point implements Comparable<Point>{
		int l, r, w;

		public Point(int l, int r, int w) {
			super();
			this.l = l;
			this.r = r;
			this.w = w;
		}
		
		@Override
		public int compareTo(Point o) {
			if (w == o.w) {
				if (l == o.l)
					return o.r - r;
				return o.l - l;
			}
			return w - o.w;
		}
	}
}//end class


