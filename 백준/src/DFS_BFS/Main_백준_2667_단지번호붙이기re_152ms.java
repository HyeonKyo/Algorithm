package DFS_BFS;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;

public class Main_백준_2667_단지번호붙이기re_152ms {

	static int N;
	static boolean[][] map;
	static int building;
	static int[] dl = {-1, 0, 1, 0};
	static int[] dr = {0, 1, 0, -1};
	
	public static void main(String[] args) throws Exception {
		//1.입력 받기
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		N = Integer.parseInt(br.readLine());
		map = new boolean[N + 2][N + 2];//인덱스 체크 안하기 위해 크게 만듬
		for (int i = 1; i <= N; i++) {
			String line = br.readLine();
			for (int j = 1; j <= N; j++) {
				if (line.charAt(j - 1) == '1')
					map[i][j] = true;
			}
		}
		
		ArrayList<Integer> count = new ArrayList<>();
		int complex = 0;
		for (int i = 1; i <= N; i++) {
			for (int j = 1; j <= N; j++) {
				if (map[i][j]) {
					complex++;
					building = 0;
					search(i, j);
					count.add(building);
				}
			}
		}
		
		Collections.sort(count);
		for (Integer n : count)
			sb.append(n).append("\n");
		System.out.print(complex + "\n" + sb.toString());
	}//end main
	
	static void search(int l, int r) {
		if (!map[l][r])//1이 아니면 재귀 종료
			return;
		
		map[l][r] = false;//방문 체크
		building++;//1이면 건물 수 + 1
		
		//상하좌우로 이동
		for (int i = 0; i < 4; i++) {
			search(l + dl[i], r + dr[i]);
		}
	}
}//end class