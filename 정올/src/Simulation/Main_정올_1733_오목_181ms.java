package Simulation;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main_정올_1733_오목_181ms {

	static int[][] m;
	static int[] dl = {0, 1, -1, 1};//우, 하, 우상, 우하 
	static int[] dr = {1, 0, 1, 1};
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		m = new int[19][19];
		for (int i = 0; i < 19; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			for (int j = 0; j < 19; j++) {
				m[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		
		for (int i = 0; i < 19; i++) {
			for (int j = 0; j < 19; j++) {
				if (m[i][j] != 0) {
					check(i, j, m[i][j]);
				}
			}
		}
		System.out.println(0);
	}//end main
	
	static void check(int l, int r, int base) {
		for (int i = 0; i < 4; i++) {
			if (l - dl[i] >= 0 && l - dl[i] < 19 && r - dr[i] >= 0 
					&& m[l - dl[i]][r - dr[i]] == base)
				continue;
			int cnt = 0;
			int il = l;
			int ir = r;
			
			do {
				il += dl[i];
				ir += dr[i];
				cnt++;
			} while (il >= 0 && il < 19 && ir < 19 && m[il][ir] == base);
			if (cnt == 5) {
				System.out.println(base + "\n" + (l + 1) + " " + (r + 1));
				System.exit(0);
			}
		}
	}
}
