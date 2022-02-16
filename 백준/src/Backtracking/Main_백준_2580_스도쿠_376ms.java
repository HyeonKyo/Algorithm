package Backtracking;

import java.io.BufferedReader;	
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main_백준_2580_스도쿠_376ms {
	static int[][] map = new int[9][9];
	static StringBuilder sb = new StringBuilder();
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int i = 0;
		int j = 0;
		for (i = 0; i < 9; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			for (j = 0; j < 9; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		fill(0, 0);
	}
	
	static void fill(int x, int y) {
		int i = y;
		int j = x;
		while (true) {
			if (j >= 9) {
				j = 0;
				i++;
				if (i >= 9) {
					printMap();
					System.exit(0);//종료
				}
			}
			if (map[i][j] == 0)
				break ;
			j++;
		}
		for (int k = 1; k <= 9; k++) {
			if (possible(j, i, k)) {
				map[i][j] = k;
				fill(j + 1, i);
				map[i][j] = 0;
			}
		}
	}
	
	static boolean possible(int x, int y, int value) {
		int i = 0;
		int j = 0;
		
		for (; j < 9; j++) {
			if (map[y][j] == value)
				return false;
		}
		
		for (; i < 9; i++) {
			if (map[i][x] == value) {
				return false;
			}
		}
		
		int setX = (x / 3) * 3;
		int setY = (y / 3) * 3;
		for (i = 0; i < 3; i++) {
			for (j = 0; j < 3; j++) {
				if (map[setY + i][setX + j] == value)
					return false;
			}
		}
		return true;
	}
	
	static void printMap() {
		for (int i = 0; i < 9; i++) {
			for (int j = 0; j < 9; j++) {
				sb.append(map[i][j]).append(' ');
			}
			sb.deleteCharAt(sb.length() - 1);
			sb.append('\n');
		}
		System.out.print(sb);
	}
}
