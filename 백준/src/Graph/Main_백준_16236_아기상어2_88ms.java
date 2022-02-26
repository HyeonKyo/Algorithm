package Graph;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.PriorityQueue;
import java.util.Queue;

public class Main_백준_16236_아기상어2_88ms {

	static int[] dl = {-1, 0, 0, 1};//상 좌 우 하
	static int[] dr = {0, -1, 1, 0};
	
	public static void main(String[] args) throws Exception {
		//1.입력 받기
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		int[][] map = new int[N][N];
		
		C start = null;
		int[] cnt = new int[7];
		for (int i = 0; i < N; i++) {
			String line = br.readLine();
			for (int j = 0; j < N; j++) {
				map[i][j] = line.charAt(j * 2) - '0';
				if (map[i][j] == 9) {
					start = new C(i, j, 2);
					map[i][j] = 0;
				} else if (map[i][j] > 0) {
					cnt[map[i][j]]++;
				}
			}
		}
		
		int eatCnt = 0;
		int sum = 0;
		for (int i = 1; i < 7; i++) {
			eatCnt += cnt[i];
			sum += cnt[i];
			sum -= i + 1;
			if (sum < 0)
				break;
		}
		
		boolean[][] v = new boolean[N][N];
		Queue<C> q = new LinkedList<>();
		PriorityQueue<C> pq = new PriorityQueue<>();
		int time = 0;
		int eat = 0;
		
		while (eatCnt > 0) {
			for (boolean[] t : v) {
				Arrays.fill(t, false);
			}
			pq.clear();
			q.clear();
			q.offer(start);
		
			boolean end = false;
			if (eat >= start.size) {
				eat = 0;
				start.size++;
			}
			while (!q.isEmpty()) {
				int len = q.size();
				for (int i = 0; i < len; i++) {
					C cur = q.poll();
					
					v[cur.l][cur.r] = true;
					if (cur.size > 0 && cur.size < start.size) {
						end = true;
						pq.offer(cur);
					}
					if (end)
						continue;
					for (int j = 0; j < 4; j++) {
						int il = cur.l + dl[j];
						int ir = cur.r + dr[j];
						if (il < 0 || il >= N || ir < 0 || ir >= N
								|| v[il][ir] || map[il][ir] > start.size)
							continue;
						q.offer(new C(il, ir, map[il][ir]));
					}
				}
				if (end) {
					eatCnt--;
					eat++;
					int tmp = start.size;
					start = pq.peek();
					start.size = tmp;
					map[start.l][start.r] = 0;
					break;
				}
				time++;
			}
		}
		System.out.println(time);
	}//end main
	
	static class C implements Comparable<C>{
		int l, r, size;

		public C(int l, int r, int size) {
			super();
			this.l = l;
			this.r = r;
			this.size = size;
		}
		
		@Override
		public int compareTo(C o) {
			if (l == o.l)
				return r - o.r;
			return l - o.l;
		}
	}
}//end class

