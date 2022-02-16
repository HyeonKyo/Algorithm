package DataStructure;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main_정올_1141_불쾌한날_324ms {
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		int[] input = new int[N];
		for (int i = 0; i < N; i++) {
			input[i] = Integer.parseInt(br.readLine());
		}
		
		int[] stackH = new int[N];
		int[] stackI = new int[N];
		int curH = 0;
		int curI = 0;
		for (int i = N - 1; i >= 0; i--) {
			int num = input[i];
			input[i] = 0;
			while (curH > 0 && stackH[curH - 1] < num) {
				input[i] += 1;
				curH--;
				input[i] += input[stackI[--curI]];
			}
			stackH[curH++] = num;
			stackI[curI++] = i;
		}
		long sum = 0;
		for (int i = 0; i < input.length; i++) {
			sum += input[i];
		}
		System.out.println(sum);
	}
}
/*
 * 스택 안의 나보다 작은 키의 명수 + 그 작은 키를 가진 소가 보는 머리수
 * 
 * */
