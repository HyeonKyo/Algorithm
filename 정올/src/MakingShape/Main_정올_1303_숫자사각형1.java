package MakingShape;

import java.util.Scanner;

public class Main_정올_1303_숫자사각형1 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int n = sc.nextInt();
		int m = sc.nextInt();
		
		int num = 1;
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < m; j++) {
				System.out.printf("%d ", num++);
			}
			System.out.println();
		}
	}
}
