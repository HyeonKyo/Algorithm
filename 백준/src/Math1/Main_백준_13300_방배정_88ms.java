package Math1;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main_백준_13300_방배정_88ms {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());
		int K = Integer.parseInt(st.nextToken());
		int[][] cnt = new int[7][2];
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			int S = Integer.parseInt(st.nextToken());
			int Y = Integer.parseInt(st.nextToken());
			cnt[Y][S]++;
		}
		
		int room = 0;
		for (int i = 1; i <= 6; i++) {
			if (cnt[i][0] != 0)
				room += ((cnt[i][0] - 1) / K) + 1;
			if (cnt[i][1] != 0)
				room += ((cnt[i][1] - 1) / K) + 1;
		}
		System.out.println(room);
	}//end main
}
