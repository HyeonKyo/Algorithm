package Simulation;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main_백준_17406_배열돌리기4_김현교_332ms {

	static int N;
	static int M;
	static int K;
	static int[][] m;
	static int[][] cmd;
	static int[] dl = {1, 0, -1, 0};//하우상좌
	static int[] dr = {0, 1, 0, -1};
	static boolean[] visit;
	static int[] performed;
	static int min = Integer.MAX_VALUE;
	
	public static void main(String[] args) throws Exception {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		K = Integer.parseInt(st.nextToken());
		
		m = new int[N][M];
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < M; j++) {
				m[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		cmd = new int[K][3];
		for (int i = 0; i < K; i++) {
			st = new StringTokenizer(br.readLine());
			cmd[i][0] = Integer.parseInt(st.nextToken());
			cmd[i][1] = Integer.parseInt(st.nextToken());
			cmd[i][2] = Integer.parseInt(st.nextToken());
		}
		
		visit = new boolean[K];
		performed = new int[K];
		permutation(0);
		System.out.print(min);
	}//end main
	
	static void permutation(int depth) {
		if (depth >= K) { //depth만큼 회전한 것
			operate();
			return;
		}
		
		for (int i = 0; i < K; i++) {
			if (visit[i])
				continue;
			visit[i] = true;
			performed[depth] = i;
			permutation(depth + 1);
			visit[i] = false;
		}
	}
	
	static void operate() {
		/* 회전돌릴 배열 카피함.
		 * 1. performed의 0번부터 K -1까지 인덱스 뽑음
		 * 2. 그 인덱스 값과 카피 배열을 rotate에 넣어줘서 돌림
		 * 3. 카피 배열 스코어 뽑아서 최솟값과 비교
		 * */
		int[][] copy = new int[N][M];
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < M; j++) {
				copy[i][j] = m[i][j];
			}
		}
		
		for (int i = 0; i < K; i++) {
			rotate(copy, performed[i]);
		}
		
		for (int i = 0; i < N; i++) {
			int sum = 0;
			for (int j = 0; j < M; j++) {
				sum += copy[i][j];
			}
			if (sum < min)
				min = sum;
		}
	}
	
	static void rotate(int[][] m, int idx) {
		int l = cmd[idx][0] - cmd[idx][2] - 1;
		int r = cmd[idx][1] - cmd[idx][2] - 1;
		int ymax = 2 * cmd[idx][2] + 1;
		int xmax = 2 * cmd[idx][2] + 1;
		for (int i = 0; i < cmd[idx][2]; i++) {
			int il = l + i;
			int ir = r + i;
			int moveY = ymax - 2 * i - 1;
			int moveX = xmax - 2 * i - 1;
			int tmp = m[il][ir];
			int di = 0;
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
			m[il][ir + 1] = tmp;
		}
	}
}//end class
/*
 * 1. K만큼 2차원 배열 만들고 그 안에 회전 명령 숫자 3개씩 넣기
 * 2. 인덱스로 K만큼 순열로 만듬
 * 3. 들어온 인덱스 값 operate배열에 순열로 넣어줘서 K개 만큼 쌓이면
 * 4. 기존 맵 복사 후 거기에 회전 연산 차례대로 적용 -> 최솟값 찾기
 *  [재귀에서는 인덱스만 넣어주고 마지막에 그것을 참고하여 한 번에 처리하는 방식]
 * 	1. 시작점, 끝점으로 가로, 세로 길이 구하기
 * 	2. level구하고 그만큼 반복
 * 	3. 시작점은 시작점 + level
 * 	4. 시작점 tmp에 넣기
 * 	5. 2를 1에 3을 2에 ->쭉 반복
 * 	6. 가로, 세로만큼 2번씩 반복
 * 
 * */