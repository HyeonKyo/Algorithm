package Simulation;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

import javax.sound.midi.Synthesizer;

public class Main_백준_16926_배열돌리기1_김현교_644ms {
	
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
			int m1 = N - 2 * i - 1;
			int m2 = M - 2 * i - 1;
			int cycle = 2 * (m1 + m2);
			int cnt = R % cycle;
			int il = i;
			int ir = i;
			
			for (int c = 0; c < cnt; c++) {
				int di = 0;
				int tmp = m[il][ir];
				for (int j = 0; j < 2; j++) {
					for (int k = 0; k < m2; k++) {
						m[il][ir] = m[il + dl[di]][ir + dr[di]];
						il += dl[di];
						ir += dr[di];
					}
					di++;
					for (int k = 0; k < m1; k++) {
						m[il][ir] = m[il + dl[di]][ir + dr[di]];
						il += dl[di];
						ir += dr[di];
					}
					di++;
				}
				m[il + 1][ir] = tmp;
			}
		}
		
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
/* N -1 * 2 + M -1 * 2 만큼돌면 한바퀴 (안쪽 갈수록 N - 2, M - 2)
 * 1. 각 단계에서 R을 한바퀴로 나눈 나머지만큼 이동
 * 2. 마지막에 가운데에 찍어주기
 * 3. 우측 이동 시 R이 4라면 % M만큼 이동 R / M만큼 아래 이동
 * */