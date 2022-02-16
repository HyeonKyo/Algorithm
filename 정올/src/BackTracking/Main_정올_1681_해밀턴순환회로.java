package BackTracking;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main_정올_1681_해밀턴순환회로 {
	
	static int N = 0;
	static int[][] map;
	static boolean[] ck;
	static int min;

	public static void main(String[] args) throws Exception {
		//1. 입력 받기
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		map = new int[N][N];
		ck = new boolean[N];
		ck[0] = true;
		for (int i = 0; i < N; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			for (int j = 0; j < N; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		min = Integer.MAX_VALUE;
		//2. 경로 구하기
		search(0, 1, 0);
		System.out.println(min);
	}
	
	static void search(int start, int cnt, int cost) {
		if (cnt >= N) {
			if (map[start][0] == 0)
				return;
			cost += map[start][0];
			if (min > cost)
				min = cost;
			return ;
		}
		for (int i = 1; i < N; i++) {
			if (!ck[i] && map[start][i] != 0) {
				ck[i] = true;
				search(i, cnt + 1, cost + map[start][i]);
				ck[i] = false;
			}
		}
	}
}
/*
5
0 14 4 10 20
14 0 7 8 7
4 5 0 7 16
11 7 9 0 2
18 7 17 4 0
 * */
