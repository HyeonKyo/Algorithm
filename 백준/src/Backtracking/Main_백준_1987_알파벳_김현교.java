package Backtracking;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main_백준_1987_알파벳_김현교 {

	static int R;
	static int C;
	static char[][] m;
	static int max;
	static int[] dp;
	
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
		search(0, 0, 0, 0);
		System.out.println(max);
	}//end main
	
	static void search(int l, int r, int ck, int cnt) {
		if ((ck & 1 << m[l][r]) != 0) {
			if (max < cnt)
				max = cnt;
			return;
		}
		
		ck = ck | 1 << m[l][r];
		for (int i = 0; i < 4; i++) {
			int il = l + dl[i];
			int ir = r + dr[i];
			if (il < 0 || il >= R || ir < 0 || ir >= C)
				continue;
			search(il, ir, ck, cnt + 1);
		}
	}
}//end class
