package Backtracking;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main_백준_1987_알파벳2_김현교 {

	static int R;
	static int C;
	static char[][] m;
	static int[] dl = {-1, 0, 1, 0};
	static int[] dr = {0, 1, 0, -1};
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		R = Integer.parseInt(st.nextToken());
		C = Integer.parseInt(st.nextToken());
		m = new char[R][];
		for (int i = 0; i < R; i++) {
			m[i] = br.readLine().toCharArray();
		}
		
		//bfs로
		Queue<C> q = new LinkedList<>();
		q.add(new C(0, 0, 1 << m[0][0]));
		int cnt = 0;
		while (!q.isEmpty()) {
			int size = q.size();
			for (int i = 0; i < size; i++) {
				C cur = q.poll();
				for (int j = 0; j < 4; j++) {
					int il = cur.l + dl[j];
					int ir = cur.r + dr[j];
					if (il < 0 || il >= R || ir < 0 || ir >= C
						|| (cur.bit & 1 << m[il][ir]) != 0)
						continue;
					q.offer(new C(il, ir, cur.bit | 1 << m[il][ir]));
				}
			}
			cnt++;
		}
		System.out.println(cnt);
	}//end main
	
	static class C {
		int l, r, bit;

		public C(int l, int r, int bit) {
			super();
			this.l = l;
			this.r = r;
			this.bit = bit;
		}
	}
}//end class