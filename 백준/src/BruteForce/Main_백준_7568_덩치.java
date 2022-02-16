package BruteForce;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main_백준_7568_덩치{
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		
		int i, j = 0;
		int[][] arr = new int[N][2];
		int[] cnt = new int[N];
		for (i = 0; i < N; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			arr[i][0] = Integer.parseInt(st.nextToken());
			arr[i][1] = Integer.parseInt(st.nextToken());
		}
		for (i = 0; i < N - 1; i++) {
			for (j = i + 1; j < N; j++) {
				if (arr[i][0] < arr[j][0] && arr[i][1] < arr[j][1]) {
					cnt[i]++;
				} else if (arr[i][0] > arr[j][0] && arr[i][1] > arr[j][1]) {
					cnt[j]++;
				}
			}
		}
		StringBuilder sb = new StringBuilder();
		for (i = 0; i < N; i++) {
			sb.append(cnt[i] + 1);
			if (i != N - 1)
				sb.append(' ');
		}
		System.out.println(sb);
	}
}
