package Backtracking;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main_백준_14888_연산자끼워넣기 {

	public static int max = -2147483648;
	public static int min = 2147483647;
	public static int N;
	public static int[] number;
	public static int[] operator = new int[4];
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		number = new int[N];
		StringTokenizer st = new StringTokenizer(br.readLine());
		for (int i = 0; i < N; i++)
			number[i] = Integer.parseInt(st.nextToken());
		st = new StringTokenizer(br.readLine());
		for (int i = 0; i < 4; i++)
			operator[i] = Integer.parseInt(st.nextToken());
		
		dfs(number[0], 1);
		System.out.println(max);
		System.out.println(min);
	}//end main
	
	static void dfs(int num, int idx) {
		if (idx >= N) {
			max = Math.max(max, num);
			min = Math.min(min, num);
			return ;
		}
		
		for (int i = 0; i < 4; i++) {
			if (operator[i] > 0) {
				operator[i]--;
				switch (i) {
				case 0:
					dfs(num + number[idx], idx + 1);
					break;
				case 1:
					dfs(num - number[idx], idx + 1);
					break;
				case 2:
					dfs(num * number[idx], idx + 1);
					break;
				case 3:
					dfs(num / number[idx], idx + 1);
					break;
				}
				operator[i]++;
			}
		}
	}
}//end class
