package DynamicProgramming;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main_백준_2579_계단오르기 {
	static int[] score;
	static int[] dp;
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		
		score = new int[n + 1];
		dp = new int[n + 1];
		int i = 0;
		for (i = 1; i <= n; i++) {
			score[i] = Integer.parseInt(br.readLine());
		}
		dp[1] = score[1];
		if (n >= 2)
			dp[2] = score[1] + score[2];
		
		for (i = 3; i <= n; i++) {
			dp[i] = Math.max(dp[i - 2], dp[i - 3] + score[i - 1]) + score[i];
		}
		System.out.println(dp[n]);
	}
}
