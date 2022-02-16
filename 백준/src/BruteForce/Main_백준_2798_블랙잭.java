package BruteForce;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main_백준_2798_블랙잭 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		int[] arr = new int[N];
		int i = 0;
		st = new StringTokenizer(br.readLine());
		for ( ; i < N; i++) {
			arr[i] = Integer.parseInt(st.nextToken());
		}
		int j = 0;
		int k = 0;
		int sum = 0;
		int tmp = 0;
		for (i = 0; i < N - 2; i++) {
			for (j = i + 1; j < N - 1; j++) {
				for (k = j + 1; k < N; k++) {
					tmp = arr[i] + arr[j] + arr[k];
					if (tmp <= M && tmp > sum) {
						if (tmp == M) {
							System.out.println(M);
							return ;
						}
						sum = tmp;
					}
				}
			}
		}
		System.out.println(sum);
	}//end of main
}//end of class
