package Graph;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main_백준_16236_아기상어_88ms {

	static int[] dl = {-1, 0, 0, 1};//상 좌 우 하
	static int[] dr = {0, -1, 1, 0};
	
	public static void main(String[] args) throws Exception {
		//1.입력 받기
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		
		PriorityQueue<C> q = new PriorityQueue<>();
		int[] cnt = new int[N + 1];
		C start = null;
		int[][] map = new int[N][N];
		for (int i = 0; i < N; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			for (int j = 0; j < N; j++) {
				int num = Integer.parseInt(st.nextToken());
				if (num == 0)
					continue;
				if (num == 9)
					start = new C(i, j, 0);
				else {
					cnt[num]++;
					q.offer(new C(i, j, num));
					map[i][j] = 100;
				}
			}
		}
		
		int eatCnt = 0;
		int sum = 0;
		for (int i = 1; i < 7; i++) {
			eatCnt += cnt[i];
			sum += cnt[i];
			sum -= i + 1;
			if (sum < 0)
				break;
		}
//		System.out.println("eatCnt : " + eatCnt);
		int time = 0;
		int size = 2;
		int eat = 0;
		
		boolean[][] v = new boolean[N][N];
		Queue<C> bq = new LinkedList<>();
		while (eatCnt > 0) {
			//상어보다 작거나 같은 위치의 먹이 열어줌
			try {
				while (q.peek().size <= size) {
					C tmp = q.poll();
					map[tmp.l][tmp.r] = tmp.size;
				}
			} catch (Exception e) {
			}
			//BFS시작
			for (boolean[] a : v)
				Arrays.fill(a, false);
			bq.clear();
			bq.offer(start);
			v[start.l][start.r] = true;
			
			boolean flag = false;
			int tl = Integer.MAX_VALUE;
			int tr = Integer.MAX_VALUE;
			while (!bq.isEmpty()) {
				int len = bq.size();
				for (int i = 0; i < len; i++) {
					C cur = bq.poll();
					v[cur.l][cur.r] = true;
					
					if (cur.size > 0 && cur.size < size) {//먹이를 먹을 위치 -> 시작값 변경, eat카운팅
						//여기 도달하면 flag세우고 여기 위치에 도달한 값들 싹다 비교해서 다음 start정하기
						flag = true;
						if (cur.l < tl) {//위에 있을 수록
							tl = cur.l;
							tr = cur.r;
						} else if (cur.l == tl) {//좌측에 있을수록
							if (cur.r < tr) {
								tr = cur.r;
								tl = cur.l;
							}
						}
					}
					
					for (int j = 0; j < 4; j++) {
						int il = cur.l + dl[j];
						int ir = cur.r + dr[j];
						if (il < 0 || il >= N || ir < 0 || ir >= N || v[il][ir]
							|| map[il][ir] > size)
							continue;
						bq.offer(new C(il, ir, map[il][ir]));
					}
				}
				if (flag) {
					start.l = tl;
					start.r = tr;
//					System.out.println("time : " + time);
//					System.out.println("tl tr : " + tl + " " + tr);
					map[tl][tr] = 0;
					eat++;
					eatCnt--;
					break;
				}
				time++;
			}
			if (eat >= size) {
				size++;
				eat = 0;
			}
		}
		System.out.println(time);
		
	}//end main
	
	static class C implements Comparable<C>{
		int l, r, size;

		public C(int l, int r, int size) {
			super();
			this.l = l;
			this.r = r;
			this.size = size;
		}
		
		@Override
		public int compareTo(C o) {
			return size - o.size;
		}
	}
}//end class
/*
 * 
 * 
 * 입력을 왼쪽 위부터 받음
 * 큐 만듬
 * 
 * 입력이 1 ~ 6이면 큐1~6에 그 위치값 + 크기 넣어줌, 그 위치값 닫기
 * 통합큐에 큐1만 넣기
 * 
 * 큐1,2에 든 맵 열어주기
 * 
 * 시작점에서 통합큐에 있는거 다 빼서 거리 재주고 가장 작은 거 제외하고 다시 통합큐에 넣기
 * 가장 작은거를 먹고 시작점으로, eat카운팅
 * 
 * 1~6의 개수 카운팅
 * 1~6을 하나의 큐에 넣어줌
 * size보다 작은건 peek으로 체크
 * 큐에서 peek으로 확인, size보다 작으면 열어줌
 * BFS탐색(상 좌 부터)
 * 
 * 입력이 9이면 그 위치값 시작으로 저장
 * 
 * size = 2로 시작
 * 
 * size보다 작거나 같은 큐의 위치 값 오픈, 거기에 값으로 크기 넣어줌
 * 시작점에서 BFS로 열린 지점이고, 값이 size보다 작은 위치로 이동
 * eat cnt == size이면 size + 1 => 하나 더 열어줌
 * 
 * */
