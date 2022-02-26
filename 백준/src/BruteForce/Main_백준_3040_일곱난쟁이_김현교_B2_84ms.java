package BruteForce;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
/**
 * 리팩토링 방법 -> 9C7 = 9C2이므로
 * 키를 다 더하고 2개를 뽑아서 뺀 값이 100이면 그것을 제외한 7명을 출력
 * case2
 * sum = -100 -> 입력값 다 더함 -> 나쁜놈 2명의 합이 sum에 있음
 * -> 반복문으로 2명 합이 sum인 경우 찾음
 * */
public class Main_백준_3040_일곱난쟁이_김현교_B2_84ms {

	static int[] n;
	static int[] res;
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		n = new int[9];
		int find = -100;
		for (int i = 0; i < 9; i++) {
			n[i] = Integer.parseInt(br.readLine());
			find += n[i];
		}
		Arrays.sort(n);
		res = new int[7];
		comb(0, 0, 0, find);
	}//end main
	
	static void comb(int start, int depth, int sum, int find){
		if (depth >= 2) {
			if (sum == find) {
				for (int i = 0, j = 0; i < 9; i++) {
					if (n[i] == res[j]) {
						j++;
						continue;
					}
					System.out.println(n[i]);
				}
				System.exit(0);
			}
			return;
		}
		
		for (int i = start; i < 9; i++) {
			res[depth] = n[i];
			comb(i + 1, depth + 1, sum + n[i], find);
		}
	}
}//end class
