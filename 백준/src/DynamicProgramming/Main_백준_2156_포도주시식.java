package DynamicProgramming;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main_백준_2156_포도주시식 {
	static int[] dp;
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		
		int[] amount = new int[n + 1];
		int[] dp = new int[n + 1];
		for (int i = 1; i <= n; i++) {
			amount[i] = Integer.parseInt(br.readLine());
		}
		for (int i = 1; i < 3 && i <= n; i++) {
			dp[i] = dp[i - 1] + amount[i];
		}
		for (int i = 3; i <= n; i++) {
			dp[i] = Math.max(dp[i - 2], dp[i - 3] + amount[i - 1]) + amount[i];
			dp[i] = Math.max(dp[i], dp[i - 1]);
		}
		System.out.println(dp[n]);
	}
}
