package Simulation;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main_백준_8320_직사각형을만드는방법_B2_80ms {
	
	public static void main(String[] args) throws Exception {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		int cnt = 0;
		for (int i = 1; i <= N; i++) {
			cnt += 1 + isPossible(i);
		}
		System.out.println(cnt);
		
	}//end main
	
	static int isPossible(int n) {
		int base = (int)Math.sqrt(n);
		int cnt = 0;
		for (int i = 2; i <= base; i++) {
			if (n % i == 0)
				cnt++;
		}
		return cnt;
	}
}

