package MakingShape;

import java.util.Scanner;

public class Main_정올_1338_문자삼각형1 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		StringBuilder sb = new StringBuilder();
		
		int n = sc.nextInt();
		
		char c = 'A';
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < n - (i + 1); j++) {
				sb.append("  ");
			}
			c = (char)('A' + i % 26);
			for (int j = 0; j < i + 1; j++) {
				sb.append(c);
				sb.append(' ');
				c += (n - j - 1) % 26;
				if (c > 'Z')
					c = (char)('A' + (c - 'Z' - 1));
			}
			sb.append('\n');
		}
		System.out.println(sb);
	}
}