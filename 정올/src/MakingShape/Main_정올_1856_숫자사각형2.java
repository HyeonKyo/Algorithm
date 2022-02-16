package MakingShape;

import java.util.Scanner;

public class Main_정올_1856_숫자사각형2 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int n = sc.nextInt();
		int m = sc.nextInt();
		
		for (int i = 0; i < n; i++) {
			int num = (i % 2 == 0) ? m * i + 1 : m * (i + 1);
			for (int j = 0; j < m; j++) {
				if (i % 2 == 0)
					System.out.printf("%d ", num++);
				else {
					System.out.printf("%d ", num--);
				}
			}
			System.out.println();
		}
	}
}
