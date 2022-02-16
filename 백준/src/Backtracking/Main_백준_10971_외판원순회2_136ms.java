package Backtracking;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main_백준_10971_외판원순회2_136ms {
	
	static int N, end, min;
	static final int MAX = 10000001;
	static int[][] m;
	static int[][] dp;
	
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
		dp = new int[end + 1][N];

		int ret = TSP(0, 0);
		
		System.out.println(ret);
	}//end main

	static int TSP(int cur, int bit) {
		
		bit |= 1 << cur;//현재 방문위치 체크
		
		int ret = dp[bit][cur];//현재의 경우에 온 적 있으면 그 경우 리턴
		if (ret > 0)
			return ret;
		ret = MAX;
		
		if (bit == end) {
			if (m[cur][0] > 0)
				return m[cur][0];
			return ret;
		}
		
		for (int i = 0; i < N; i++) {
			if (m[cur][i] == 0 || (bit & 1 << i) != 0)
				continue;
			int tmp = m[cur][i] + TSP(i, bit);
			if (ret > tmp)
				ret = tmp;
		}
		dp[bit][cur] = ret;
		
		return ret;
	}
}//end class
/*
 * 이전 경로 다시 거치지 않고 원래 노드로 돌아옴 -> 시작 지점 상관없음
 * 
 * 
 * 
 * 
 * 
 * */
