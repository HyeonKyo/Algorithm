package Recursive;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Main_백준_2447_별찍기10 {
	static char arr[][];
	
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		arr = new char[N][N];
		int i = 0;
		for ( ; i < N; i++)
			Arrays.fill(arr[i], ' ');
		star(0, 0, N);
		StringBuilder sb = new StringBuilder();
		for (i = 0; i < N; i++) {
			for (int j = 0; j < N; j++) {
				sb.append(arr[i][j]);				
			}
			sb.append('\n');
		}
		System.out.print(sb);
	}
	
	static void star(int x, int y, int N) {
		if (N <= 1) {
			arr[y][x] = '*';
			return ;
		}
		int i = 0;
		int j = 0;
		N /= 3;
		for (i = 0; i < 3; i++) {
			for (j = 0; j < 3; j++) {
				if (i == 1 && j == 1)
					continue;
				star(x + j * N, y + i * N, N);
			}
		}
	}
}
