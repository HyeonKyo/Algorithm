package Greedy;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main_백준_3109_빵집_김현교_G2_412ms {
		
	static int R, C;
	static char[][] m;
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		
		R = Integer.parseInt(st.nextToken());
		C = Integer.parseInt(st.nextToken());
		m = new char[R + 2][];//좌우 테두리는 만들 필요 없음.
		m[0] = new char[C];
		m[R + 1] = new char[C];
		for (int i = 1; i <= R; i++) {
			m[i] = br.readLine().toCharArray();
		}
		
		int cnt = 0;
		for (int i = 1; i <= R; i++) {
			if (dfs(i, 0))
				cnt++;
		}
		
		System.out.println(cnt);
	}//end main
	
	static boolean dfs(int cur, int depth) {
		
		if (m[cur][depth] != '.')
			return false;
		
		m[cur][depth] = 'X';
		
		if (depth >= C - 1) {
			return true;
		}
		
		for (int i = 0; i < 3; i++) {
			if (dfs(cur + (i - 1), depth + 1))
				return true;
		}
		return false;
	}
}
