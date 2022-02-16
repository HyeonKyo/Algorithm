package DFS_BFS;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main_백준_7562_나이트의이동_452ms {

	static int[][] d = {{2, 1}, {-2, 1}, {1, 2}, {-1, 2}};
	static final int L = 0;
	static final int R = 1;
	
	public static void main(String[] args) throws Exception {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		int[] start = new int[2];
		int[] dest = new int[2];
		int TC = Integer.parseInt(br.readLine());
		
		for (int test = 0; test < TC; test++) {
			//1. 입력 받기
			int	mapSize = Integer.parseInt(br.readLine());
			boolean[][] isVisit = new boolean[mapSize][mapSize];
			
			StringTokenizer st = new StringTokenizer(br.readLine());
			start[L] = Integer.parseInt(st.nextToken());//시작 좌표
			start[R] = Integer.parseInt(st.nextToken());
			
			st = new StringTokenizer(br.readLine());
			dest[L] = Integer.parseInt(st.nextToken());//목적지 좌표
			dest[R] = Integer.parseInt(st.nextToken());
			
			//2. BFS로 탐색
			Queue<int[]> q = new LinkedList<>();
			q.add(start);
			isVisit[start[L]][start[R]] = true;
			int cnt = 0;//이동 횟수
		end: while (!q.isEmpty()) {
				int size = q.size();
				for (int i = 0; i < size; i++) {//탐색 싸이클
					int[] cur = q.poll();
					
					if (cur[L] == dest[L] && cur[R] == dest[R])
						break end;//도착하면 BFS종료
					
					for (int j = 0; j < 4; j++) {
						//나이트 8방 이동 좌표 큐에 저장하기
						int l = cur[L] + d[j][L];
						int r = cur[R] + d[j][R];
						if (l >= 0 && l < mapSize && r >= 0 && r < mapSize
							&& !isVisit[l][r]) {
							q.offer(new int[] {l, r});
							isVisit[l][r] = true;
						}
						
						l = cur[L] - d[j][L];
						r = cur[R] - d[j][R];
						if (l >= 0 && l < mapSize && r >= 0 && r < mapSize
							&& !isVisit[l][r]) {
							q.offer(new int[] {l, r});
							isVisit[l][r] = true;
						}
					}
				}
				cnt++;
			}
			sb.append(cnt).append("\n");
		}
		System.out.print(sb.toString());
	}//end main
}//end class

/*
 * 나이트 이동 좌표
 * (1 -2) (-1 -2) (2 -1) (-2 -1) 
 * 
 * */
