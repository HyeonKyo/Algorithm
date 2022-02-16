package Recursive;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main_백준_11729_하노이탑이동순서 {
	static StringBuilder sb = new StringBuilder();
	static int cnt = 0;
	
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		
		hanoi(N, 1, 3);
		System.out.println(cnt);
		System.out.print(sb);
	}//end of main
	
	static void hanoi(int N, int from, int to) {
		if (N == 1) {
			cnt++;
			sb.append(from).append(' ').append(to).append('\n');
			return ;
		}
		int newFrom = 6 - from - to;
		hanoi(N - 1, from, newFrom);
		cnt++;
		sb.append(from).append(' ').append(to).append('\n');
		hanoi(N - 1, newFrom, to);
	}
}//end of class
