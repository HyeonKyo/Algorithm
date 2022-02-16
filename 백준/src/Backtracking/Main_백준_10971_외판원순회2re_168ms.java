package Backtracking;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main_백준_10971_외판원순회2re_168ms {
	
	static int N, end, min = 10000001;
	static int[][] m;
	
	public static void main(String[] args) throws Exception {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		m = new int[N][N];
		for (int i = 0; i < N; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			for (int j = 0; j < N; j++) {
				m[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		end = (1 << N) - 1;

		dfs(0, 0, 0);
		
		System.out.println(min);
	}//end main

	static void dfs(int cur, int bit, int sum) {
		
		bit |= 1 << cur;//현재 방문위치 체크
		
		if (bit == end) {
			if (m[cur][0] > 0) {
				sum += m[cur][0];
				if (min > sum)
					min = sum;
			}
		}
		
		for (int i = 1; i < N; i++) {
			if (m[cur][i] == 0 || (bit & 1 << i) != 0)
				continue;
			dfs(i, bit, sum + m[cur][i]);
		}
	}
}//end class