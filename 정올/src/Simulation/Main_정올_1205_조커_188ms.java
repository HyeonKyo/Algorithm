package Simulation;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main_정올_1205_조커_188ms {

	static int n, cntMax, max;
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		n = Integer.parseInt(br.readLine());
		int[] card = new int[n];
		StringTokenizer st = new StringTokenizer(br.readLine());
		int joker = 0;
		for (int i = 0; i < n; i++) {
			card[i] = Integer.parseInt(st.nextToken());
			if (card[i] == 0)
				joker++;
		}
		Arrays.sort(card);
		
		find(joker, 1, card, joker);
		System.out.println(max);
	}//end main
	
	static void find(int cur, int cnt, int[] card, int joker) {
		if (cur >= n - 1) {
			int c = Math.max(cnt, cntMax) + joker;
			if (c > max)
				max = c;
			cntMax = 0;
			return;
		}
		
		if (card[cur] == card[cur + 1])
			find(cur + 1, cnt, card, joker);
		else if (card[cur] + 1 == card[cur + 1])
			find(cur + 1, cnt + 1, card, joker);
		else if (card[cur + 1] - card[cur] - 1 <= joker) {
			int tmp = card[cur + 1] - card[cur] - 1;
			find(cur + 1, cnt + tmp + 1, card, joker - tmp);
			if (cntMax < cnt)
				cntMax = cnt;
			find(cur + 1, 1, card, joker);
		} else {
			if (cntMax < cnt)
				cntMax = cnt;
			find(cur + 1, 1, card, joker);
		}
	}
}
//카드를 앞에서부터 봄
		//뒤의 카드가 현 카드보다 1크면
		//	그냥 카운트 + 1, 다음 인덱스
		//같으면 그냥 다음
		//뒤카드 - 현카드 - 1이 조커보다 작으면
		//	조커 쓰는 경우와 안쓰는 경우
		//	쓰는경우
		//		그 계산값만큼 카운트, 조커는 계산값만큼 뺌
		//	안쓰는 경우
		//		카운트 다시 1, 조커 냅둬
		//마지막까지 오면 종료 -> maxCnt비교
