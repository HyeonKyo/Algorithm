package Greedy;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main_백준_11047_동전0 {
		
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String[] tmp = br.readLine().split(" ");
		int N = Integer.parseInt(tmp[0]);
		int K = Integer.parseInt(tmp[1]);
		int[] coin = new int[N];
		for (int i = 0; i < N; i++) {
			coin[i] = Integer.parseInt(br.readLine());
		}
		int i = N - 1;
		int cnt = 0;
		while (K > 0) {
			while (K >= coin[i]) {
				K -= coin[i];
				cnt++;
			}
			i--;
		}
		System.out.println(cnt);
	}//end main
}
