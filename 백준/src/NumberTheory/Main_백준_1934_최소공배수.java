package NumberTheory;

import java.util.Scanner;

public class Main_백준_1934_최소공배수 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int T = sc.nextInt();
		while (T-- > 0) {
			int a = sc.nextInt();
			int b = sc.nextInt();
			if (a < b) {
				int tmp = a;
				a = b;
				b = tmp;
			}
			System.out.println(a * b / gcd(a, b));
		}
	}
	
	static int gcd(int a, int b) {
		while (b != 0) {
			int r = a % b;
			a = b;
			b = r;
		}
		return a;
	}
}
