package Backtracking;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main_백준_15649_N과M2 {
	static int N, M;
	static char[] arr;
	static boolean[] ck;
	static StringBuilder sb = new StringBuilder();
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		
		arr = new char[2 * M];
		ck = new boolean[N + 1];
		back(1, 0);
		System.out.print(sb);
	}
	
	static void back(int num, int idx) {
		if (idx >= M) {
			arr[2 * M - 1] = '\n';
			sb.append(arr);
			return ;
		}
		
		int i = 0;
		for (i = num; i <= N; i++) {
			if (!ck[i]) {
				ck[i] = true;
				arr[2 * idx] = (char)(i + '0');
				arr[2 * idx + 1] = ' ';
				back(i + 1, idx + 1);
				ck[i] = false;
			}
		}
	}
}
