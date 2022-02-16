package Simulation;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main_백준_16935_배열돌리기3_김현교_484ms {

	static int N;
	static int M;
	static int[][] m;
	static int[][] d = {{1 , 1}, {-1 , 1}, {-1 , -1}, {1 , -1}};//우상좌하
	static boolean flag;
	static int ymax;
	static int xmax;
	
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
		flag = false;
		ymax = flag ? M : N;
		xmax = flag ? N : M;
		while (R-- > 0) {
			switch (Integer.parseInt(st.nextToken())) {
			case 1:
				swapAll();
				break;
			case 2:
				reverseAll();
				break;
			case 3:
				rotate(1);
				flag = !flag;
				break;
			case 4:
				rotate(-1);
				flag = !flag;
				break;
			case 5:
				move1();
				break;
			case 6:
				move2();
				break;
			}
			ymax = flag ? M : N;
			xmax = flag ? N : M;
		}
		//출력하기
		StringBuilder sb = new StringBuilder();
		for (int i = 0; i < ymax; i++) {
			for (int j = 0; j < xmax; j++) {
				sb.append(m[i][j]).append(" ");
			}
			sb.append("\n");
		}
		System.out.print(sb.toString());
	}//end main
	
	static void swapAll() {
		for (int i = 0; i < ymax / 2; i++) {
			int[] tmp = m[i];
			m[i] = m[ymax - (i + 1)];
			m[ymax - (i + 1)] = tmp;
		}
	}
	
	static void reverseAll() {
		for (int i = 0; i < ymax; i++) {
			for (int j = 0; j < xmax / 2; j++) {
				int tmp = m[i][j];
				m[i][j] = m[i][xmax - (j + 1)];
				m[i][xmax - (j + 1)] = tmp;
			}
		}
	}
	
	static void rotate(int di) {
		if (di < 0)
			di = 4 + di;
		int[][] start = {{0, 0}, {ymax - 1, 0}, {N - 1, M - 1}, {0, xmax - 1}};
		int il = start[di][0];
		int ir = start[di][1];
		int[][] temp = new int[xmax][ymax];
		int i = 0;
		while (0 <= ir && ir < xmax) {
			il = start[di][0];
			int j = 0;
			while (0 <= il && il < ymax) {
				temp[i][j++] = m[il][ir];
				il += d[di][0];
			}
			ir += d[di][1];
			i++;
		}
		m = temp;
	}
	
	static void move1() {
		int[][] tmp = new int[ymax / 2][xmax / 2];
		//1번을 tmp에
		for (int i = 0; i < ymax / 2; i++) {
			for (int j = 0; j < xmax / 2; j++) {
				tmp[i][j] = m[i][j];
			}
		}
		//4번을 1번에
		for (int i = 0; i < ymax / 2; i++) {
			for (int j = 0; j < xmax / 2; j++) {
				m[i][j] = m[i + ymax / 2][j];
			}
		}
		//3번을 4번에
		for (int i = ymax / 2; i < ymax; i++) {
			for (int j = 0; j < xmax / 2; j++) {
				m[i][j] = m[i][j + xmax / 2];
			}
		}
		//2 -> 3
		for (int i = ymax / 2; i < ymax; i++) {
			for (int j = xmax / 2; j < xmax; j++) {
				m[i][j] = m[i - ymax / 2][j];
			}
		}
		//tmp를 2번에
		for (int i = 0; i < ymax / 2; i++) {
			for (int j = 0; j < xmax / 2; j++) {
				m[i][j + xmax / 2] = tmp[i][j];
			}
		}
	}
	
	static void move2() {
		int[][] tmp = new int[ymax / 2][xmax / 2];
		//1번을 tmp에
		for (int i = 0; i < ymax / 2; i++) {
			for (int j = 0; j < xmax / 2; j++) {
				tmp[i][j] = m[i][j];
			}
		}
		//2번을 1번에
		for (int i = 0; i < ymax / 2; i++) {
			for (int j = 0; j < xmax / 2; j++) {
				m[i][j] = m[i][j + xmax / 2];
			}
		}
		//3 -> 2
		for (int i = 0; i < ymax / 2; i++) {
			for (int j = xmax / 2; j < xmax; j++) {
				m[i][j] = m[i + ymax / 2][j];
			}
		}
		//4 -> 3
		for (int i = ymax / 2; i < ymax; i++) {
			for (int j = xmax / 2; j < xmax; j++) {
				m[i][j] = m[i][j - xmax / 2];
			}
		}
		//tmp를 4번에
		for (int i = 0; i < ymax / 2; i++) {
			for (int j = 0; j < xmax / 2; j++) {
				m[i + ymax / 2][j] = tmp[i][j];
			}
		}
	}
}//end class

/* 크게 만들면 편할듯
 * 1번연산 -> 배열의 i인덱스 swap
 * 2번연산 -> 각 배열의 i인덱스 reverse -> ArrayList로 변환 후 리버스 후 다시 배열로
 * 3,4번 -> 나올때마다 flag +1 or -1, 인덱스 시작점과 방향만 다시설정
 * flag = 0 -> i먼저
 * for i = 0 ~ N - 1
 * 		for j = 0 ~ M - 1
 * d[][0] = 1, d[][1] = 1
 * 
 * flag = 1 -> j먼저 -> flag % 2 == 0이면 i먼저
 * for j = 0 ~ M - 1
 * 	for i = N - 1 ~ 0
 * d[][0] = -1, d[][1] = 1
 * 
 * flag = 2
 * for i = N - 1 ~ 0
 * 	for j = M - 1 ~ 0
 * d[][0] = -1, d[][1] = -1
 * 
 * flag = 3
 * for j = M - 1 ~ 0
 * 	for i = 0 ~ N - 1
 * 		
 * 
 * 5,6번 -> 4개로 쪼갬 -> 5번은 시계, 6번은 반시계방향
 * 		-> 첫번째 존의 원소 -> 2번째 존으로 x or y만큼 일정하게 움직임
 * 		-> 1번째 -> 2번째 = M / 2만큼 우측으로
 * 		-> 2번째 -> 3번째 = N / 2만큼 아래로
 * 		-> 3번째 -> 4번째 = M / 2만큼 왼쪽으로
 * 		-> 4번째 -> 1번째 = N / 2만큼 위로
2 2 8
1 2
3 4
3 3 5 2 1 4 6 2
 * 
 * */	
