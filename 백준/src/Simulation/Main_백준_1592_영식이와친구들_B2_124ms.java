package Simulation;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main_백준_1592_영식이와친구들_B2_124ms {
	
	static final int ISODD = 1;
	
	public static void main(String[] args) throws Exception {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		int L = Integer.parseInt(st.nextToken());
		
		int[] getCnt = new int[N];//공 받은 카운트 셈
		int idx = 1;
		int cnt = 0;
		
		while (true) {
			if (getCnt[idx] == M - 1)//이제 받으면 M이 되므로 종료
				break;
			//현재 인덱스 사람의 받은 카운트 늘려주고
			//다음 인덱스 구하기
			
			if ((++getCnt[idx] & ISODD) != 0) {//받은 카운트가 홀수라면 시계 방향
				idx += L;
				if (idx >= N)
					idx %= N;
			}
			else {
				idx -= L;
				if (idx < 0)
					idx += N;
			}
			cnt++;
		}
		System.out.println(cnt);
	}//end main
}