package Math1;

import java.util.Scanner;

public class Main_백준_2292_벌집_108ms {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int N = sc.nextInt();
		
		int k = 0;//떨어진 거리
		int start = 1;//시작점
		while (N > start) {
			k++;
			start += 6 * k;
		}
		System.out.println(k + 1);
	}
}

/*
 * N이 커지는 경우의 시작점 1 2 8 20 38
 * 차이가 1 6 12 18
 * 
 * */
