package MakingShape;

import java.util.Scanner;

public class Main_정올_1307_문자사각형1 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		StringBuilder sb = new StringBuilder();
		
		int n = sc.nextInt();
		
		for (int i = 1; i <= n; i++) {
			char c = (char)('A' + ((n * n - i) % 26));
			for (int j = 0; j < n; j++) {
				sb.append(c);
				sb.append(' ');
				c -= n % 26;
				if (c < 'A')
					c = (char)('Z' - ('A' - c - 1));
			}
			sb.append('\n');
		}
		System.out.println(sb);
	}
}
