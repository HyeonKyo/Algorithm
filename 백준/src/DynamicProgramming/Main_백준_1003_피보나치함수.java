package DynamicProgramming;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main_백준_1003_피보나치함수 {
	
	static int T;
	static int[][] dp = new int[41][2];
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		T = Integer.parseInt(br.readLine());
		dp[0][0] = 1;
		dp[2][0] = 1;
		dp[1][1] = 1;
		dp[2][1] = 1;
		while (T-- > 0) {
			int N = Integer.parseInt(br.readLine());
			f(N);
			System.out.println(dp[N][0] + " " + dp[N][1]);
		}
	}//end main
	
	static int[] f(int N) {
		if (N <= 1)
			return dp[N];
		if (dp[N][0] == 0 || dp[N][1] == 0) {
			dp[N][0] = f(N - 1)[0] + f(N - 2)[0];
			dp[N][1] = f(N - 1)[1] + f(N - 2)[1];
		}
		return dp[N];
	}
}//end class

