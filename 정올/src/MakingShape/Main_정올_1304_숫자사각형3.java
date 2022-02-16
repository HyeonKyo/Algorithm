package MakingShape;

import java.util.Scanner;

public class Main_정올_1304_숫자사각형3 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		StringBuilder sb = new StringBuilder();
		
		for (int i = 0; i < n; i++) {
			int num = i + 1;
			for (int j = 0; j < n; j++) {
				sb.append(num);
				sb.append(' ');
				num += n;
			}
			sb.append('\n');
		}
		System.out.println(sb);
	}
}