package BruteForce;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main_백준_2810_컵홀더_김현교_B2_76ms {
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		int max = N;
		int cnt = -1;
		String s = br.readLine();
		for (int i = 0; i < N; i++) {
			if (s.charAt(i) == 'S')
				continue;
			cnt++;
			i++;
		}
		if (cnt > 0)
			System.out.println(max - cnt);
		else
			System.out.println(max);
	}//end main
}
