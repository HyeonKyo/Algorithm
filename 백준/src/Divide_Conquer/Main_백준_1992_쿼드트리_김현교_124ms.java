package Divide_Conquer;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main_백준_1992_쿼드트리_김현교_124ms {
	
	static int N;
	static char[][] m;
	static StringBuilder sb = new StringBuilder();
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		m = new char[N][N];
		for (int i = 0; i < N; i++) {
			m[i] = br.readLine().toCharArray();
		}
		find(0, 0, N);
		System.out.println(sb.toString());
	}//end main
	
	static void find(int l, int r, int len) {
		if (check(l, r, len)) {
			sb.append(m[l][r]);
			return;
		}
		sb.append("(");
		int half = len / 2;
		find(l, r, half);
		find(l, r + half, half);
		find(l + half, r, half);
		find(l + half, r + half , half);
		sb.append(")");
	}
	
	static boolean check(int l, int r, int len) {
		//l, r은 시작점 좌표(좌상단), len만큼의 사각형이 다 같은 숫자인지 확인
		char c = m[l][r];
		for (int i = 0; i < len; i++) {
			for (int j = 0; j < len; j++) {
				if (m[l + i][r + j] != c)
					return false;
			}
		}
		return true;
	}
}//end class
/*
 * sb만들기
 * sb append (
 * find(시작점 좌표, 길이 N)
 * 	전체가 0 or 1이 아니면
 * 	for (4번)
 * 		find (시작점좌표 1 2 3 4, N / 2)
 * 	전체가 0이면 0, 전체가 1이면 1
 * sb append )
 * 
 * */
