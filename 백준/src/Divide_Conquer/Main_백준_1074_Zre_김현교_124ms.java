package Divide_Conquer;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/**
 * 더 최적화 하는 방법
 * 1. 재귀 초반에 정답이 범위 내에 없으면 계산만 하고 재귀호출 부르지 않도록
 * 2. pow를 비트연산으로
 * 3. pow를 해싱기법으로!!!
 * 	1. N의 범위는 15이므로 2^0 ~ 2^15까지를 반복문으로 출력시킴 1,2,4,8,...
 *  2. 그 출력 값을 배열에 저장하여 N을 인덱스로 쓰면 바로 값 가져올 수 있도록 만듬
 * 
 * */

public class Main_백준_1074_Zre_김현교_124ms {
	
	static int N, R, C, num, result;
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		R = Integer.parseInt(st.nextToken());
		C = Integer.parseInt(st.nextToken());
		
		find(0, 0, 1 << N);
		System.out.println(result);
	}//end main
	
	static void find(int l, int r, int size) {
		if (result > 0)
			return;
		if (size <= 2) {
			if ((l == R || l + 1 == R) && (r == C || r + 1 == C)) {
				num += 2 * (R - l) + C - r;
				result = num;
			} else {
				num += 4;
			}
			return;
		}
		
		int half = size / 2;
		find(l, r, half);
		find(l, r + half, half);
		find(l + half, r, half);
		find(l + half, r + half , half);
	}
}//end class