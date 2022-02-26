package Simulation;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main_백준_14503_로봇청소기_G5_88ms {
	
	static char[][] m;
	
	static int[] dl = {-1, 0, 1, 0};
	static int[] dr = {0, 1, 0, -1};
	
	public static void main(String[] args) throws Exception {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		
		st = new StringTokenizer(br.readLine());
		int r = Integer.parseInt(st.nextToken()) + 1;
		int c = Integer.parseInt(st.nextToken()) + 1;
		int direct = Integer.parseInt(st.nextToken());
		
		m = new char[N + 2][M + 2];
		for (int i = 1; i <= N; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 1; j <= M; j++) {
				m[i][j] = st.nextToken().charAt(0);
			}
		}
		search(r, c, direct, 0);
	
	}//end main
	
	static void search(int l, int r, int di, int cnt) {
		if (m[l][r] == '0') {
			m[l][r] = '2';
			cnt++;
		}
		
		//현재 방향의 왼쪽
		for (int i = 0; i < 4; i++) {
			di -= 1;
			if (di < 0)
				di = 3;
			int nl = l + dl[di];
			int nr = r + dr[di];
			if (m[nl][nr] == '0') {
				search(nl, nr, di, cnt);
				return;
			}
		}
		//후진
		int tmp = (di + 2) % 4;
		l += dl[tmp];
		r += dr[tmp];
		if (m[l][r] == '0' || m[l][r] == '2') {
			search(l, r, di, cnt);
		} else {
			System.out.println(cnt);
		}
	}
}

/*
 * 맵 위치 char로 받음(테두리)
 * 현재위치부터 시작 => 현재 위치 1로 바꿈
 * 왼쪽부터 탐색 -> 방향 카운트해줘서 4면 후진가능 확인 -> 후진 안되면 종료
 * ->가능한 곳 있으면 가고 반복
 * 
 * */
