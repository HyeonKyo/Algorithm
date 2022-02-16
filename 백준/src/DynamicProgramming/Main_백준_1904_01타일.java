package DynamicProgramming;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main_백준_1904_01타일 {

	static int[] dp;
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		dp = new int[N + 1];
		dp[1] = 1;
		if (N > 1)
			dp[2] = 2;
		
		for (int i = 3; i <= N; i++) {
			dp[i] = (dp[i - 1] + dp[i - 2]) % 15746;
		}
		System.out.println(dp[N]);
	}
}

/*
 * ������ ������ ���� �Ǻ���ġ ������ �����ϴ�.
 * �� �׷��� ��Ģ�� ����
 * N = 3�ΰ��
 * N - 1(=2)�� ��쿡 1Ÿ���� ���̴� ��� + N - 2(=1)�� ��쿡 00Ÿ���� ���̴� ����̴�.
 * N - 1�� ��� (00 11)�ڿ� 1�� ���̸� �� Ÿ���� ������ �ڰ� 1�� ������.
 * N - 2�� ��� (1)�ڿ� 00�� ���̸� �� Ÿ���� ������ �ڰ� 00���� ������.
 * ���� �ߺ��� �߻����� �ʴ´�.
 * N �� N - 1�� ��� + N - 2�� ��� -> �� �Ǻ���ġ ������ �ȴ�.
 * 
 */