package DynamicProgramming;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main_백준_1463_1로만들기 {

	static int[] dp;
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		
		dp = new int[N + 1];
		dp[1] = 0;
		if (N >= 2)
			dp[2] = 1;
		for (int i = 3; i <= N; i++) {
			if (i % 6 == 0) {
				dp[i] = Math.min(Math.min(dp[i / 2], dp[i / 3]), dp[i - 1]);
			} else if (i % 3 == 0) {
				dp[i] = Math.min(dp[i / 3], dp[i - 1]);
			} else if (i % 2 == 0) {
				dp[i] = Math.min(dp[i / 2], dp[i - 1]);
			} else {
				dp[i] = dp[i - 1];
			}
			dp[i]++;
		}
		System.out.println(dp[N]);
	}
}
