package DynamicProgramming;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main_백준_9461_파도반수열{

	static long[] p = new long[101];
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());
		p[1] = 1;
		p[2] = 1;
		p[3] = 1;
		p[4] = 2;
		p[5] = 2;
		while (T-- > 0) {
			int N = Integer.parseInt(br.readLine());
			if (p[N] == 0) {
				for (int i = 6; i <= N; i++) {
					p[i] = p[i - 1] + p[i - 5];
				}
			}
			System.out.println(p[N]);
		}
	}
}
