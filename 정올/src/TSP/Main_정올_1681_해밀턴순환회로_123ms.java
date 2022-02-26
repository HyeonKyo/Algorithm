package TSP;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main_정올_1681_해밀턴순환회로_123ms {
	
	static int N, endBit;
	static int[][] map;
	static int[][] dp;
	static final int MAX = 10000;

	public static void main(String[] args) throws Exception {
		//1. 입력 받기
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		map = new int[N][N];
		for (int i = 0; i < N; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			for (int j = 0; j < N; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		endBit = (1 << N) - 1;
		dp = new int[endBit + 1][N];
		//2. 경로 구하기
		int min = TSP(0, 0);
		if (min > MAX)
			System.out.println(0);
		else
			System.out.println(min);
	}
	
	static int TSP(int start, int bit) {
		
		bit |= 1 << start;
		
		if (dp[bit][start] > 0)
			return dp[bit][start];
		
		if (bit == endBit) {
			if (map[start][0] > 0) {
				return map[start][0];
			}
			return MAX;
		}
		
		int ret = MAX;
		for (int i = 1; i < N; i++) {
			if ((bit & 1 << i) == 0 && map[start][i] != 0) {
				int tmp = map[start][i] + TSP(i, bit);
				if (tmp < ret)
					ret = tmp;
			}
		}
		dp[bit][start] = ret;
		return ret;
	}
}

