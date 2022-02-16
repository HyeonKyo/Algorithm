package Recursive;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main_정올_1459_숫자고르기 {
	
	static int N;
	static int max;
	static int[] save;
	static int equal;
	static int[] num;
	static boolean[] ck;
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		num = new int[N + 1];
		save = new int[N];
		ck = new boolean[N + 1];
		int j = 0;
		for (int i = 1; i <= N; i++) {
			num[i] = Integer.parseInt(br.readLine());
			if (i == num[i]) {
				ck[i] = true;
				save[j++] = i;
				equal++;
			}
		}
		for (int i = 1; i <= N; i++) {
			if (!ck[i]) {
				ck[i] = true;
				search(i, num[i], 1);
				ck[i] = false;
			}
		}
		max += equal;
		System.out.println(max);
		for (int i = 0; i < max; i++) {
			System.out.println(save[i]);
		}
	}//end main
	
	static void search(int start, int val, int size) {
		if (size > N || num[val] == val)
			return;
		if (ck[val]) {
			if (val == start && size > max) {
				max = size;
				int j = 0;
				for (int i = 1; i <= N; i++) {
					if (ck[i])
						save[j++] = i;
				}
			}
			return;
		}
		ck[val] = true;
		search(start, num[val], size + 1);
		ck[val] = false;
	}
}

/*
 * num[i]의 값을 인덱스로 하는 값
 * 반복문으로 i = 1 ~ N까지 
 * ck[N + 1]까지
 * search(start, val, size + 1)
 * val값이 num[start]
 * 재귀 종료는 이미 뽑은 숫자가 val값과 같고, 그 값이 start와 같을 때
 * 만약 인덱스와 값이 동일하면 재귀 보내지 않고 동일값 변수++
 * 1 2 3 4 5 6 7
 * 7 2 7 6 4 3 6
 * 8시 기상 ~ 8시 50분까지 준비
 * 수업듣고 점심먹으며 다시 안 볼 정도로 복습
 * 6시~7시 쉬는시간
 * 7시~9시 공부
 * 9시~10시 운동하고 씻기
 * 10시~11시 공부
 * 11시~12시 자유시간
 * 12시~1시 취침
 */
