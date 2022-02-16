package Math2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main_백준_2581_소수 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int M = Integer.parseInt(br.readLine());
		int N = Integer.parseInt(br.readLine());

		byte[] prime = new byte[10001];
		int i = 0;
		int j = 0;
		for (i = 2; i <= N; i++) {
			prime[i] = 1;
		}
		for (i = 2; i <= N / 2; i++) {
			if (prime[i] == 1) {
				for (j = 2; i * j <= N; j++) {
					prime[i * j] = 0;
				}
			}
		}
		int min = -1;
		int sum = 0;
		for (i = M; i <= N; i++) {
			if (prime[i] == 1) {
				sum += i;
				if (min == -1)
					min = i;
			}
		}
		if (min > 0)
			System.out.println(sum);
		System.out.println(min);
	}
}
