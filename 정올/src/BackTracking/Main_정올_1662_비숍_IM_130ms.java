package BackTracking;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main_정올_1662_비숍_IM_130ms {
	
	static int N, map[][], max;
	static int[] dl = {-1, -1, 1, 1};
	static int[] dr = {-1, 1, -1, 1};
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		map = new int[N][N];
		for (int i = 0; i < N; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			for (int j = 0; j < N; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		
		back(0, 0, 0);
		System.out.println(max);
	}//end main
	
	static void back(int l, int r, int cnt) {
		if (r >= N) {
			r %= N;
			l++;
			if (l >= N) {
				if (cnt > max)
					max = cnt;
				return;
			}
		}
		
		if (check(l, r)) {
			map[l][r] = 2;
			back(l, r + 1, cnt + 1);
			map[l][r] = 1;
		}
		back(l, r + 1, cnt);
	}
	
	static boolean check(int l, int r) {
		
		if (map[l][r] != 1)
			return false;
		int n = l >= r ? l : r;
		
		for (int i = 1; i <= n; i++) {
			for (int j = 0; j < 4; j++) {
				int il = l + dl[j] * i;
				int ir = r + dr[j] * i;
				if (il < 0 || il >= N || ir < 0 || ir >= N)
					continue;
				if (map[il][ir] == 2)
					return false;
			}
		}
		return true;
	}
}

/*
 * n, m에서 대각선 체크
 * n, m중 최대값 = max
 * 1부터 max까지 i
 * n - i, m - i / n - i + m + i / n + i + m - i...
 * 
 * */
