package Greedy;

import java.io.BufferedReader;	
import java.io.InputStreamReader;

public class Main_백준_2839_설탕배달 {
		
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		int cnt3 = 0;
		while (N % 5 != 0) {
			N -= 3;
			cnt3++;
		}
		if (N < 0)
			System.out.println(-1);
		else
			System.out.println(cnt3 + N / 5);
	}//end main
}

/* 3, 5kg봉지를 최소한으로 사용하여 N kg을 만들어야 함.
 * 1. 5kg으로 N을 나눔 -> 0이면 그대로 출력, 아니면
 * 2. 5cnt = 그 값, N - 5 * 5cnt를 3으로 나눔 -> 0이면 그 값과 5cnt를 더해서 출력, 아니면
 * 3. 5cnt - 1, 반복
 * 4. 5cnt가 -1이면 종료
 * 
 * 
 * */
