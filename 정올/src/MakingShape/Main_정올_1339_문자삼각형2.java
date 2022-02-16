package MakingShape;

import java.util.Scanner;

public class Main_정올_1339_문자삼각형2 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		StringBuilder sb = new StringBuilder();
		
		int n = sc.nextInt();
		if (n > 100 || n < 1 || n % 2 == 0) {
			System.out.println("INPUT ERROR");
			return ;
		}
		
		int half = n / 2;
		for (int i = 0; i < n; i++) {
			char c = (char)('A' + (half * half + i) % 26);
			sb.append(c);
			sb.append(' ');
			int len = half - Math.abs(half - i);
			for (int j = 1; j <= len; j++) {
				c -= (n - (2 * j - 1)) % 26;
				if (c < 'A')
					c = (char)('Z' - ('A' - c - 1));
				sb.append(c);
				sb.append(' ');
			}
			sb.append('\n');
		}
		System.out.println(sb);
	}
}