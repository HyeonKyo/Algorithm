package Simulation;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main_백준_14500_테트로미노 {
	
	static int N;
	static int M;
	static int[][] map;
	static int[][] d;
	static int max;
	static final int LEFT = 0;
	static final int RIGHT = 1;
	
	public static void main(String[] args) throws Exception {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		map = new int[N + 2][M + 2];
		
		d = new int[4][2];
		d[0][LEFT] = -1; //상
		d[1][RIGHT] = 1; //우
		d[2][LEFT] = 1;  //하
		d[3][RIGHT] = -1;//좌
		
		for (int i = 1; i <= N; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 1; j <= M; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		for (int i = 1; i <= N; i++) {
			for (int j = 1; j <= M; j++) {
				search(i, j, 1, 0, 0);
			}
		}
		System.out.println(max);
	}//end main
	
	static void search(int l, int r, int pre, int len, int sum) {
		if (len >= 4) {
			if (max < sum)
				max = sum;
			return;
		}
		if (l <= 0 || l > N || r <= 0 || r > M)
			return;
		
		if (len == 1) {
			//ㅗ모양
			int sumCopy = sum;
			sumCopy += map[l][r];
			sumCopy += map[l + d[pre][LEFT]][r + d[pre][RIGHT]];
			int idx1 = pre == 0 ? 3 : pre - 1;
			int idx2 = pre == 3 ? 0 : pre + 1;
			int tmp1 = map[l + d[idx1][LEFT]][r + d[idx1][RIGHT]];
			int tmp2 = map[l + d[idx2][LEFT]][r + d[idx2][RIGHT]];
			sumCopy = Math.max(tmp1, tmp2) + sumCopy;
			if (sumCopy > max)
				max = sumCopy;
		}
		for (int i = 0; i < 4; i++) {
			if (i == (pre + 2) % 4)
				continue;
			search(l + d[i][LEFT], r + d[i][RIGHT], i, len + 1, sum + map[l][r]);
		}
	}
}
/*
 * 1. 좌표 하나씩 탐색
 * 2. 각 좌표마다 탐색 시작
 * 3. 4방향으로 나아가며 숫자 더하고, 길이 count
 * 4. 길이가 4이면 그 합과 max비교
 * 5. 3번에서 4방향으로 나아갈 때, d[][]배열 사용하고, 그 방향 인덱스를 파라미터로 넘김
 * 6. 이전 방향은 제외하고 탐색
 * 7. 길이가 2면 ㅗ모양 탐색 시작 -> 이전 방향 + 2방향과 나머지 2방향을 1개씩 더한 것
 * 8. 파라미터는 x,y좌표 인덱스, 이전 방향 인덱스, 길이
 * 
 * */
