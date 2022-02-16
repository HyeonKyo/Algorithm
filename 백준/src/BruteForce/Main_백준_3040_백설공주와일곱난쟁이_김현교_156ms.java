package BruteForce;

import java.io.BufferedReader;	
import java.io.InputStreamReader;
/**
 * 리팩토링 방법 -> 9C7 = 9C2이므로
 * 키를 다 더하고 2개를 뽑아서 뺀 값이 100이면 그것을 제외한 7명을 출력
 * case2
 * sum = -100 -> 입력값 다 더함 -> 나쁜놈 2명의 합이 sum에 있음
 * -> 반복문으로 2명 합이 sum인 경우 찾음
 * */
public class Main_백준_3040_백설공주와일곱난쟁이_김현교_156ms {

	static int[] n;
	static int[] res;
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		n = new int[9];
		for (int i = 0; i < 9; i++) {
			n[i] = Integer.parseInt(br.readLine());
		}
		res = new int[7];
		comb(0, 0, 0);
	}//end main
	
	static void comb(int start, int depth, int sum){
		if (depth >= 7) {
			if (sum == 100) {
				for (int i = 0; i < 7; i++) {
					System.out.println(res[i]);
				}
				System.exit(0);
			}
			return;
		}
		
		for (int i = start; i < 9; i++) {
			res[depth] = n[i];
			comb(i + 1, depth + 1, sum + n[i]);
		}
	}
}//end class
