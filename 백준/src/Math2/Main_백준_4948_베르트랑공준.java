package Math2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main_백준_4948_베르트랑공준 {
	public static void main(String[] args) throws IOException {
		byte[] prime = new byte[246913];
		int i = 0;
		int j = 0;
		for (i = 2; i <= 246912; i++) {
			prime[i] = 1;
		}
		for (i = 2; i <= 123456; i++) {
			if (prime[i] == 1) {
				for (j = 2; i * j <= 246912; j++) {
					prime[i * j] = 0;
				}
			}
		}
		
		int N = 0;
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		while (true) {
			N = Integer.parseInt(br.readLine());
			if (N == 0)
				return ;
			int cnt = 0;
			for (i = N + 1; i <= 2 * N; i++) {
				if (prime[i] == 1)
					cnt++;
			}
			System.out.println(cnt);
		}
	}
}
