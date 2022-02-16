package MakingShape;

import java.util.Scanner;

public class Main_정올_1314_문자사각형2 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		StringBuilder sb = new StringBuilder();
		
		int n = sc.nextInt();
		
		char c = 'A';
		for (int i = 0; i < n; i++) {
			c = (char)('A' + i % 26);
			sb.append(c);
			sb.append(' ');
			for (int j = 1; j < n; j++) {
				if (j % 2 == 0)
					c += (2 * i + 1) % 26;
				else
					c += (2 * (n - i) - 1) % 26;
				if (c > 'Z')
					c = (char)('A' + (c - 'Z' - 1));
				sb.append(c);
				sb.append(' ');
			}
			sb.append('\n');
		}
		System.out.println(sb);
	}
}