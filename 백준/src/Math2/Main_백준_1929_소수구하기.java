package Math2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main_백준_1929_소수구하기 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int M = Integer.parseInt(st.nextToken());
		int N = Integer.parseInt(st.nextToken());
		
		byte[] prime = new byte[1000001];
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
		for (i = M; i <= N; i++) {
			if (prime[i] == 1) {
				System.out.println(i);
			}
		}
	}
}
