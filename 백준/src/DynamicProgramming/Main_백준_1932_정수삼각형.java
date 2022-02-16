package DynamicProgramming;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main_백준_1932_정수삼각형 {

	static int[][] tri;
	static int[][] dp;
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		tri = new int[n][n];
		dp = new int[n][n];
		int i, j;
		for (i = 0; i < n; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			for (j = 0; j <= i; j++) {
				tri[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		dp[0][0] = tri[0][0];
		for (i = 1; i < n; i++) {
			for (j = 0; j <= i; j++) {
				switch (j) {
				case 0:
					dp[i][j] = dp[i - 1][j] + tri[i][j];
					break;
				default:
					dp[i][j] = Math.max(dp[i - 1][j - 1], dp[i - 1][j]) + tri[i][j];
				}
			}
		}
		int[] arr = new int[n];
		for (i = 0; i < n; i++) {
			arr[i] = dp[n - 1][i];
		}
		Arrays.sort(arr);
		System.out.println(arr[n - 1]);
	}
}
