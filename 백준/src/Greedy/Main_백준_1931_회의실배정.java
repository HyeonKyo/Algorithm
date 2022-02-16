package Greedy;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Comparator;

public class Main_백준_1931_회의실배정 {

	static final int START = 0;
	static final int END = 1;

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		int[][] time = new int[N][2];
		for (int i = 0; i < N; i++) {
			String[] tmp = br.readLine().split(" ");
			time[i][START] = Integer.parseInt(tmp[0]);
			time[i][END] = Integer.parseInt(tmp[1]);
		}
		
		Arrays.sort(time, new Comparator<int[]>() {
			public int compare(int[] o1, int[] o2) {
				if(o1[END] == o2[END])
					return o1[START] - o2[START];
				return o1[END] - o2[END];
			}
		});
		
		int cnt = 0;
		int preEndTime = 0;
		for (int i = 0; i < N; i++) {
			if (time[i][START] >= preEndTime) {
				cnt++;
				preEndTime = time[i][END];
			}
		}
		System.out.println(cnt);
	}
}
