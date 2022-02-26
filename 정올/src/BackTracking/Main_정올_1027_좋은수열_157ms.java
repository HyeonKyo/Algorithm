package BackTracking;

import java.util.Scanner;

public class Main_정올_1027_좋은수열_157ms {
	
	static int N;
	static int[] num;
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		N = sc.nextInt();
		sc.close();
		
		num = new int[N];
		back(0);
		
		StringBuilder sb = new StringBuilder();
		for (int i = 0; i < N; i++) {
			sb.append(num[i]);
		}
		System.out.println(sb.toString());
	}//end main
	
	static boolean back(int depth) {
		
		if (!check(depth))
			return false;
		
		if (depth == N)
			return true;
		
		for (int i = 1; i <= 3; i++) {
			num[depth] = i;
			if (back(depth + 1))
				return true;
		}
		return false;
	}
	
	static boolean check(int depth) {
		int half = (depth + 1) / 2;
		for (int len = 1; len <= half; len++) {
			for (int start = len; start <= depth - len; start++) {
				int i = 0;
				for ( ; i < len; i++) {
					if (num[start - len + i] != num[start + i])
						break;
				}
				if (i == len)
					return false;
			}
		}
		return true;
	}
}

/*
 * 재귀적으로 depth위치에 1부터 채워줌
 * depth가 N까지 채워지면 true리턴
 * 도중에 check를 하면서 유효하지 않으면 false리턴
 * 
 * */