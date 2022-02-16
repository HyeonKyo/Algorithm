package BackTracking;

import java.util.Scanner;

public class Main_정올_1027_좋은수열 {
	
	static int N;
	static int[] min;
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		N = sc.nextInt();
		sc.close();
		int[] num = new int[N];
		min = new int[N];
		for (int i = 0; i < min.length; i++) {
			min[i] = 4;
		}
		num[0] = 1;
 		search(num, 1);
		for (int i = 0; i < N; i++) {
			System.out.print(min[i]);
		}
		System.out.println();
	}
	
	static void search(int[] num, int len) {
		if (!checkNum(num, len))
			return;
		if (len >= N) {
			boolean flag = false;
			for (int i = 0; i < len; i++) {
				if (min[i] == num[i]) {
					continue;
				} else if (min[i] > num[i]) {
					flag = true;
				}
				break;
			}
			if (flag) {
				for (int i = 0; i < len; i++) {
					min[i] = num[i];
				}
			}
			return;
		}
		int j = 0;
		int[] tmp = new int[3];
		for (int i = 1; i <= 3; i++) {
			if (num[len - 1] == i)
				continue;
			num[len] = i;
			search(num, len + 1);
		}
	}
	
	static boolean checkNum(int[] num, int len) {
		int cnt = 2;
		int i = len - 1;
		while (cnt <= len / 2) {
			int j = len - 1 - cnt;
			int k = 0;
			while (k < cnt && num[i - k] == num[j - k])
				k++;
			if (k >= cnt)
				return false;
			cnt++;
		}
		return true;
	}
}

/*
 * 1. 반복문 1, 2, 3하나씩 수열에 추가
 * 2. 추가한 수열이 좋은수열인지 확인
 * 	-> 로직 어떻게?
 * 	32121 
 * 		-> 4 3이 같은지체크
 * 		-> 43 + 21이 같은지 체크
 * 		-> 432 + 1.. -> 종료 
 * 3. 수열 길이 N이면 종료
 * 4. 그 수열을 List에 저장
 * 5. 최솟값 출력
 * 
 * */