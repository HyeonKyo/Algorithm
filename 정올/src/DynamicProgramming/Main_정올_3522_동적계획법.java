package DynamicProgramming;

import java.util.Scanner;

public class Main_정올_3522_동적계획법 {

	public static void main(String[] args) {
		Scanner s = new Scanner(System.in);
		
		int N = s.nextInt();
		long[] f = new long[100001];
		
		int i = 0;
		for ( ; i < 100001; i++)
			f[i] = 0L;
		f[0] = 0L;
		f[1] = 1L;
		f[2] = 1L;
		for (i = 3; i <= N; i++) {
			f[i] = (f[i - 1] + f[i - 2]) % 1000000007;
		}
		System.out.println(f[N]);
	}
}
