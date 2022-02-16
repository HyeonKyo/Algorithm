package BruteForce;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main_백준_2231_분해합 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());

		int digit = (int)Math.log10(N) + 1;
		int tmp1 = 0;
		int M = 0;
		for (M = N - digit * 9; M < N; M++) {
			tmp1 = M;
			int tmp2 = M;
			for (int i = 0; i < digit; i++) {
				tmp1 += tmp2 % 10;
				tmp2 /= 10;
			}
			if (tmp1 == N)
				break ;
		}
		if (tmp1 == N)
			System.out.println(M);
		else
			System.out.println(0);
	}
}
