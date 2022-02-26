package Math1;

import java.util.Scanner;

public class Main_백준_1712_손익분기점{

	public static void main(String[] args) {
		Scanner s = new Scanner(System.in);
		
		int A = s.nextInt();
		int B = s.nextInt();
		int C = s.nextInt();
		
		if (C - B <= 0) {
			System.out.println(-1);
			return ;
		}
		int x = (int)(A / (C - B)) + 1;
		
		System.out.println(x);
	}
}
