package BruteForce;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main_백준_2961_도영이가만든맛있는음식_120ms {
	
	static int N;
	static int[] ts;
	static int[] tb;
	static int min = Integer.MAX_VALUE;
	
	public static void main(String[] args) throws Exception {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		ts = new int[N];
		tb = new int[N];
		for (int i = 0; i < N; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			ts[i] = Integer.parseInt(st.nextToken());
			tb[i] = Integer.parseInt(st.nextToken());
		}
		search(0, 1, 0, 0);
		System.out.println(min);
	}//end main
	
	static void search(int depth, int sumS, int sumB, int cnt) {
		if (depth >= N) {
			if (cnt > 0) {
				int ret = Math.abs(sumS - sumB);
				if (ret < min)
					min = ret;
			}
			return;
		}
		
		search(depth + 1, sumS * ts[depth], sumB + tb[depth], cnt + 1);
		search(depth + 1, sumS, sumB, cnt);
	}
}//end class
/*
 * 부분집합 문제
 * 
 * */
