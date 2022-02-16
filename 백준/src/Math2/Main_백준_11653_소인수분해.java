package Math2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main_백준_11653_소인수분해 {

	static byte[] primeInfo(int N) {
		byte[] prime = new byte[N + 1];
		int i = 0;
		int j = 0;
		for (i = 2; i <= N; i++) {
			prime[i] = 1;
		}
		int tmp = (int)Math.sqrt(N);
		for (i = 2; i <= tmp; i++) {
			if (prime[i] == 1) {
				for (j = 2; i * j <= N; j++) {
					prime[i * j] = 0;
				}
			}
		}
		return prime;
	}
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		
		int N = Integer.parseInt(br.readLine());
		
		byte[] p = primeInfo(N);
		
		int tmp = (int)Math.sqrt(N);
		for (int i = 2; i <= tmp; i++) {
			if (p[i] == 0)
				continue;
			while (N % i == 0) {
				sb.append(i).append('\n');
				N /= i;
			}
			if (N == 1)
				break ;
		}
		if (N != 1)
			sb.append(N);
		System.out.println(sb);
	}
}
