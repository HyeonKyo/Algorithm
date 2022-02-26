package StringSearch;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;

public class Main_백준_1305_광고_P4_484ms {
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int L = Integer.parseInt(br.readLine());
		char[] pattern = br.readLine().toCharArray();
		int len = pattern.length;
		int[] pi = new int[len];
		
		for (int i = 1, j = 0; i < len; i++) {
			while (j > 0 && pattern[j] != pattern[i])
				j = pi[j - 1];
			
			if (pattern[j] == pattern[i])
				pi[i] = ++j;
			else
				pi[i] = 0;
		}
		
		int max = 0;
		int maxIdx = 0;
		for (int i = 0; i < pi.length; i++) {
			if (pi[i] >= max) {
				max = pi[i];
				maxIdx = i;
			}
		}
		System.out.println(maxIdx + 1 - max);
	}//end main
}
