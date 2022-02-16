package Recursive;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class Main_정올_2567_싸이클  {
	
	static int N;
	static int P;
	static List<Integer> list = new ArrayList<>();
	static boolean[] ck;
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		P = Integer.parseInt(st.nextToken());
		ck = new boolean[Math.max(N, P) + 1];
		recur(N);
	}//end main
	
	static void recur(int num) {
		if (num == 0) {
			System.out.println(1);
			return;
		}
		if (ck[num]) {
			//list에서 num값 가진 인덱스 구해서 그 인덱스 부터 끝까지 개수 셈
			//개수 출력
			int idx = list.indexOf(num);
			System.out.println(list.size() - idx);
			return;
		}
		list.add(num);
		ck[num] = true;
		int tmp = (num * N) % P;
		recur(tmp);
	}
}//end class