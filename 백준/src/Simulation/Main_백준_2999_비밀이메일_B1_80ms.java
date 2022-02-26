package Simulation;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main_백준_2999_비밀이메일_B1_80ms {
	
	public static void main(String[] args) throws Exception {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String msg = br.readLine();
		
		int N = msg.length();
		int base = (int)Math.sqrt(N);
		int R = 1;
		int C = 0;
		while (R <= base) {
			if (N % R == 0)
				C = N / R;
			R++;
		}
		R = N / C;
		
		StringBuilder sb = new StringBuilder();
		for (int i = 0; i < R; i++) {
			for (int j = 0; j < C; j++) {
				sb.append(msg.charAt(i + R * j));
			}
		}
		System.out.println(sb.toString());
	}//end main
}
