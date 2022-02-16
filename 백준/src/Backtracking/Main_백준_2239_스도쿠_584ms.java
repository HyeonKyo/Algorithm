package Backtracking;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main_백준_2239_스도쿠_584ms {
	
	static int[][] map = new int[9][9];
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String line = null;
		for (int i = 0; i < 9; i++) {
			line = br.readLine();
			for (int j = 0; j < 9; j++) {
				map[i][j] = line.charAt(j) - '0';
			}
		}
		
		fill(0, 0);
	}
	
	static void fill(int y, int x) {
		if (x >= 9) {
			x = 0;
			y++;
			if (y >= 9) {
				printMap();
				System.exit(0);
			}
		}
		
		if (map[y][x] > 0) {
			fill(y, x + 1);
			return;
		}
		
		for (int num = 1; num <= 9; num++) {
			if (isPossible(y, x, num)) {
				map[y][x] = num;
				fill(y, x + 1);
				map[y][x] = 0;
			}
		}
	}
	
	static boolean isPossible(int y, int x, int num) {
		//가로 위치에 num이 있으면 false
		for (int i = 0; i < 9; i++) {
			if (map[y][i] == num)
				return false;
		}
		//세로 위치에 num이 있으면 false
		for (int i = 0; i < 9; i++) {
			if (map[i][x] == num)
				return false;
		}
		
		//작은 네모 안에 num이 있으면 false
		int startY = 3 * (y / 3);
		int startX = 3 * (x / 3);
		for (int i = 0; i < 3; i++) {
			for (int j = 0; j < 3; j++) {
				if (map[startY + i][startX + j] == num)
					return false;
			}
		}
		return true;
	}
	
	static void printMap() {
		StringBuilder sb = new StringBuilder();
		for (int i = 0; i < 9; i++) {
			for (int j = 0; j < 9; j++) {
				sb.append(map[i][j]);
			}
			sb.append("\n");
		}
		System.out.print(sb.toString());
	}
}
/* 
 * 사전 식 -> 왼쪽 위부터 숫자가 작은 순서
 * 
 * 아이디어
 * 1. 왼쪽 위부터 차례대로 탐색
 * 2. 값이 0이 아니면 바로 다음으로 넘어감
 * 3. 0이면 반복문으로 1~9까지 유효성 체크 후 넣어주고 다음 위치로
 * 4. 가장 먼저 완성된 스도쿠는 차례대로 가장 작은 값을 넣어주며 만든 것이므로 사전순으로 가장 앞선 것
 * 5. 따라서 출력 후 종료
 * 
 * */
