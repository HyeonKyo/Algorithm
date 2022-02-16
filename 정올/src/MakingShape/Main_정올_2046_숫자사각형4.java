package MakingShape;

import java.util.Scanner;

public class Main_정올_2046_숫자사각형4 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		StringBuilder sb = new StringBuilder();
		
		int n = sc.nextInt();
		int m = sc.nextInt();
		
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < n; j++) {
				switch (m) {
				case 1:
					sb.append(i + 1);
					break;
				case 2:
					if (i % 2 == 0)
						sb.append(j + 1);
					else
						sb.append(n - j);
					break;
				case 3:
					sb.append((i + 1) * (j + 1));
					break;
				}
				sb.append(' ');
			}
			sb.append('\n');
		}
		System.out.println(sb);
	}
}
