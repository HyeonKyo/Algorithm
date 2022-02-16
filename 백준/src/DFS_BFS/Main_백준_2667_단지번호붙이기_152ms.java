package DFS_BFS;

import java.io.BufferedReader;	
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;

public class Main_백준_2667_단지번호붙이기_152ms {

	static int N;
	static char[][] map;
	static boolean[][] visit;
	static int building;
	static int[] dl = {-1, 0, 1, 0};
	static int[] dr = {0, 1, 0, -1};
	
	public static void main(String[] args) throws Exception {
		//1.입력 받기
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		N = Integer.parseInt(br.readLine());
		map = new char[N + 2][N + 2];//인덱스 체크 안하기 위해 크게 만듬
		visit = new boolean[N + 2][N + 2];
		for (int i = 1; i <= N; i++) {
			String line = br.readLine();
			for (int j = 1; j <= N; j++) {
				map[i][j] = line.charAt(j - 1);
			}
		}
		
		ArrayList<Integer> count = new ArrayList<>();
		int complex = 0;
		for (int i = 1; i <= N; i++) {
			for (int j = 1; j <= N; j++) {
				if (map[i][j] == '1' && !visit[i][j]) {
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
		visit[l][r] = true;//방문 체크
		
		if (map[l][r] != '1')//1이 아니면 재귀 종료
			return;
		
		building++;//1이면 건물 수 + 1
		//상하좌우로 이동
		for (int i = 0; i < 4; i++) {
			if (!visit[l + dl[i]][r + dr[i]])
				search(l + dl[i], r + dr[i]);
		}
	}
}//end class

/*
 * 1. 2중반복문으로 값이 1, 방문 안했으면
 * 	  => 단지수 + 1, 건물 수 = 0 초기화 후 search시작 
 * 2. 방문값 true 변경 후 값 확인
 * 3. 1이 아니면 재귀 종료(바깥 테두리)
 * 4. 1이면 건물 수 + 1 and 4방 탐색(visit확인)
 * 5. 건물수 배열에 저장
 * 6. 단지수, 건물 수 출력
 * */
