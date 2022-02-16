package Simulation;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main_백준_2563_색종이_120ms {
	
	public static void main(String[] args) throws Exception {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		
		boolean[][] ck = new boolean[101][101];
		for (int i = 0; i < N; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			int x = Integer.parseInt(st.nextToken());
			int y = Integer.parseInt(st.nextToken());
			for (int j = 0; j < 10; j++) {
				int il = y + j;
				for (int k = 0; k < 10; k++) {
					if (!ck[il][x + k])
						ck[il][x + k] = true;
				}
			}
		}
		
		int area = 0;
		for (int i = 1; i <= 100; i++) {
			for (int j = 1; j <= 100; j++) {
				if (ck[i][j])
					area++;
			}
		}
		System.out.println(area);
	}//end main
}
