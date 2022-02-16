package Binarysearch;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main_백준_1920_수찾기 {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		int[] num = new int[n];
		StringTokenizer st = new StringTokenizer(br.readLine());
		int i = 0;
		for (; i < n; i++) {
			num[i] = Integer.valueOf(st.nextToken());
		}
		Arrays.sort(num);
		int m = Integer.parseInt(br.readLine());
		int[] find = new int[m];
		st = new StringTokenizer(br.readLine());
		for (i = 0; i < m; i++) {
			find[i] = Integer.valueOf(st.nextToken());
		}
		i = 0;
		while (i < m) {
			boolean flag = false;
			int ck = find[i++];
			int pl = 0;
			int pr = n - 1;
			while (pl <= pr) {
				int idx = (pl + pr) / 2;
				if (ck > num[idx])
					pl = idx + 1;
				else if (ck < num[idx])
					pr = idx - 1;
				else {
					flag = true;
					break;
				}
			}
			if (flag)
				System.out.println("1");
			else
				System.out.println("0");
		}
	}
}
