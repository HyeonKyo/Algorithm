package Greedy;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Comparator;
import java.util.StringTokenizer;

public class Main_정올_2499_저울_IM_114ms {
	
	private static int N;
	private static Integer[] w;
	private static boolean[] ck;

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		w = new Integer[N];
		ck = new boolean[100000001];
		StringTokenizer st = new StringTokenizer(br.readLine());
		for (int i = 0; i < N; i++) {
			w[i] = Integer.parseInt(st.nextToken());
			ck[w[i]] = true;
		}
		Arrays.sort(w, Comparator.reverseOrder());
		int num = 1;
		while (true) {
			if (!ck[num]) {
				if (!subset(num, 0, 0))
					break;
			}
			num++;
		}
		int min = 1;
		while (ck[min])
			min++;
		System.out.println(min);
	}//end main
	
	static boolean subset(int num, int sum, int depth) {
		if (depth == N) {
			ck[sum] = true;
			if (sum == num)
				return true;
			return false;
		}
		
		if (subset(num, sum, depth + 1))
			return true;
		if (subset(num, sum + w[depth], depth + 1))
			return true;
		return false;
	}
}