package Math1;

import java.util.Scanner;

public class Main_����_2292_���� {

	public static void main(String[] args) {
		Scanner s = new Scanner(System.in);
		int N = s.nextInt();
		
		int i = 0;
		int a = 0;
		for (i = 1; N > a; i++) {
			a = 1 + 3 * i * (i - 1);
		}
		System.out.println(i - 1);
	}
}
