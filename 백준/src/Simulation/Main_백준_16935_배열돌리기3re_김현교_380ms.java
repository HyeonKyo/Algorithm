package Simulation;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main_백준_16935_배열돌리기3re_김현교_380ms {

	static int N;
	static int M;
	static int[][] m;
	
	public static void main(String[] args) throws Exception {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		int R = Integer.parseInt(st.nextToken());
		m = new int[N][M];
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < M; j++) {
				m[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		
		st = new StringTokenizer(br.readLine());
		while (R-- > 0) {
			switch (Integer.parseInt(st.nextToken())) {
			case 1:
				swapAll();
				break;
			case 2:
				reverseAll();
				break;
			case 3:
				lrotate();
				break;
			case 4:
				rrotate();
				break;
			case 5:
				move1();
				break;
			case 6:
				move2();
				break;
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
	
	static void swapAll() {
		for (int i = 0; i < N / 2; i++) {
			int[] tmp = m[i];
			m[i] = m[N - (i + 1)];
			m[N - (i + 1)] = tmp;
		}
	}
	
	static void reverseAll() {
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < M / 2; j++) {
				swap(i, j, i, M - (j + 1));
			}
		}
	}
	
	static void lrotate() {
		int[][] copy = new int[M][N];
		
		int start = N - 1;
		for (int i = 0; i < M; i++) {
			for (int j = 0; j < N; j++) {
				copy[i][j] = m[start - j][i];
			}
		}
		m = copy;
		int tmp = M;
		M = N;
		N = tmp;
	}
	
	static void rrotate() {
		int[][] copy = new int[M][N];
		int start = M - 1;
		for (int i = 0; i < M; i++) {
			for (int j = 0; j < N; j++) {
				copy[i][j] = m[j][start - i];
			}
		}
		m = copy;
		int tmp = M;
		M = N;
		N = tmp;
	}
	
	static void move1() {
		//시계 방향
		for (int i = 0; i < N / 2; i++) {
			for (int j = 0; j < M / 2; j++) {
				int tmp = m[i + N / 2][j];
				m[i + N / 2][j] = m[i + N / 2][j + M / 2];
				m[i + N / 2][j + M / 2] = m[i][j + M / 2];
				m[i][j + M / 2]= m[i][j];
				m[i][j] = tmp;
			}
		}
		
	}
	
	static void move2() {
		for (int i = 0; i < N / 2; i++) {
			for (int j = 0; j < M / 2; j++) {
				int tmp = m[i][j];
				m[i][j] = m[i][j + M / 2];
				m[i][j + M / 2] = m[i + N / 2][j + M / 2];
				m[i + N / 2][j + M / 2] = m[i + N / 2][j];
				m[i + N / 2][j] = tmp;
			}
		}
	}
	
	static void swap(int l1, int r1, int l2, int r2) {
		int tmp = m[l1][r1];
		m[l1][r1] = m[l2][r2];
		m[l2][r2] = tmp;
	}
}//end class
/*
 * 1번, 2번 -> swap
 * 3번, 4번 ->
 * 5번, 6번 -> 각 존의 위치가 시계 or 반시계
 * 
 * */
