package Simulation;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Collections;
import java.util.StringTokenizer;

public class Main_백준_14696_딱지놀이_B1_428 {
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		int N = Integer.parseInt(br.readLine());
		Integer[] a = new Integer[101];
		Integer[] b = new Integer[101];
		for (int i = 0; i < N; i++) {
			Arrays.fill(a, 0);
			Arrays.fill(b, 0);
			StringTokenizer st = new StringTokenizer(br.readLine());
			int alen = Integer.parseInt(st.nextToken());
			for (int j = 0; j < alen; j++) {
				a[j] = Integer.parseInt(st.nextToken());
			}
			Arrays.sort(a, Collections.reverseOrder());
			st = new StringTokenizer(br.readLine());
			int blen = Integer.parseInt(st.nextToken());
			for (int j = 0; j < blen; j++) {
				b[j] = Integer.parseInt(st.nextToken());
			}
			Arrays.sort(b, Collections.reverseOrder());
			int len = Math.max(alen, blen);
			for (int j = 0; j < len; j++) {
				if (a[j] == b[j]) {
					if (j == len - 1)
						sb.append("D\n");
					continue;
				}
				if (a[j] > b[j]) {
					sb.append("A\n");
					break;
				} else {
					sb.append("B\n");
					break;
				}
			}
		}
		System.out.println(sb);
	}//end main
}//end class
