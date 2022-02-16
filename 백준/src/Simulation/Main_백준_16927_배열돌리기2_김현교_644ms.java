package Simulation;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main_백준_16927_배열돌리기2_김현교_644ms {
	
	static int[] dl = {0, 1, 0, -1};//우하좌상
	static int[] dr = {1, 0, -1, 0};//우하좌상
	
	public static void main(String[] args) throws Exception {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		int R = Integer.parseInt(st.nextToken());
		
		int[][] m = new int[N][M];
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < M; j++) {
				m[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		
		int level = Math.min(N, M) / 2;
		for (int i = 0; i < level; i++) {
			int moveY = N - 2 * i - 1;
			int moveX = M - 2 * i - 1;
			int cycle = 2 * (moveY + moveX);
			int cnt = R % cycle;
			int il = i;
			int ir = i;
			
			for (int c = 0; c < cnt; c++) {
				int di = 0;
				int tmp = m[il][ir];
				for (int j = 0; j < 2; j++) {
					for (int k = 0; k < moveX; k++) {
						m[il][ir] = m[il + dl[di]][ir + dr[di]];
						il += dl[di];
						ir += dr[di];
					}
					di++;
					for (int k = 0; k < moveY; k++) {
						m[il][ir] = m[il + dl[di]][ir + dr[di]];
						il += dl[di];
						ir += dr[di];
					}
					di++;
				}
				m[il + 1][ir] = tmp;
			}
		}
		
		//출력하기
		StringBuilder sb = new StringBuilder();
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < M; j++) {
				sb.append(m[i][j]).append(" ");
			}
			sb.append("\n");
		}
		System.out.print(sb.toString());
	}//end main
}//end class