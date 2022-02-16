package Divide_Conquer;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/** 
 * 재귀함수 작성
 * N 15, 사각형의 한변의 최대 크기 2^15, 사각형 면적의 최대 크기 2^15 * 2^15 = 2^30 = 10억
 * 재귀함수 최대 콜 스택 뎁스 15~16회
 * 재귀함수 호출 회수가 최대 10억이라서 시간 아슬아슬
 * 	=> 예상 할 수 있는 부분의 재귀호출은 생략하자
 */
public class Main_백준_1074_Z1_교수님{
	
	private static int r;
	private static int c;
	private static int answer = 0;
	private static int[] bin = {1,2,4,8,16,32,64,128,256,512,1024,2048,4096,8192,16384,32768}; // 별도파일에서 출력해서 복붙하기
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		int N = Integer.parseInt(st.nextToken()); // 1 <= N <= 15
		r = Integer.parseInt(st.nextToken()); // 0 <= r, c >= 2^N
		c = Integer.parseInt(st.nextToken()); // 0 <= r, c >= 2^N
		go(N, 0, 0);
	} // end of main
	/** 사각형의 가로세로 크기 =2^N, 사각형의 시작위치 (sr, sc) */
	public static void go(int n, int sr, int sc) {
		// 예상 할 수 있는 부분의 재귀호출은 생략하자 : 사각영역에 r,c가 포함되지 않으면 계산만 하고 넘어가자
		if (r < sr || sr + bin[n] <= r || c < sc || sc + bin[n] <= c) { // 사각영역 밖이면
			answer += bin[n] * bin[n];
			return;
		}
		if (n == 0) {
			if (sr == r && sc == c) {
				System.out.println(answer);
				System.exit(0); // 프로그램 종료
			}
			answer++;
			return;
		}
		
		go(n-1, sr			 , sc			); // 좌상
		go(n-1, sr			 , sc + bin[n-1]); // 우상
		go(n-1, sr + bin[n-1], sc			); // 좌하
		go(n-1, sr + bin[n-1], sc + bin[n-1]); // 우하
	}
//	(int)Math.pow(2, n) => 2^n 반복문으로 구현 => 2^n 분할정복으로 구현 => 1 << n 비트연산 => hashing
	public static int mypow(int ex) {
		int result = 1;
		for (int i = 0; i < ex; i++) {
			result *= 2;
		}
		return result;
	}
}//end class