package DynamicProgramming;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main_백준_10844_쉬운계단수 {

	static int[][] dp;
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		
		dp = new int[N + 1][10];
		for(int i = 1; i <= 9; i++)
			dp[1][i] = 1;
		for(int i = 2; i <= N; i++) {
			for(int j = 0; j <= 9; j++) {
				if (j > 0)
					dp[i][j] = dp[i - 1][j - 1] % 1000000000;
				if (j < 9)
					dp[i][j] += dp[i - 1][j + 1] % 1000000000;
				dp[i][j] %= 1000000000;
			}
		}
		long sum = 0;
		for(int a : dp[N])
			sum += a;
		System.out.println(sum % 1000000000);
	}
}
