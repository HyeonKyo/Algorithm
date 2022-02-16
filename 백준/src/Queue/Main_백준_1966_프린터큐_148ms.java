package Queue;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main_백준_1966_프린터큐_148ms {

	public static void main(String[] args) throws Exception {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		int T = Integer.parseInt(br.readLine());
		for (int test = 1; test <= T; test++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			int N = Integer.parseInt(st.nextToken());
			int M = Integer.parseInt(st.nextToken());
			
			//큐 생성, 우선순위 카운트 배열 생성
			Queue<Integer> que = new LinkedList<Integer>();
			int[] priorityCnt = new int[10];
			st = new StringTokenizer(br.readLine());
			for (int i = 0; i < N; i++) {
				int num = Integer.parseInt(st.nextToken());
				que.offer(num);
				priorityCnt[num]++;//우선순위 개수들 저장
			}
			
			int printCnt = 1;
			while (true) {
				//우선순위 max값 찾기
				int max = 0;
				for (int i = 9; i >= 1; i--) {
					if (priorityCnt[i] > 0) {
						max = i;
						break;
					}
				}
				//현재 출력의 우선순위 확인
				int num = que.poll();
				if (num != max) {//더 큰 우선순위가 있는 출력물이 있는 경우
					que.offer(num);
					M = (M == 0) ? que.size() - 1 : M - 1;
					continue;
				}
				if (M == 0) {//나의 목적 출력물이 최대 우선순위이고 현재 출력물인 경우 -> 반복 종료
					sb.append(printCnt).append("\n");
					break;
				}
				priorityCnt[max]--;
				printCnt++;
				M--;
			}
		}
		System.out.print(sb.toString());
	}//end main
}

/*
 * 1. 중요도 배열에 입력 받으면서 중요도 cnt배열++
 * 2. 목표 출력  = M
 * 3. 반복문 시작
 * 4. 중요도 max값을 cnt배열 뒤에서부터 탐색해서 찾음
 * 5. queue poll = num != max라면
 * 6. num을 queue offer and M--, -> M이 -1이라면 M은 다시 queue length - 1
 * 7. num == max라면
 * 8. M이 0이 아니면 printcnt++
 * 9. M이 0이면 printcnt출력
 * 
 * */
